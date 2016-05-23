
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
object problemCreation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[scala.Tuple3[String, java.util.Date, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(problemForm: Form[(String, java.util.Date, String)]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._

Seq[Any](format.raw/*1.55*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Création de problème")/*5.30*/ {_display_(Seq[Any](format.raw/*5.32*/("""



"""),format.raw/*9.1*/("""<div class="span8">
    """),_display_(/*10.6*/helper/*10.12*/.form(action = routes.ProblemCreation.createProblem, 'class -> "form-horizontal")/*10.93*/ {_display_(Seq[Any](format.raw/*10.95*/("""
    """),format.raw/*11.5*/("""<fieldset>
        <legend>Créer</legend>

        """),_display_(/*14.10*/inputText(
        problemForm("description"),
        '_label -> "Nom"
        )),format.raw/*17.10*/("""



        """),_display_(/*21.10*/inputDate(
        problemForm("deadline"),
        '_label -> "Deadline"
        )),format.raw/*24.10*/("""

        """),_display_(/*26.10*/textarea(
        problemForm("detail"),
        '_label -> "Détail", 
        'cols -> 50,
        'rows -> 6
        )),format.raw/*31.10*/("""

        """),format.raw/*33.9*/("""<div class="form-actions">
            <button type="submit" class="btn btn-primary">Créer</button>
        </div>
    </fieldset>
    """)))}),format.raw/*37.6*/("""
"""),format.raw/*38.1*/("""</div>
""")))}))}
  }

  def render(problemForm:Form[scala.Tuple3[String, java.util.Date, String]]): play.twirl.api.HtmlFormat.Appendable = apply(problemForm)

  def f:((Form[scala.Tuple3[String, java.util.Date, String]]) => play.twirl.api.HtmlFormat.Appendable) = (problemForm) => apply(problemForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:15:51 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/problemCreation.scala.html
                  HASH: 815718a308586fa09d5321a5072a4a48a29e5326
                  MATRIX: 559->1|715->54|743->73|770->75|806->103|845->105|875->109|926->134|941->140|1031->221|1071->223|1103->228|1182->280|1284->361|1324->374|1428->457|1466->468|1607->588|1644->598|1810->734|1838->735
                  LINES: 19->1|22->1|24->4|25->5|25->5|25->5|29->9|30->10|30->10|30->10|30->10|31->11|34->14|37->17|41->21|44->24|46->26|51->31|53->33|57->37|58->38
                  -- GENERATED --
              */
          