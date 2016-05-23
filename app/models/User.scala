package models

import play.api.db.slick.Config.driver.simple._
import java.sql.Date


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
