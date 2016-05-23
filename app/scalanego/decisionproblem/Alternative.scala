// Copyright (C) Maxime Morge 2015
package scalanego.decisionproblem

/*
 * @author Maxime Morge
 * @version 2015-10-24
 * Class to represent alternatives
 */
class Alternative(val id: Int, val name: String){

  override def equals(o: Any) = o match {
    case that: Alternative => that.name.equalsIgnoreCase(this.name)
    case _ => false
  }

  override def hashCode = this.name.hashCode

  override def toString() : String = this.name+"("+this.id+")"

}
