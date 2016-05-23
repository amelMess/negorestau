// Copyright (C) Maxime Morge 2015
package scalanego.decisionproblem

import collection.mutable.HashMap
import collection.mutable.HashSet

/*
 * @author Maxime Morge
 * @version 2015-10-24
 * Class to represent a (large and partial) preference relation
 */
class Preference(alternativeSet: HashSet[Alternative]){

  val debug =false

  // Constructor
  var alternatives = new HashMap[Int, Alternative]()
  for(alternative<- alternativeSet){
    alternatives += (alternative.id -> alternative)
  }
  val nbAlternatives=alternativeSet.size
  //Initialize the empty preference relation 
  val adjacencyMatrix = Array.ofDim[Boolean](nbAlternatives, nbAlternatives)
  for (i<- 0 until nbAlternatives ; j<- 0 until  nbAlternatives){
  adjacencyMatrix(i)(j)=false
  }

  //Initialize the empty preference relation closure
  val adjacencyMatrixClosure = Array.ofDim[Boolean](nbAlternatives, nbAlternatives)
  for (i<- 0 until nbAlternatives ; j<- 0 until  nbAlternatives){
  adjacencyMatrixClosure(i)(j)=false
  }


  // Returns true iff a is at least as good as b
  def isPreferred(a: Alternative, b: Alternative) = adjacencyMatrixClosure(a.id)(b.id)

  // Returns true iff a is strictly preferred to b
  def isStrictlyPreferred(a: Alternative, b: Alternative) = adjacencyMatrixClosure(a.id)(b.id) && ! adjacencyMatrixClosure(b.id)(a.id)

  //Add the fact that a is at least as good as b in the closure
  def addClosure(a: Alternative, b: Alternative) : Unit = {
    adjacencyMatrixClosure(a.id)(b.id)=true
    //warrant transitivity
    for (i<- 0 until nbAlternatives){
      if ((adjacencyMatrixClosure(b.id)(i))&&(!adjacencyMatrixClosure(a.id)(i))){
	alternatives.get(i) match {
          case Some (c) => addClosure(a,c)
          case None => println("Problem in transitivity")
        }
      }
    }
    for (i<- 0 until nbAlternatives){
      if ((adjacencyMatrixClosure(i)(a.id))&&(!adjacencyMatrixClosure(i)(b.id))){
	alternatives.get(i) match {
          case Some (c) => addClosure(c,b)
          case None => println("Problem in transitivity")
        }
      }
    }
  }

  //Add the fact that a is at least as good as b
  def add(a: Alternative, b: Alternative) = {
    if (debug) println("Add "+a+" >= "+b)
    addClosure(a,b)
    if (!adjacencyMatrix(b.id)(a.id)){//Note the useless edges
      var uselessEdge = new HashSet[Couple]();
      for (i<- 0 until nbAlternatives){
        alternatives.get(i) match{
          case Some(c) => 
	    if (adjacencyMatrix(i)(b.id) && isStrictlyPreferred(c, a)) uselessEdge+= new Couple(c, b)
            if (isStrictlyPreferred(b, c)){
	      if (adjacencyMatrix(a.id)(i)) uselessEdge+= new Couple(a, c)
	      for(j<- 0 until nbAlternatives){
	        alternatives.get(j) match{
                  case Some(d) =>                    
	            if (isStrictlyPreferred(d, a) && adjacencyMatrix(j)(i)) uselessEdge+= new Couple(d, c)
                  case None => println("Problem in removing edges")
                }
	      }
            }
          case None => println("Problem in removing edges")
        }
      }
      //delete useless edges 
      for (edge <- uselessEdge) adjacencyMatrix(edge.left.id)(edge.right.id)=false
    }
    adjacencyMatrix(a.id)(b.id) = true
    if (debug) println(showAdjacencyMatrix)

  }

  //Draw the preference graph according to Graphviz 
  override def toString() : String = {
    var res = "digraph G {\n"
    res+="node [shape=circle]\n"
    for (alt <- alternativeSet) res+=alt.id +"[shape=none, label="+alt.name+"]\n"
    for (i<- 0 until nbAlternatives ; j<- 0 until i){
      if (adjacencyMatrix(i)(j)){
        if (adjacencyMatrix(j)(i)) res += i + "->" + j + "[dir=\"both\"];\n"
        else res += i + "->" + j + ";\n";
      }
      else if (adjacencyMatrix(j)(i)) res += j + "->" + i + ";\n";
    }
    res+="}"
    return res
  }

  def showAdjacencyMatrix() : String ={
    var res = new String()
    for (i<- 0 until nbAlternatives){
      for(j<- 0 until nbAlternatives){
        var c = "0"
        if (adjacencyMatrix(i)(j)) c="1"
        res += c +" "
      }
      res += "\n"
    }
    return res
  }

}
