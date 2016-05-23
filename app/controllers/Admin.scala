package controllers

import models._
import controllers._
import scalanego.db._
import scalanego.game._

import play.api._
//import play.api.db._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.Play.current
import play.api.mvc.BodyParsers._

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.concurrent.Await
import org.postgresql.util.PSQLException

import akka.util.Timeout
import akka.actor.{Actor, ActorRef, ActorSystem, Inbox, Props}
import akka.event.LoggingReceive
import akka.pattern.ask

object Admin extends Controller with Secured{

  //create an instance of the table
  val users = TableQuery[UserTable]
  val choices = TableQuery[ChoiceTable]
  val problems = TableQuery[ProblemTable]
  val contains = TableQuery[ContainsTable]
  val prefer = TableQuery[PreferTable]
  val admissibleChoice = TableQuery[AdmissibleChoiceTable]

  implicit val session = play.api.db.slick.DB.createSession
  implicit val timeout: Timeout = 10.seconds

  def listParticipants(problemId:Int)(implicit session: play.api.db.slick.Config.driver.simple.Session): List[(String, String)] = {
      val usersIds = admissibleChoice.filter(a => a.idProblem === problemId)
                                    .map(a => a.idUser)
      val usersInfo = (usersIds join users on (_ === _.id))
       .map{ case (ui, u) => (u.firstname, u.lastname)}.list
       usersInfo.distinct
  }  

  def admin = withAuth { username => implicit request =>
    
    val idUser = users.filter(u => u.email===username).list.head.id
    val idProblemStr = (request.session.get("idProblem")).getOrElse("error")
    
    //On vérifie que la session contient l'id du problème
    if(idProblemStr.equals("error"))
      Redirect(routes.Index.index)
    else {  
      val idProblem = idProblemStr.toInt
      val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
      val infoProblem =  problems.filter(p => p.id === idProblem).map{ case(p) => (p.id, p.description, p.dateCreation, p.deadline, p.detail, p.idUser)}.list
                                                                 .map{ case(p) => (p._1, p._2, format.format(p._3).toString, format.format(p._4), p._5, p._6)}.head

      //On vérifie que l'utilisateur courant est bien le créateur du problème
      if(infoProblem._6 != idUser) {
        Redirect(routes.Index.index)
      } else {


        Ok(views.html.administrationProblem(infoProblem, listParticipants(idProblem)))
      }
    }
  }
  def deleteProblem = withAuth { username => implicit request =>
    val idUser = users.filter(u => u.email===username).list.head.id
    val idProblemStr = (request.session.get("idProblem")).getOrElse("error")
    
    //On vérifie que la session contient l'id du problème
    if(idProblemStr.equals("error"))
      Redirect(routes.Index.index)
    else {  
      val idProblem = idProblemStr.toInt
      val infoProblem =  problems.filter(p => p.id === idProblem).map{ case(p) => (p.idUser)}.list.head

      //On vérifie que l'utilisateur courant est bien le créateur du problème
      if(infoProblem != idUser) {
        Redirect(routes.Index.index)
      } else {

        //Suppression du problème (admissibleChoice, prefer, contains, problem)
        val deleteAdmissible = admissibleChoice.filter(p=> p.idProblem === idProblem)
        deleteAdmissible.delete
        val deletePrefer = prefer.filter(p=> p.idProblem === idProblem)
        deletePrefer.delete
        val deleteContains = contains.filter(c=> c.idProblem === idProblem)
        deleteContains.delete
        val deleteProblem = problems.filter(p=> p.id === idProblem)
        deleteProblem.delete

        Redirect(routes.Index.index)
      }
    }

  }

  def resolve = withAuth { username => implicit request =>
    val idUser = users.filter(u => u.email===username).list.head.id
    val idProblemStr = (request.session.get("idProblem")).getOrElse("error")
    
    //On vérifie que la session contient l'id du problème
    if(idProblemStr.equals("error"))
      Redirect(routes.Index.index)
    else {  
      val idProblem = idProblemStr.toInt
      val infoProblem =  problems.filter(p => p.id === idProblem).map{ case(p) => (p.idUser)}.list.head

      //On vérifie que l'utilisateur courant est bien le créateur du problème
      if(infoProblem != idUser) {
        Redirect(routes.Index.index)
      } else {

        val system = ActorSystem("Main")
        val loaderRef = system.actorOf(Props(new Loader(idProblem)), "loader")
        val future = loaderRef ? Start
        Await.result(future.mapTo[ThatAllFolk], 10 seconds)
        
        Redirect(routes.Index.index)        
      }
    }
  }
  
}
