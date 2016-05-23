// Copyright (C) Maxime Morge 2015
package scalanego.db

import scala.util.Random

import akka.actor.{Actor, ActorRef, ActorSystem, Inbox, Props}
import com.typesafe.config.{Config, ConfigFactory}

import slick.driver.PostgresDriver.simple._
import java.sql.Date

import akka.event.LoggingReceive

import scala.collection.mutable.HashMap
import scalanego.decisionproblem._
import scalanego.game._




/*
 * @author Maxime Morge
 * @version 2015-04-26
 * Class to run
 */
object Runner extends App{
  val debug = true
  var pb=1
  if (args.length>=1) pb=args(1).toInt
  //Set up Actor system
  var config: Config = ConfigFactory.parseString("""akka {
         loglevel = "OFF"
         actor {
           debug {
             receive = off
         }
       }
       }""").withFallback(ConfigFactory.load())

  if (debug) config = ConfigFactory.parseString("""akka {
         loglevel = "DEBUG"
         actor {
           debug {
             receive = on
          }
       }
     }""").withFallback(ConfigFactory.load())//on
  private val system = ActorSystem("Negotiation",config)
  val inbox = Inbox.create(system)// Create an "actor-in-a-box"
  val loader = system.actorOf(Props(new Loader(pb)), name = "loader")
  loader ! Start
  //Thread.sleep(6000)
  //System.exit(0)

}



/*
 * @author Maxime Morge
 * @version 2015-04-26
 * Class to set up a negotiation
 */
class Loader(pb : Int) extends Actor {
  val debug = true
  var boss : ActorRef = _

  // Table
  case class User(id: Int, lastname: String, firstname: String, email: String, password: String,
  adress: String, role: String)
  class UserTable(tag: Tag) extends Table[User](tag, "user_prob") {
    def id = column[Int]("id_user_prob", O.PrimaryKey)
    def lastname = column[String]("last_name")
    def firstname = column[String]("first_name")
    def email = column[String]("email")
    def password = column[String]("password")
    def adress = column[String]("adress")
    def role = column[String]("role")

    def * = (id, lastname, firstname, email, password, adress, role) <> (User.tupled, User.unapply _)

  }

  case class Choice(id: Int, name: String, description: String, url: String)
  class ChoiceTable(tag: Tag) extends Table[Choice](tag, "choice") {

    def id = column[Int]("id_choice", O.PrimaryKey)
    def name = column[String]("choice_name")
    def description = column[String]("description_choice")
    def url = column[String]("url")

    def * = (id, name, description, url) <> (Choice.tupled, Choice.unapply _)

  }

  case class Problem(id: Int, nom: String, description: String, dateCreation: Date, deadline: Date, idUser: Int, solution: Int)
  class ProblemTable(tag: Tag) extends Table[Problem](tag, "problem") {

    def id = column[Int]("id_problem", O.PrimaryKey)
    def description = column[String]("description")
    def detail = column[String]("detail")
    def dateCreation = column[Date]("date_creat")
    def deadline = column[Date]("deadline")
    def idUser = column[Int]("id_user_prob", O.NotNull)
    def solution = column[Int]("solution")

    def * = (id, description, detail, dateCreation, deadline, idUser, solution) <> (Problem.tupled, Problem.unapply _)

  }

  case class Contains(idProblem: Int, idChoice: Int)
  class ContainsTable(tag: Tag) extends Table[Contains](tag, "contains") {
    def idProblem = column[Int]("id_problem", O.NotNull)
    def idChoice = column[Int]("id_choice", O.NotNull)

    def * = (idProblem, idChoice) <> (Contains.tupled, Contains.unapply _)

  }

  case class Prefer(idChoiceDominant: Int, idProblem: Int, idUser: Int,idChoiceDominated: Int)
  class PreferTable(tag: Tag) extends Table[Prefer](tag, "prefer") {

    def idChoiceDominant = column[Int]("id_choice_dominant", O.NotNull)
    def idProblem = column[Int]("id_problem", O.NotNull)
    def idUser = column[Int]("id_user_prob", O.NotNull)
    def idChoiceDominated = column[Int]("id_choice_dominated", O.NotNull)

    def * = (idChoiceDominant, idProblem, idUser, idChoiceDominated) <> (Prefer.tupled, Prefer.unapply _)

  }

  case class AdmissibleChoice(idProblem: Int, idUser: Int, idChoice: Int)
  class AdmissibleChoiceTable(tag: Tag) extends Table[AdmissibleChoice](tag, "admissible_choice") {

    def idProblem = column[Int]("id_problem", O.NotNull)
    def idUser = column[Int]("id_user_prob", O.NotNull)
    def idChoice = column[Int]("id_choice", O.NotNull)

    def * = (idProblem, idUser, idChoice) <> (AdmissibleChoice.tupled, AdmissibleChoice.unapply _)

  }




  val user=TableQuery[UserTable]
  val problem=TableQuery[ProblemTable]
  val alternative=TableQuery[ChoiceTable]
  val choice=TableQuery[ContainsTable]
  val admissibleChoice=TableQuery[AdmissibleChoiceTable]
  val preference=TableQuery[PreferTable]

  //val pb=1
  println("Pb : " + pb.toString)

  // Load the data
  if (debug) println("Load the data")
  //val db = Database.forConfig("mydb")
  val db = Database.forURL("jdbc:postgresql://localhost:5432/negorestau?user=postgres&password=PJI2016&characterEncoding=UTF-8",
    driver = "org.postgresql.Driver")

