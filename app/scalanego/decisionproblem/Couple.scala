// Copyright (C) Maxime Morge 2015
package scalanego.decisionproblem

/*
 * @author Maxime Morge
 * @version 2015-10-24
 * Class to represent a couple of alternatives
 */
class Couple(val left: Alternative, val right: Alternative){
  override def toString() : String = "("+left+", "+right+")" 
}
