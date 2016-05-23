package controllers

import models._
import controllers._
//import play.api.db._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.mvc._

import play.api.data.Forms
import play.api.data._
import play.api.data.validation.Constraints._
import play.api.data.Forms._
import play.api.i18n._
import play.api.Play.current
import play.api.data.{Form, Forms}, Forms._
import java.util.Calendar
import play.api.libs.json._

object ProblemCreation extends Controller with Secured{

  //create an instance of the table
  val users = TableQuery[UserTable]
  val choices = TableQuery[ChoiceTable]
  val problems = TableQuery[ProblemTable]
  val contains = TableQuery[ContainsTable]

  implicit val session = play.api.db.slick.DB.createSession

 def creation = withAuth { username => implicit request =>
   Ok(views.html.problemCreation(problemForm))
 }


  val problemForm = Form(
    tuple(

      /*"nom" -> nonEmptyText,*/

      "description" -> text
        .verifying(nonEmpty)
        .verifying(Messages("Description trop longue"), description => checkSize(description, 255))
        .verifying(Messages("Description trop courte"), description => description.size > 5),



      "deadline" -> date("yyyy-MM-dd")
        .verifying(Messages("Date inférieur à la date d'aujourd'hui"), deadline => checkDate(deadline)),

      "detail" -> text
        .verifying(Messages("Détail long"), detail => checkSize(detail,1024))
    )
  )

  def checkDate(date: java.util.Date): Boolean =
    date.after(java.util.Calendar.getInstance.getTime)

  def checkSize(description: String, taille: Int): Boolean = description.size < taille

  def createProblem = DBAction {  implicit rs =>

    val idUser = users.filter(u => u.email===username(rs)).list.head.id

    problemForm.bindFromRequest.fold(
      errors2    => BadRequest(views.html.problemCreation(errors2)),
      success = createProblem => {
        createProblem match {
          case (description, deadline, detail) => {

            val idProblem = (problems.map(problem => (problem.description,problem.dateCreation, problem.deadline, problem.idUser, problem.detail, problem.solution)) returning problems.map(_.id)) += (description,new java.sql.Date(Calendar.getInstance.getTime().getTime), new java.sql.Date(deadline.getTime()), idUser, detail, 0)
            val json = List(choices.map{(c) => (c.id, c.name, c.description, c.url)}.list.map{ case (c) => (c._1, c._2, c._3, c._4)})


            Ok(views.html.addChoices(choicesForm,json, submitForm)).withSession(rs.session + ("idProblem" -> (""+idProblem)))
          }
        }
      }
    )
  }


  val json = List(choices.map{(c) => (c.id, c.name, c.description, c.url)}.list.map{ case (c) => (c._1, c._2, c._3, c._4)})


  /*val json = List(choices.list.mkString(","))
  val json = Json.stringify( Json.obj(
    "choices" -> JsArray( listChoices.map( JsString(_) ) )
  ))*/

  def choix = withAuth { username => implicit request =>
    Ok(views.html.addChoices(choicesForm,json, submitForm))
  }

  val choicesForm = Form(
    tuple(

      "nom" -> nonEmptyText,

      "description" -> text
        .verifying(nonEmpty)
        .verifying(maxLength(255))
        .verifying(minLength(2)),

      "url" -> text
        .verifying(Messages("L'url est invalide"), url => isValid(url))
    )
  )
  val submitForm = Form(

      "ids" -> nonEmptyText

  )


  def isValid(url: String): Boolean = {
    if(url.isEmpty) true
    else
      """https://(.*)\.([a-z]+)(/?)""".r.unapplySeq(url).isDefined
  }


  def addChoices = DBAction { implicit request =>

    choicesForm.bindFromRequest.fold(

      error => BadRequest(views.html.addChoices(error,json, submitForm)),
      success = addChoices => {
        addChoices match {
          case(nom, description, url) => {
            val notExist = choices.filter(choice => choice.name === nom && choice.description === description && choice.url === url).list.length == 0
            if(notExist){
              val idProblem = (request.session.get("idProblem")).getOrElse("").toInt
              val idChoice = choices.map(choice => (choice.name, choice.description, choice.url)) returning choices.map(_.id) += (nom, description, url)
              
            }

            val json = List(choices.map{(c) => (c.id, c.name, c.description, c.url)}.list.map{ case (c) => (c._1, c._2, c._3, c._4)})

              Ok(views.html.addChoices(choicesForm,json, submitForm))

          }
        }
      }
    )
  }

  def submitChoices = DBAction { implicit request =>

    submitForm.bindFromRequest.fold(

      error => BadRequest(views.html.addChoices(choicesForm,json, error)),
      success = submitChoices => {
        submitChoices match {
          case(ids) => {
            val idsArray = ids.split(" ").map(_.trim)
            val idProblem = (request.session.get("idProblem")).getOrElse("").toInt


            for(i <- 0 until idsArray.length) {
                if(!idsArray(i).isEmpty){
                  contains += Contains(idProblem, idsArray(i).toInt)
                }
              }
              Redirect(routes.Index.index)

          }
        }
      }
    )
  }
  /*
  val choicesChecked = Form(
    tuple(
      "champ" -> text,
      "choix" -> text
    )
  )

  def saveChoices = DBAction { implicit request2 =>

    choicesChecked.bindFromRequest.fold(
      error => BadRequest(views.html.addChoices(error,json)),
      success = saveChoices => {
        saveChoices match {
            case(choix, champ) => {
              val choicesArray = choix.split(' ')
              for(c <- choicesArray){

                val idProblem = (request2.session.get("idProblem")).getOrElse("").toInt
                contains += Contains(idProblem, c)
              }
              Ok(views.html.sayhello())

          }
        }
      }
    )
  }*/


}


