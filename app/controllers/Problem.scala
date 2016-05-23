package controllers

import models._
import controllers._
import play.api._
//import play.api.db._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.data._
import play.api.data.Forms
import play.api.data.Forms._
import play.api.mvc._
import play.api.Play.current
import play.api.mvc.BodyParsers._
import org.postgresql.util.PSQLException

object Problem extends Controller with Secured{

  //create an instance of the table
  val users = TableQuery[UserTable]
  val choices = TableQuery[ChoiceTable]
  val problems = TableQuery[ProblemTable]
  val contains = TableQuery[ContainsTable]
  val prefer = TableQuery[PreferTable]
  val admissibleChoice = TableQuery[AdmissibleChoiceTable]

  implicit val session = play.api.db.slick.DB.createSession

   
   def problemInfo(problemId: Int)(implicit session: play.api.db.slick.Config.driver.simple.Session): (Int, String, String, String, String, String, String) = {
      //Informations du problème
    
    val myproblem = problems.filter(p => p.id===problemId)
        val format = new java.text.SimpleDateFormat("dd-MM-yyyy")
    val problemInfo = (myproblem join users on (_.idUser === _.id))
       .map{ case (p, u) => (p.id, p.description, p.dateCreation, p.deadline, u.lastname, u.firstname, p.detail)}.list
       //Formatage des dates
       .map{ case (p) => (p._1, p._2, format.format(p._3).toString, format.format(p._4).toString, p._5, p._6, p._7)}
       problemInfo.head
   }

   def potentialChoices(problemId: Int) (implicit session: play.api.db.slick.Config.driver.simple.Session): List[(Int, String, String, String)] = {
       //Choix possibles pour le problème
      val myproblem = problems.filter(p => p.id===problemId)
      val subquery = (myproblem join contains on (_.id === _.idProblem))
        .map { case (p, c) => c.idChoice }
      val potentialChoices = (subquery join choices on (_ === _.id))
      . map {case (contain,choice) => (choice.id, choice.name, choice.description, choice.url) }.list
      potentialChoices
   }

   def preferences(user: String, problemId: Int)(implicit session: play.api.db.slick.Config.driver.simple.Session): (List[(Int, Int)], List[(Int, String)], List[(Int, String)], List[(Int, String)]) ={

    val myproblem = problems.filter(p => p.id===problemId)
      //Préférences pour un utilisateur et un problème donnés
    val myUser = users.filter(u => u.email===user)
    val subquery2 = (prefer join myproblem on (_.idProblem === _.id ))
      .map {case (p, mp) => (p.idChoiceDominant, p.idChoiceDominated, p.idUser)}
  
    val preferQuery = (subquery2 join myUser on (_._3 === _.id ))
      .map {case (p, mu) => (p._1, p._2)}
    
    //Noms des choix préférés
    val dominantNames = (preferQuery join choices on(_._1 === _.id))
      .map {case (p, c) => (p._1, c.name)}.list
    val dominatedNames = (preferQuery join choices on(_._2 === _.id))
      .map {case (p, c) => (p._2, c.name)}.list

    //Choix admissibles  
    val subqueryAdmissible = (admissibleChoice join myproblem on (_.idProblem === _.id ))
      .map {case (a, mp) => (a.idChoice, a.idUser)} 
    val subqueryAdmissible2 = (subqueryAdmissible join myUser on (_._2 === _.id ))
      .map {case (a, mu) => (a._1)}

    val admissibleChoices = (subqueryAdmissible2 join choices on(_ === _.id))
      .map {case (a, c) => (a, c.name)}.list  

    (preferQuery.list, dominantNames, dominatedNames, admissibleChoices)
   }

  def problem =  withAuth { username => implicit request =>

   
    val idProblemStr = (request.session.get("idProblem")).getOrElse("error")
    
    if(idProblemStr.equals("error"))
      Redirect(routes.Index.index)
    else {  
      val idProblem = idProblemStr.toInt

      val idUser = users.filter(u => u.email===username).list.head.id
      val pref = preferences(username, idProblem);

      Ok(views.html.problem(idUser, problemInfo(idProblem), potentialChoices(idProblem), pref._1, pref._2, pref._3, pref._4, updateForm))

    }

  }
 
  


val updateForm = Form(
    tuple(

      "problem" -> text,

      "user" -> text,

      "preferChoice"  -> text,

      "admissible" -> text
    )
  )
 
 
 def update = DBAction { implicit rs =>
    updateForm.bindFromRequest.fold(
      errors    => BadRequest(views.html.sayhello()),
      success = update => {
        update match {

          case (problem, user, preferChoice, admissible) => {
            val idUser = user.toInt
            val idProblem = problem.toInt
            
            //CHOIX ADMISSIBLES    
            //Suppression des anciens choix
            val deleteAdmissible = admissibleChoice.filter(p=> p.idUser === idUser && p.idProblem === idProblem)
            deleteAdmissible.delete
            //Récupération des nouveaux choix
            if(!admissible.isEmpty){
              val admissibleChoiceArray = admissible.split(" ").map(_.trim).map(_.toInt)

              //Insertions des nouveaux choix
              for(i <- 0 until admissibleChoiceArray.length)
                admissibleChoice += AdmissibleChoice(idProblem, idUser, admissibleChoiceArray(i))
            }

            //PREFERENCES
            //Suppression des anciennes préférences
            val deletePrefer = prefer.filter(p=> p.idUser === idUser && p.idProblem === idProblem)
            deletePrefer.delete
            //Récupération des nouvelles préférences
            val preferArray = preferChoice.split(",")
            val preferCouple = new Array[(Int, Int)](preferArray.length)
            
            for(i <- 0 until preferArray.length)
              if(!preferArray(i).trim.isEmpty)
                preferCouple(i) = preferArray(i).split(" ") match { case Array(i, j) => (i.toInt, j.toInt) }
            
            //Insertions des nouvelles préférences 
            for(i <- 0 until preferCouple.length)
              if(preferCouple(i) != null){
                try{
                  prefer += Prefer(preferCouple(i)._1, idProblem, idUser, preferCouple(i)._2)
                }catch{
                  case e: Exception =>
                }
              }
            Redirect(routes.Index.index)
          }
        }
      }
    )
  } 
}
