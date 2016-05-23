
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
object sayhello extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/main("sayhello")/*1.18*/{_display_(Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*3.1*/("""<p>welcome --------------- </p>

""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:15:51 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/sayhello.scala.html
                  HASH: 305d4c80f231b81064cac1031e6cce68679fb2a7
                  MATRIX: 583->1|607->17|645->18|673->20
                  LINES: 22->1|22->1|22->1|24->3
                  -- GENERATED --
              */
          