package controllers

import models._
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
import com.typesafe.config.ConfigFactory
import org.mindrot.jbcrypt.BCrypt

object Auth extends Controller{

  //create an instance of the table
  val users = TableQuery[UserTable]


implicit val session = play.api.db.slick.DB.createSession

 
  val loginForm = Form(
    tuple(
      "email" -> text,
      "password" -> text
    ) verifying ("Invalid email or password", result => result match {
      case (email, password) => check(email, password)
    })
  )

  def check(username: String, password: String)(implicit session: play.api.db.slick.Config.driver.simple.Session): Boolean = {
    val user = users.filter(u => u.email === username).map {case (u) => (u.password)}.list 
    session.close
     if(!user.isEmpty)
        BCrypt.checkpw(password, user.head)
     else
        false
  }

  def login = Action { implicit request =>
    Ok(views.html.login(loginForm))
  }

  def authenticate = Action { implicit rs =>
    loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.login(formWithErrors)),
      user => Redirect(routes.Index.index).withSession(Security.username -> user._1)
    )
  }

  def logout = Action {
    Redirect(routes.Auth.login).withNewSession.flashing(
      "success" -> "You are now logged out."
    )
  }  
}
trait Secured {

  def username(request: RequestHeader) = request.session.get(Security.username)

  def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Auth.login)

  def withAuth(f: => String => Request[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) { user =>
      Action(request => f(user)(request))
    }
  }

}
