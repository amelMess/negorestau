// Copyright (C) Maxime Morge 2015
package scalanego.game

import akka.actor._
import scala.concurrent.duration._
import collection.mutable.HashSet
import collection.mutable.HashMap
import scalanego.decisionproblem._

import akka.event.LoggingReceive
import com.typesafe.config._

abstract class Move
case class InformParticipants(participants: HashMap[ActorRef, String]) extends Move
case class OkParticipant() extends Move
case class Start() extends Move
case class End(ids : Set[String]) extends Move
case class Shutdown() extends Move
case class Propose(alternatives: HashSet[Alternative]) extends Move
case class Accept(alternatives: HashSet[Alternative]) extends Move
case class ThatAllFolk(id : Int) extends Move

/*
 * @author Maxime Morge
 * @version 2015-10-24
 * Class to represent a negotiator
 */
class Negotiator(name: String, pb: DecisionProblem) extends Actor {

  private val debug = false
  private var participants = new HashMap[ActorRef, String]()
  private val reasoning = new Reasoning(pb)
  private var released= new HashSet[Alternative]()

  private var vectorOfRounds = new VectorOfRounds(name,pb.alternatives)
  private var round=1;
  private var nbWaitingProposals=0

  def receive = LoggingReceive {
    case InformParticipants(neighboors) =>
      participants=neighboors
      vectorOfRounds.setParticipant(participants)
      sender ! OkParticipant
    case Start =>
      propose
      nbWaitingProposals=participants.size
      context.become(evaluator)
    case Shutdown =>
      if (debug) println(name+" is dead")
      context.stop(self)
    case _ => println("Negociator does not understand the message")
  }

  def evaluator: Actor.Receive = LoggingReceive {
    case Propose(alternatives) =>
      //update vectorOfRounds
      vectorOfRounds.update(alternatives,round,sender)
      nbWaitingProposals-=1
      if (nbWaitingProposals==0){
        round+=1
        nbWaitingProposals=participants.size
        //Check acceptability
        val commons= vectorOfRounds.commons(participants.size)
        if (!commons.isEmpty){
          if (debug) {
            println(name+": vector of rounds")
            println(vectorOfRounds)
          }
          val agreements=vectorOfRounds.leximax(commons, participants)
          println(name+" accepts at round "+round+" : "+agreements)
          broadcast(Accept(agreements))
          var decisions = Set[String]()
          agreements.foreach(alt => decisions = decisions + alt.name)
          context.parent ! End(decisions)
        }else propose()
      }
    case Accept(alternatives) =>
      if (debug) println(participants(sender)+" is informed that"+sender+" accepts "+alternatives)
    case Shutdown =>
      if (debug) println(name+" is dead")
      context.stop(self)

    case _ => println("Negociator does not understand the message")
  }

  // Utters rational proposals
  def propose() = {
    val proposals = reasoning.nonDominated(pb.alternatives -- released)
    println(name+" proposes at round "+round+" : "+proposals)
    broadcast(Propose(proposals))
    released ++= proposals
  }

  //Broadcast a message
  def broadcast(m : Move) = {
    participants.foreach{
      case (participant:ActorRef, name: String) => participant ! m
    }
  }

}

class Negotiation extends Actor {
  private val debug=false

  /*
  private val alternatives=Set("a","b","c","d","e","f")
  private val pb1 = new DecisionProblem(alternatives)
  pb1.add("a","b")
  pb1.add("b","a")
  pb1.add("a","d")
  pb1.add("a","e")
  pb1.add("c","e")
  pb1.add("e","f")
  if (debug) println("Negociator1")
  if (debug) println(pb1)
  private val pb2 = new DecisionProblem(alternatives)
  pb2.add("c","d")
  pb2.add("d","f")
  pb2.add("e","f")
  pb2.add("f","e")
  pb2.add("e","a")
  pb2.add("e","b")
  if (debug) println("Negociator2")
  if (debug) println(pb2)
  private val pb3 = new DecisionProblem(alternatives)
  pb3.add("b","e")
  pb3.add("a","f")
  pb3.add("e","f")
  pb3.add("f","e")
  pb3.add("e","d")
  pb3.add("d","c")
  pb3.add("a","c")
  if (debug) println("Negociator3")
  if (debug) println(pb3)
  */

  private val alternatives=Set("a","b","c")
  private val alternatives2=Set("a","b")
  private val alternatives3=Set("a","c")
  private val pb1 = new DecisionProblem(alternatives)
  pb1.add("a","b")
  pb1.add("b","c")
  if (debug) println("Negociator1")
  if (debug) println(pb1)
  private val pb2 = new DecisionProblem(alternatives2)
  pb2.add("b","a")
  if (debug) println("Negociator2")
  if (debug) println(pb2)
  private val pb3 = new DecisionProblem(alternatives3)
  pb3.add("c","a")
  if (debug) println("Negociator3")
  if (debug) println(pb3)


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

  if (debug) println("Initiate of negotiator")
  private var participants= new HashMap[ActorRef, String]
  private val negotiator1 = context.actorOf(Props(new Negotiator("Negotiator1",pb1)), name = "Negotiator1")
  private val negotiator2 = context.actorOf(Props(new Negotiator("Negotiator2",pb2)), name = "Negotiator2")
  private val negotiator3 = context.actorOf(Props(new Negotiator("Negotiator3",pb3)), name = "Negotiator3")
  participants+= (negotiator1 -> "n1")
  participants+= (negotiator2 -> "n2")
  participants+= (negotiator3 -> "n3")


  if (debug) println("Inform about the participants")
  negotiator1 ! InformParticipants(participants)
  negotiator2 ! InformParticipants(participants)
  negotiator3 ! InformParticipants(participants)

  if (debug) println("Start negotiators")
  negotiator1 ! Start
  negotiator2 ! Start
  negotiator3 ! Start

  var finishedNegotiator = 0
  val nbNegotiator=3
  def receive = LoggingReceive {
    case End =>      
      sender ! Shutdown
      finishedNegotiator+=1      
      if (finishedNegotiator==nbNegotiator){
        if (debug) println("Supervisor is dead")
        context.stop(self)
        System.exit(0)
      }
    case OkParticipant =>

    case _ => println("Supervisor does not understand the message")
  }

}
