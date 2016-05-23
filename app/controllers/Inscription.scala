package controllers

import models._
//import play.api.db._
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.data._
import play.api.mvc._

import play.api.data.Forms
import play.api.data._
import play.api.data.validation.Constraints._
import play.api.data.Forms._
import play.api.i18n._
import play.api.Play.current
import org.mindrot.jbcrypt.BCrypt

object Inscription extends Controller{

  //create an instance of the table
  val users = TableQuery[UserTable]
  val choices = TableQuery[ChoiceTable]
  val problems = TableQuery[ProblemTable]
  val contains = TableQuery[ContainsTable]

  implicit val session = play.api.db.slick.DB.createSession

  def inscription = Action {
    Ok(views.html.inscription(subscribeForm))
  }

  val subscribeForm = Form(
    tuple(

      "nom" -> text
        .verifying(nonEmpty)
        .verifying(Messages("Nom trop long"), nom => nom.size < 255)
        .verifying(Messages("Nom trop court"), nom => nom.size >= 2),

      "prenom" -> text
        .verifying(nonEmpty)
        .verifying(Messages("Prénom trop long"), nom => nom.size < 255)
        .verifying(Messages("Prénom trop court"), nom => nom.size >= 2),

      "email"  -> text
        .verifying(nonEmpty)
        .verifying(Messages("L'adresse mail est trop longue"), email => email.size < 255)
        .verifying(Messages("L'adresse mail est trop courte"), email => email.size >= 5)
        .verifying(Messages("L'adresse mail est invalide"), email => isValid(email))
        .verifying(Messages("L'adresse mail est déjà utilisée"), email => checkEmail(email)
        ),

      "password" -> text
        .verifying(nonEmpty),

      "adresse" -> text
    )
  )

  /* verifie l'existante d'une adresse mail dans la base de données */
  def checkEmail(email: String)(implicit session: play.api.db.slick.Config.driver.simple.Session): Boolean =
    (users.filter(_.email === email).list.length == 0)

  /* verifie la validité de l'adresse mail saisie*/
  def isValid(email: String): Boolean =
    """([\w\.]+)@([\w\.]+)""".r.unapplySeq(email).isDefined

  def subscribe = DBAction { implicit rs =>
    subscribeForm.bindFromRequest.fold(
      errors    => BadRequest(views.html.inscription(errors)),
      success = subscribe => {
        subscribe match {

          case (nom, prenom, email, password, adresse) => {
            val hash = BCrypt.hashpw(password, BCrypt.gensalt())
            users.map(u => ( u.lastname, u.firstname, u.email, u.password, u.adress,u.role)) returning users.map(_.id) += (nom, prenom, email, hash, adresse,"n")
            Redirect(routes.Index.index)
          }
        }
      }
    )
  }
}
