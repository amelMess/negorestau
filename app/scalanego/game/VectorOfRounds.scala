// Copyright (C) Maxime Morge 2015
package scalanego.game

import akka.actor._
import collection.mutable.HashSet
import collection.mutable.HashMap
import scala.util.Sorting
import scalanego.decisionproblem._

object UpdateException extends Exception { }

/*
 * @author Maxime Morge
 * @version 2015-10-25
 * Class to represent a vector of rounds
 */
class VectorOfRounds(name: String, alternatives : HashSet[Alternative]) extends HashMap[Alternative,HashMap[ActorRef,Int]]{

  private val debug = false
  private var participants = new HashMap[ActorRef, String]()

  for(a <- alternatives){
    this += (a -> new HashMap[ActorRef,Int]())
  }

  def doNothing() : Unit = {}

  //Update the vector of rounds with the alternatives proposed by a participant
  //at a certain round
  def update(alternatives: HashSet[Alternative], round: Int, participant: ActorRef){
    try {
      for (a <- alternatives){
        this.get(a) match {
          case Some (k) => k+= (participant -> round)
          case None => throw UpdateException //println("Problem in updating vector of round")
        }
      }
    }catch{
        case UpdateException => doNothing
      }
  }

  //Set the participants
  def setParticipant(participants: HashMap[ActorRef, String]) ={ this.participants=participants} 

  //Returns the alternatives proposed by all the agents
  def commons(nbParticipants: Int) : HashSet[Alternative] ={
    var commons = new HashSet[Alternative]()
    this.foreach{
      case (alt, map)=> if (map.size == nbParticipants) commons+=alt
    }
    return commons
  }

  //Returns the leximax of commons alternatives between the participants
  def leximax(commons: HashSet[Alternative], participants: HashMap[ActorRef, String]) : HashSet[Alternative] ={
    var candidats=commons
    var i = participants.size-1;
    //We delete the candidats such that the vectors of rounds is not leximin
    while ( (candidats.size!=1) && (i>=0)){
      var min = Int.MaxValue
      var leximin = new HashSet[Alternative]()
      for (alt <- candidats){       
        var map= this.get(alt).getOrElse(throw new RuntimeException("The alternative "+alt+" is not in the history"))
        var rounds = map.values.toArray
        Sorting.quickSort(rounds)
        if (debug) println(name+" alt:"+alt+" rounds:"+rounds.deep.mkString(" "))
	var ir = rounds(i)
	if (ir < min){
	  min = ir
	  leximin= new HashSet[Alternative]()
	  leximin+=alt
	}else if (ir==min){
	  leximin+=alt
	}
      }
      i-=1;
      candidats= candidats.intersect(leximin);
    }
    return candidats;
  }

  //Show the vector of rounds
  override def toString() : String ={
    var res = new String()
    this.foreach{
      case (a : Alternative, map: HashMap[ActorRef,Int]) =>
        res+=name+": "+a+" : "
        map.foreach{
          case (actor: ActorRef, rank: Int) =>
          var agentName=participants.getOrElse(actor,"none")
          res+=rank+"("+agentName+") "
        }
        res+="\n"
    }
    return res
  }

}


