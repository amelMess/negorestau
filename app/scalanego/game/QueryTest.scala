package scalanego.game

import akka.actor._
import scala.concurrent.duration._

case class Query()
case class Ok()
//case class Start()
//case class End()
//case class Kill()
 
class Responder(supervisor: ActorRef) extends Actor {
  private var sleep=true
  def receive = {
    case Query =>
      if (sleep) sleep=false
      else sender ! Ok
    case Kill =>
      context.stop(self)
    case _ => println("Responder does not understand the message")
  }
}

class Initiator(supervisor: ActorRef, responder : ActorRef) extends Actor {
  def receive = {
    case Start =>
      responder ! Query
      context.setReceiveTimeout(1 seconds)
    case Ok =>
      println("Ok received")
      supervisor ! End
    case Kill =>
      context.stop(self)
    case ReceiveTimeout =>
      println("Initiator does not receive the answer before the time out")
      responder ! Query
      context.setReceiveTimeout(1 seconds)
    case _ =>
      println("Initiator does not understand the message")
  }
}


class QueryTest extends Actor {
  private val system = ActorSystem("QueryTestSystem")
  private val myResponder = system.actorOf(Props(new Responder(self)), name = "myResponder")
  private val myInitiator = system.actorOf(Props(new Initiator(self,myResponder)), name = "myInitiator")
  myInitiator ! Start

  def receive = {
    case End =>
      myResponder ! Kill
      myInitiator ! Kill
      context.stop(self)
    case _ => println("Supervisor does not understand the message")
  }

}
