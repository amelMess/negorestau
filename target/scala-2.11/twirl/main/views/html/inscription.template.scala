
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
object inscription extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[scala.Tuple5[String, String, String, String, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(subscribeForm: Form[(String, String, String,String, String)]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._

Seq[Any](format.raw/*1.64*/("""

"""),format.raw/*4.1*/("""

"""),_display_(/*6.2*/main("Inscription")/*6.21*/ {_display_(Seq[Any](format.raw/*6.23*/("""


"""),format.raw/*9.1*/("""<div class="span8">
    """),_display_(/*10.6*/helper/*10.12*/.form(action = routes.Inscription.subscribe, 'class -> "form-horizontal")/*10.85*/ {_display_(Seq[Any](format.raw/*10.87*/("""
    """),format.raw/*11.5*/("""<fieldset>
        <legend>Inscription</legend>

        """),_display_(/*14.10*/inputText(
        subscribeForm("nom"),
        '_label -> "Nom"
        )),format.raw/*17.10*/("""

        """),_display_(/*19.10*/inputText(
        subscribeForm("prenom"),
        '_label -> "Prénom"
        )),format.raw/*22.10*/("""

        """),_display_(/*24.10*/inputText(
        subscribeForm("email"),
        '_label -> "Email"
        )),format.raw/*27.10*/("""

        """),_display_(/*29.10*/inputPassword(
        subscribeForm("password"),
        '_label -> "Mot de passe"
        )),format.raw/*32.10*/("""

        """),_display_(/*34.10*/inputText(
        subscribeForm("adresse"),
        '_label -> "Adresse"
        )),format.raw/*37.10*/("""


        """),format.raw/*40.9*/("""<div class="form-actions">
            <button type="submit" class="btn btn-primary">S'inscrire</button>
        </div>
    </fieldset>
    """)))}),format.raw/*44.6*/("""
"""),format.raw/*45.1*/("""</div>
""")))}))}
  }

  def render(subscribeForm:Form[scala.Tuple5[String, String, String, String, String]]): play.twirl.api.HtmlFormat.Appendable = apply(subscribeForm)

  def f:((Form[scala.Tuple5[String, String, String, String, String]]) => play.twirl.api.HtmlFormat.Appendable) = (subscribeForm) => apply(subscribeForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:15:50 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/inscription.scala.html
                  HASH: e9ce366447d2a17dbd4c29f5d720c3ee17fcf969
                  MATRIX: 563->1|728->63|756->82|784->85|811->104|850->106|879->109|930->134|945->140|1027->213|1067->215|1099->220|1184->278|1280->353|1318->364|1420->445|1458->456|1558->535|1596->546|1710->639|1748->650|1852->733|1890->744|2061->885|2089->886
                  LINES: 19->1|22->1|24->4|26->6|26->6|26->6|29->9|30->10|30->10|30->10|30->10|31->11|34->14|37->17|39->19|42->22|44->24|47->27|49->29|52->32|54->34|57->37|60->40|64->44|65->45
                  -- GENERATED --
              */
          