// Copyright (C) Maxime Morge 2015
package scalanego.decisionproblem


import collection.mutable.HashSet

/*
 * @author Maxime Morge
 * @version 2015-10-24
 * Class to represent a single agent decision problem
 */
class DecisionProblem(names: Set[String]){

  var alternatives= new HashSet[Alternative]()
  var i=0
  for(name<- names){
    val alt=new Alternative(i, name)
    alternatives += alt
    i+=1
  }
  var preferences = new Preference(alternatives)

  def add(a: Alternative, b : Alternative) = preferences.add(a, b)

  def add(aname: String, bname: String) : Unit = {
    val a = get(aname)
    val b = get(bname)
    preferences.add(a, b)
    }

  def get(name: String) : Alternative = {
    alternatives.find((a: Alternative) => a.name.equals(name)).getOrElse(throw new RuntimeException("The alternative "+name+" is not in the decision problem"))
  }

  def get(id: Int) : Alternative = {
    alternatives.find((a: Alternative) => a.id.equals(id)).getOrElse(throw new RuntimeException("The alternative "+id+" is not in the decision problem"))
  }


  override def toString() : String = preferences.toString//alternatives.mkString(" ")
}

/*
object DecisionProblem extends App{
  val alternatives=Set("a","b","c","d","e","f")
  val pb1 = new DecisionProblem(alternatives)
  pb1.add("a","b")
  pb1.add("b","a")
  pb1.add("a","d")
  pb1.add("a","e")
  pb1.add("c","e")
  pb1.add("e","f")
  println(pb1)

  val pb2 = new DecisionProblem(alternatives)
  pb2.add("c","d")
  pb2.add("d","f")
  pb2.add("e","f")
  pb2.add("f","e")
  pb2.add("e","a")
  pb2.add("e","b")
  println(pb2)

  val pb3 = new DecisionProblem(alternatives)
  pb3.add("b","e")
  pb3.add("a","f")
  pb3.add("e","f")
  pb3.add("f","e")
  pb3.add("e","d")
  pb3.add("d","c")
  pb3.add("a","c")
  println(pb3)
  println(pb3.preferences.showAdjacencyMatrix)
}
*/
