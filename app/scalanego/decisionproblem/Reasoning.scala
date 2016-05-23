// Copyright (C) Maxime Morge 2015
package scalanego.decisionproblem

import collection.mutable.HashMap
import collection.mutable.HashSet
//import scala.util.control.Breaks._

object AllDone extends Exception { }

/*
 * @author Maxime Morge
 * @version 2015-10-24
 * Class to reason about a (large and partial) preference relation
 */
class Reasoning(pb : DecisionProblem){
  val debug = false
  def doNothing() : Unit = {}

  //Returns the non-dominated alternatives among the possible ones 
  def nonDominated(possibles: HashSet[Alternative]) : HashSet[Alternative] = {
    var nonDominated :  HashSet[Alternative] = possibles.clone()
    for (a <- nonDominated){
      try {
      for(b<- nonDominated){
        if (pb.preferences.isStrictlyPreferred(b,a)){
          if (debug) println("Remove "+a+" which is dominated by "+b)
          nonDominated -= a
          throw AllDone
        }
      }
      }catch{
        case AllDone => doNothing
      }
    }
    return nonDominated
  }

}
