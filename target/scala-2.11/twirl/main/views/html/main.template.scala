
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css")),format.raw/*8.94*/("""">
        <link rel="stylesheet" href='"""),_display_(/*9.39*/routes/*9.45*/.Assets.at("stylesheets/bootstrap.css")),format.raw/*9.84*/("""'>
   		<link rel="stylesheet" href='"""),_display_(/*10.36*/routes/*10.42*/.Assets.at("stylesheets/bootstrap-theme.css")),format.raw/*10.87*/("""'>

   		<link href="https://cdnjs.cloudflare.com/ajax/libs/vis/4.12.0/vis.min.css" rel="stylesheet" type="text/css" />

		
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/routes/*15.65*/.Assets.at("images/favicon.png")),format.raw/*15.97*/("""">
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.at("javascripts/jquery-1.9.0.min.js")),format.raw/*16.74*/("""" type="text/javascript"></script>
        <script  src="https://cdnjs.cloudflare.com/ajax/libs/vis/4.12.0/vis.min.js" type="text/javascript"></script>
    
    <style type="text/css">
        #mynetwork """),format.raw/*20.20*/("""{"""),format.raw/*20.21*/("""    
            """),format.raw/*21.13*/("""width: 600px;
            height: 400px;
            border: 1px solid lightgray;
        """),format.raw/*24.9*/("""}"""),format.raw/*24.10*/("""
        """),format.raw/*25.9*/("""#tableau """),format.raw/*25.18*/("""{"""),format.raw/*25.19*/("""
            """),format.raw/*26.13*/("""font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 12px;
            margin: 10px 0;
            width: 50%;
            text-align: left;
            border-collapse: collapse;
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/("""
        """),format.raw/*33.9*/("""#tableau th """),format.raw/*33.21*/("""{"""),format.raw/*33.22*/("""
            """),format.raw/*34.13*/("""font-size: 13px;
            font-weight: normal;
            padding: 8px;
            background: #cce6ff ;
            border-top: 2px solid #d3ddff;
            border-bottom: 1px solid #fff;
            color: #039;
        """),format.raw/*41.9*/("""}"""),format.raw/*41.10*/("""
        """),format.raw/*42.9*/("""#tableau td """),format.raw/*42.21*/("""{"""),format.raw/*42.22*/("""
            """),format.raw/*43.13*/("""padding: 8px;
            border-bottom: 1px solid #fff;
            color: #669;
            border-top: 1px solid #fff;
            background: #ffffff ;
        """),format.raw/*48.9*/("""}"""),format.raw/*48.10*/("""
        """),format.raw/*49.9*/("""#tableau tfoot tr td """),format.raw/*49.30*/("""{"""),format.raw/*49.31*/("""
            """),format.raw/*50.13*/("""background: #e8edff;
            font-size: 16px;
            color: #99c;
            text-align:center;
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/("""
        """),format.raw/*55.9*/("""#tableau tbody tr:hover td """),format.raw/*55.36*/("""{"""),format.raw/*55.37*/("""
            """),format.raw/*56.13*/("""background: #e6f2ff ;
            color: #339;
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/("""
        """),format.raw/*59.9*/("""#tableau a:hover """),format.raw/*59.26*/("""{"""),format.raw/*59.27*/("""
            """),format.raw/*60.13*/("""text-decoration:underline;
        """),format.raw/*61.9*/("""}"""),format.raw/*61.10*/("""
    """),format.raw/*62.5*/("""</style>
    </head>
    <body>
        """),_display_(/*65.10*/content),format.raw/*65.17*/("""
    """),format.raw/*66.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:15:50 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/main.scala.html
                  HASH: eefe0cde5b23507da6e4b579143865cfccdd099a
                  MATRIX: 509->1|627->31|655->33|732->84|757->89|845->151|859->157|913->191|980->232|994->238|1053->277|1118->315|1133->321|1199->366|1408->548|1423->554|1476->586|1528->611|1543->617|1609->662|1841->866|1870->867|1915->884|2032->974|2061->975|2097->984|2134->993|2163->994|2204->1007|2454->1230|2483->1231|2519->1240|2559->1252|2588->1253|2629->1266|2885->1495|2914->1496|2950->1505|2990->1517|3019->1518|3060->1531|3251->1695|3280->1696|3316->1705|3365->1726|3394->1727|3435->1740|3576->1854|3605->1855|3641->1864|3696->1891|3725->1892|3766->1905|3848->1960|3877->1961|3913->1970|3958->1987|3987->1988|4028->2001|4090->2036|4119->2037|4151->2042|4219->2083|4247->2090|4279->2095
                  LINES: 19->1|22->1|24->3|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|36->15|36->15|36->15|37->16|37->16|37->16|41->20|41->20|42->21|45->24|45->24|46->25|46->25|46->25|47->26|53->32|53->32|54->33|54->33|54->33|55->34|62->41|62->41|63->42|63->42|63->42|64->43|69->48|69->48|70->49|70->49|70->49|71->50|75->54|75->54|76->55|76->55|76->55|77->56|79->58|79->58|80->59|80->59|80->59|81->60|82->61|82->61|83->62|86->65|86->65|87->66
                  -- GENERATED --
              */
          