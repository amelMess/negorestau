
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[scala.Tuple2[String, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loginForm: Form[(String, String)]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._

Seq[Any](format.raw/*1.37*/("""


"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/main("Login")/*6.15*/ {_display_(Seq[Any](format.raw/*6.17*/("""
"""),format.raw/*7.1*/("""<div class="span8">
    """),_display_(/*8.6*/helper/*8.12*/.form(action = routes.Auth.authenticate, 'class -> "form-horizontal")/*8.81*/ {_display_(Seq[Any](format.raw/*8.83*/("""
    """),format.raw/*9.5*/("""<fieldset>
        <legend>Connexion</legend>



        """),_display_(/*14.10*/inputText(
        loginForm("email"),
        '_label -> "Email"
        )),format.raw/*17.10*/("""
        """),_display_(/*18.10*/inputPassword(
        loginForm("password"),
        '_label -> "Mot de passe"
        )),format.raw/*21.10*/("""
 
        """),format.raw/*23.9*/("""<table>
            <tr>
                <td style="padding-right:20px">
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Se connecter</button>
                    </div>
                    </fieldset>
                """)))}),format.raw/*30.18*/("""
                """),format.raw/*31.17*/("""</td>
                <td>
                    """),_display_(/*33.22*/helper/*33.28*/.form(action = routes.Inscription.inscription, 'class -> "form-horizontal")/*33.103*/ {_display_(Seq[Any](format.raw/*33.105*/("""
                            """),format.raw/*34.29*/("""<button class="btn btn-success"> 
                               S'inscrire
                            </button>
                        """)))}),format.raw/*37.26*/("""
                """),format.raw/*38.17*/("""</td>
            </tr>
        </table>
</div>
""")))}),format.raw/*42.2*/("""
"""))}
  }

  def render(loginForm:Form[scala.Tuple2[String, String]]): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)

  def f:((Form[scala.Tuple2[String, String]]) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:15:50 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/login.scala.html
                  HASH: b4c71d343f78670bfbfd82accaedce644b1175dc
                  MATRIX: 533->1|671->36|700->56|727->58|748->71|787->73|814->74|864->99|878->105|955->174|994->176|1025->181|1110->239|1206->314|1243->324|1353->413|1391->424|1710->712|1755->729|1830->777|1845->783|1930->858|1971->860|2028->889|2198->1028|2243->1045|2322->1094
                  LINES: 19->1|22->1|25->5|26->6|26->6|26->6|27->7|28->8|28->8|28->8|28->8|29->9|34->14|37->17|38->18|41->21|43->23|50->30|51->31|53->33|53->33|53->33|53->33|54->34|57->37|58->38|62->42
                  -- GENERATED --
              */
          