  //Title of the problem
  var title="Sans titre"
  val queryTitle = problem.filter(p => p.id===pb).map(p => (p.id,p.description))
  val resultTitle = db.withSession { implicit session =>
    queryTitle.run.foreach { case (id, description) =>
      title=description
    }
  }
  // List of participants
  //SELECT last_name, COUNT(id_choice) AS options
  // FROM admissible_choice JOIN user_prob ON user_prob.id_user_prob = admissible_choice.id_user_prob
  // WHERE id_problem=1 GROUP BY last_name
  // HAVING count(id_choice) >0;
  var participants= Map[Int,String]()
  val selectedChoices = admissibleChoice.filter(c => c.idProblem===pb).map( c => (c.idUser, c.idChoice) )
  val groupedChoices = selectedChoices.groupBy(c => c._1 ).map{ case (idUser, group) => (idUser, group.map(_._2).countDistinct) }
  val havingChoices = groupedChoices.filter{ case (idUser, nbchoice) => nbchoice >=1  }
  val joinParticipant = havingChoices  join user on (_._1 === _.id)
  val filteredParticipant = joinParticipant.map { case (nbchoice,user) => (user.id, user.lastname) }
  val resultParticipant = db.withSession { implicit session =>
    participants=  filteredParticipant.run.toMap//.distinct
  }
  if (debug) println("participants: "+ participants)

  if (participants.size<=1){
    println("At least 2 participants are required for a negotiation")
    System.exit(-1)
  }

  // List of choices
  var choices = Map[Int,String]()
  val queryChoice = (choice.filter(c => c.idProblem===pb) join alternative on (_.idChoice === _.id)).map{ case (choice,alt) => (choice.idChoice,alt.name) }
  val resultChoice =  db.withSession { implicit session =>
    choices = queryChoice.run.toMap
  }
  if (debug) println("choices: "+choices)

  if (choices.size<=1){
    println("At least 2 choices are required for a negotiation")
    System.exit(-1)
  }

  var negotiators= new HashMap[ActorRef, String]

  participants.foreach{ case (idParticipant, name) =>
    if (debug) println("Participant: "+name+" ("+idParticipant+") ")
    var admissibleChoices = Map[Int,String]()
    val queryAdmissibleChoices =  ((admissibleChoice.filter(c => c.idProblem===pb && c.idUser===idParticipant))
      join alternative on (_.idChoice === _.id)).map{ case (choice,alt) => (choice.idChoice,alt.name) }
    val resultAdmissibleChoices= db.withSession { implicit session =>
      admissibleChoices= queryAdmissibleChoices.run.toMap
    }
    if (debug) println("Admissible choices: "+admissibleChoices)
    val decisionProblem= new DecisionProblem(admissibleChoices.values.toSet)

    var arrows= List[(Int,Int)]()
    val queryPreferences= preference.filter(p => p.idProblem===pb && p.idUser===idParticipant).map(p => (p.idChoiceDominant,p.idChoiceDominated))
    val resultPreference = db.withSession{ implicit  session =>
      arrows = queryPreferences.run.toList
    }
    if (debug) println("Arrows: "+arrows)
    arrows.foreach{ case (idDominant, idDominated) =>
      val nameDominant= admissibleChoices.get(idDominant).getOrElse("default")
      val nameDominated= admissibleChoices.get(idDominated).getOrElse("default")
      decisionProblem.preferences.add(decisionProblem.get(nameDominant),
        decisionProblem.get(nameDominated))
    }
    // TODO
    if (debug) println("DecisionProblem: "+decisionProblem)
    val negotiator = context.actorOf(Props(new Negotiator(name,decisionProblem)), name = name)//system
    negotiators+= (negotiator -> name)
  }

  if (debug) println("Inform about the participants")
  negotiators.keys.foreach{case actor => actor ! InformParticipants(negotiators)}

  var finishedNegotiator = 0
  val nbNegotiator= negotiators.size

  def receive = LoggingReceive {
    case Start =>
      if (debug) println("Start the participants")
      negotiators.keys.foreach{case actor => actor ! Start}
      boss=sender
    case End(decisions) =>
      sender ! Shutdown
      finishedNegotiator+=1
      if (finishedNegotiator==nbNegotiator){
        if (debug) println("The set of agreements is: "+decisions)
        val decision = decisions.toList(Random.nextInt(decisions.size))
        if (debug) println("The solution picked up is: "+decision)
        //Updtate the database
        db.withSession { implicit session =>
          val queryUpdate = problem.filter(p => p.id === pb).map(p => p.solution)
          queryUpdate.foreach{ truc =>
            if (debug) println("Query update: "+truc)
          }

          val default = (0,"Solution not found")
          val id= choices.find(_._2.equals(decision)).getOrElse(default)._1
          if (debug) println("Id found: "+id)
          val updateAction = queryUpdate.update(id)
          // Get the statement without having to specify an updated value:
          val sql = queryUpdate.updateStatement
          queryUpdate.foreach{ truc =>
            if (debug) println("Query update: "+truc)
          }
          boss ! ThatAllFolk(id)
        }
        if (debug) println("Supervisor is dead")

        context.stop(self)
      }
    case OkParticipant =>
    case _ => println("Supervisor does not understand the message")
  }

}
