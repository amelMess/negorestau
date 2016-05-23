
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
object addChoices extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Form[scala.Tuple3[String, String, String]],List[List[scala.Tuple4[Int, String, String, String]]],Form[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(choicesForm: Form[(String, String, String)],json:List[List[(Int,String, String, String)]], submitForm:Form[String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._

Seq[Any](format.raw/*1.118*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Ajout des choix")/*5.25*/ {_display_(Seq[Any](format.raw/*5.27*/("""
"""),format.raw/*6.1*/("""<div class="span8">
    <fieldset>
        <legend>Selectionner des choix existants</legend>
        <div style="overflow:auto;">
        <table id="tableau" style="margin:0px;overflow:hidden">
            <tr>
                <th></th>
                <th>Nom</th>
                <th>Description</th>
                <th>Site web</th>
            </tr>
        </table>
        </div>
        <div style="max-height:200px;overflow-Y:auto;">
        <table id="tableau" style="margin:0px;overflow:hidden">    
            """),_display_(/*21.14*/for(p <- json) yield /*21.28*/{_display_(Seq[Any](format.raw/*21.29*/("""
                """),_display_(/*22.18*/for(q <- p) yield /*22.29*/{_display_(Seq[Any](format.raw/*22.30*/("""
                    """),_display_(/*23.22*/if(q._1 != 0)/*23.35*/ {_display_(Seq[Any](format.raw/*23.37*/("""
                    """),format.raw/*24.21*/("""<tr>
                        <td><input type="checkbox" name="choices" id=""""),_display_(/*25.72*/q/*25.73*/._1),format.raw/*25.76*/("""" /></td>
                        <td>"""),_display_(/*26.30*/q/*26.31*/._2),format.raw/*26.34*/("""</td>
                        <td>"""),_display_(/*27.30*/q/*27.31*/._3),format.raw/*27.34*/("""</td>
                        <td><a href=""""),_display_(/*28.39*/q/*28.40*/._4),format.raw/*28.43*/("""" target=_blank>"""),_display_(/*28.60*/q/*28.61*/._4),format.raw/*28.64*/("""</a></td>
                    </tr>
                    """)))}),format.raw/*30.22*/("""
                """)))}),format.raw/*31.18*/("""
            """)))}),format.raw/*32.14*/("""
        """),format.raw/*33.9*/("""</table>
        </div>
        <div class="form-actions">
            <button type="submit" id="Enregistrer" class="btn btn-primary" onclick="submitChoices()">Enregistrer</button>
        </div>
    </fieldset>
</div>
"""),_display_(/*40.2*/helper/*40.8*/.form(action = routes.ProblemCreation.submitChoices, 'class -> "form-horizontal", 'id -> "submitForm")/*40.110*/ {_display_(Seq[Any](format.raw/*40.112*/("""
  
    """),format.raw/*42.5*/("""<input type="hidden" id="ids" name=""""),_display_(/*42.42*/submitForm("ids")/*42.59*/.name),format.raw/*42.64*/("""">
     <div class="form-actions">
            <button name ="submitChoices" type="submit" class="btn btn-primary" style="display:none;">Submit</button>
      </div>
    """)))}),format.raw/*46.6*/("""

"""),format.raw/*48.1*/("""<script type="text/javascript">
    function submitChoices() """),format.raw/*49.30*/("""{"""),format.raw/*49.31*/("""
        """),format.raw/*50.9*/("""var ids = "";
        var checkboxes = document.getElementsByName('choices');
        var cpt = 0;
        for(var i=0; i<checkboxes.length; i++) """),format.raw/*53.48*/("""{"""),format.raw/*53.49*/("""
             """),format.raw/*54.14*/("""if(checkboxes[i].checked == true) """),format.raw/*54.48*/("""{"""),format.raw/*54.49*/("""
               """),format.raw/*55.16*/("""ids = ids+ " "+ checkboxes[i].id;
               cpt++; 
           """),format.raw/*57.12*/("""}"""),format.raw/*57.13*/("""
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/("""
        """),format.raw/*59.9*/("""if(cpt >=2)"""),format.raw/*59.20*/("""{"""),format.raw/*59.21*/("""
            """),format.raw/*60.13*/("""document.getElementById("ids").value = ids;
            document.getElementById("submitForm").submit();
        """),format.raw/*62.9*/("""}"""),format.raw/*62.10*/("""else"""),format.raw/*62.14*/("""{"""),format.raw/*62.15*/("""
            """),format.raw/*63.13*/("""alert("Veuillez sélectionner au moins 2 choix")
        """),format.raw/*64.9*/("""}"""),format.raw/*64.10*/("""
    """),format.raw/*65.5*/("""}"""),format.raw/*65.6*/("""

"""),format.raw/*67.1*/("""</script>


<div class="span8">
    """),_display_(/*71.6*/helper/*71.12*/.form(action = routes.ProblemCreation.addChoices, 'class -> "form-horizontal")/*71.90*/ {_display_(Seq[Any](format.raw/*71.92*/("""
    """),format.raw/*72.5*/("""<fieldset>
        <legend>Ajouter un nouveau choix</legend>

        """),_display_(/*75.10*/inputText(
        choicesForm("nom"),
        '_label -> "Nom"
        )),format.raw/*78.10*/("""

        """),_display_(/*80.10*/inputText(
        choicesForm("description"),
        '_label -> "Description"
        )),format.raw/*83.10*/("""

        """),_display_(/*85.10*/inputText(
        choicesForm("url"),
        '_label -> "Url"
        )),format.raw/*88.10*/("""

        """),format.raw/*90.9*/("""<div class="form-actions">
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </div>
    </fieldset>
    """)))}),format.raw/*94.6*/("""
"""),format.raw/*95.1*/("""</div>
""")))}),format.raw/*96.2*/("""
"""))}
  }

  def render(choicesForm:Form[scala.Tuple3[String, String, String]],json:List[List[scala.Tuple4[Int, String, String, String]]],submitForm:Form[String]): play.twirl.api.HtmlFormat.Appendable = apply(choicesForm,json,submitForm)

  def f:((Form[scala.Tuple3[String, String, String]],List[List[scala.Tuple4[Int, String, String, String]]],Form[String]) => play.twirl.api.HtmlFormat.Appendable) = (choicesForm,json,submitForm) => apply(choicesForm,json,submitForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:31:59 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/addChoices.scala.html
                  HASH: 64ea462b7e5fb752b83ee4479e8e2c2b409ef14c
                  MATRIX: 613->1|833->117|861->136|888->138|919->161|958->163|985->164|1536->688|1566->702|1605->703|1650->721|1677->732|1716->733|1765->755|1787->768|1827->770|1876->791|1979->867|1989->868|2013->871|2079->910|2089->911|2113->914|2175->949|2185->950|2209->953|2280->997|2290->998|2314->1001|2358->1018|2368->1019|2392->1022|2480->1079|2529->1097|2574->1111|2610->1120|2856->1340|2870->1346|2982->1448|3023->1450|3058->1458|3122->1495|3148->1512|3174->1517|3375->1688|3404->1690|3493->1751|3522->1752|3558->1761|3732->1907|3761->1908|3803->1922|3865->1956|3894->1957|3938->1973|4034->2041|4063->2042|4099->2051|4128->2052|4164->2061|4203->2072|4232->2073|4273->2086|4412->2198|4441->2199|4473->2203|4502->2204|4543->2217|4626->2273|4655->2274|4687->2279|4715->2280|4744->2282|4807->2319|4822->2325|4909->2403|4949->2405|4981->2410|5079->2481|5173->2554|5211->2565|5321->2654|5359->2665|5453->2738|5490->2748|5658->2886|5686->2887|5724->2895
                  LINES: 19->1|22->1|24->4|25->5|25->5|25->5|26->6|41->21|41->21|41->21|42->22|42->22|42->22|43->23|43->23|43->23|44->24|45->25|45->25|45->25|46->26|46->26|46->26|47->27|47->27|47->27|48->28|48->28|48->28|48->28|48->28|48->28|50->30|51->31|52->32|53->33|60->40|60->40|60->40|60->40|62->42|62->42|62->42|62->42|66->46|68->48|69->49|69->49|70->50|73->53|73->53|74->54|74->54|74->54|75->55|77->57|77->57|78->58|78->58|79->59|79->59|79->59|80->60|82->62|82->62|82->62|82->62|83->63|84->64|84->64|85->65|85->65|87->67|91->71|91->71|91->71|91->71|92->72|95->75|98->78|100->80|103->83|105->85|108->88|110->90|114->94|115->95|116->96
                  -- GENERATED --
              */
          