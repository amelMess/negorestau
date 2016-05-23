package controllers

import models._
import controllers._
import play.api._
//import play.api.db._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import play.api.Play.current
import play.api.mvc.BodyParsers._
import org.postgresql.util.PSQLException

object Index extends Controller with Secured{

  //create an instance of the table
  val users = TableQuery[UserTable]
  val choices = TableQuery[ChoiceTable]
  val problems = TableQuery[ProblemTable]
  val admissibleChoice = TableQuery[AdmissibleChoiceTable]

  implicit val session = play.api.db.slick.DB.createSession

  def problemsWithoutSolution()(implicit session: play.api.db.slick.Config.driver.simple.Session): List[(Int, String, String, String, String, String, Int, Int)] = {
      //Informations du problème
    val myproblems = problems.filter(p => p.solution === 0)
    
    val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
    val problemInfo = (myproblems join users on (_.idUser === _.id))
       .map{ case (p, u) => (p.id, p.description, p.dateCreation, p.deadline, u.lastname, u.firstname, u.id)}.list
       //Formatage des dates
       .map{ case (p) => (p._1, p._2, format.format(p._3).toString, format.format(p._4).toString, p._5, p._6, p._7, countParticipants(p._1))} 
     problemInfo  
   }

   def problemsWithSolution()(implicit session: play.api.db.slick.Config.driver.simple.Session): List[(Int, String, String, String, String, String, Int, String, Int)] = {
      //Informations du problème
    val myproblems = problems.filter(p => !(p.solution === 0))
    
    val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
    val problemInfo = (myproblems join users on (_.idUser === _.id))
       .map{ case (p, u) => (p.id, p.description, p.dateCreation, p.deadline, u.lastname, u.firstname, u.id, p.solution)}

    val problemInfoWithName = (problemInfo join choices on(_._8===_.id))
    .map {case (p, c) => (p._1, p._2, p._3, p._4, p._5, p._6, p._7, c.name)}.list 
       //Formatage des dates
    .map {case (p) => (p._1, p._2, format.format(p._3).toString, format.format(p._4).toString, p._5, p._6, p._7, p._8, countParticipants(p._1))}
     problemInfoWithName  
   }
   def problemsAdmin(userId:Int)(implicit session: play.api.db.slick.Config.driver.simple.Session): List[(Int, String, String, String, Int, Int)] = {
      //Informations du problème
    val myproblems = problems.filter(p => p.idUser===userId)
    
    val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
    val problemInfo = myproblems
       .map{ case (p) => (p.id, p.description, p.dateCreation, p.deadline, userId)}.list
       //Formatage des dates
       .map{ case (p) => (p._1, p._2, format.format(p._3).toString, format.format(p._4).toString, p._5, countParticipants(p._1))} 
     problemInfo  
   }
   def countParticipants(problemId:Int)(implicit session: play.api.db.slick.Config.driver.simple.Session): Int = {
      val query = admissibleChoice.filter(a => a.idProblem === problemId)
                                    .map(a => a.idUser)
      query.list.distinct.length
  }

  def index = withAuth { username => implicit request =>
    val problemsWithSolutionVal = problemsWithSolution
    val problemsWithoutSolutionVal = problemsWithoutSolution
    val idUser = users.filter(u => u.email===username).list.head.id

    Ok(views.html.problemSelection(idUser, problemsWithoutSolutionVal, problemsWithSolutionVal, problemsAdmin(idUser), problemForm))
  }
 
  val problemForm = Form(
    tuple(
      "problem" -> text,
      "role" -> text
    )
  )
 
 
 def submit = DBAction { implicit rs =>
    problemForm.bindFromRequest.fold(
      errors    => BadRequest(views.html.sayhello()),
      success = update => {
        update match {

          case (problem, role) => {
            val idProblem = problem.toInt
            if(role.equals("participer")){
              Redirect(routes.Problem.problem).withSession(rs.session + ("idProblem" -> (""+idProblem)))
            }else {
              Redirect(routes.Admin.admin).withSession(rs.session + ("idProblem" -> (""+idProblem)))
            }
          }
        }
      }
    )
  } 
}
