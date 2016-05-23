
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
object administrationProblem extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[scala.Tuple6[Int, String, String, String, String, Int],List[scala.Tuple2[String, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(problemInfo: (Int, String, String, String, String, Int), participants: List[(String, String)]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import helper._

Seq[Any](format.raw/*1.97*/("""
"""),format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Administration d'un problème")/*4.38*/{_display_(Seq[Any](format.raw/*4.39*/("""
"""),format.raw/*5.1*/("""<style type="text/css">
        label
		"""),format.raw/*7.3*/("""{"""),format.raw/*7.4*/("""
		    """),format.raw/*8.7*/("""display: block;
		    width: 130px;
		    float: left;
		"""),format.raw/*11.3*/("""}"""),format.raw/*11.4*/("""
"""),format.raw/*12.1*/("""</style>
<script type="text/javascript">
	function resoudre() """),format.raw/*14.22*/("""{"""),format.raw/*14.23*/("""
     	"""),format.raw/*15.7*/("""var nbParticipants = document.getElementById("nbParticipants").value

     	if(nbParticipants <2) """),format.raw/*17.29*/("""{"""),format.raw/*17.30*/("""
     		"""),format.raw/*18.8*/("""alert("Il faut au moins 2 participants au problème")
     		return
     	"""),format.raw/*20.7*/("""}"""),format.raw/*20.8*/("""

        """),format.raw/*22.9*/("""document.getElementById("resolveForm").submit();
        alert("Résolution lancée")
    """),format.raw/*24.5*/("""}"""),format.raw/*24.6*/("""
"""),format.raw/*25.1*/("""</script>
<div class="span8">
    <form>
    	<fieldset>
       	 <legend>Rappel des informations du problème</legend>

			  <label for ="desc">Description: </label>	<input type="text" id="desc" value=""""),_display_(/*31.84*/problemInfo/*31.95*/._2),format.raw/*31.98*/("""" disabled><br>
			  <label for ="creation">Date de création: </label> <input type="text" id="creation" value=""""),_display_(/*32.97*/problemInfo/*32.108*/._3),format.raw/*32.111*/("""" disabled><br>
			  <label for ="deadline">Date de fin: </label> <input type="text" id="deadline" value=""""),_display_(/*33.92*/problemInfo/*33.103*/._4),format.raw/*33.106*/("""" disabled><br>
			  <label for ="detail">Détail: </label> <textarea id="detail"  rows="5" cols="45" disabled>"""),_display_(/*34.96*/problemInfo/*34.107*/._5),format.raw/*34.110*/("""</textarea><br>
			  <input type="text" id="nbParticipants" value=""""),_display_(/*35.53*/participants/*35.65*/.length),format.raw/*35.72*/("""" hidden><br>

			  """),_display_(/*37.7*/if(participants.length == 0)/*37.35*/ {_display_(Seq[Any](format.raw/*37.37*/("""
			  	"""),format.raw/*38.7*/("""<label for ="participants">Pas encore de participant</label>
			  """)))}/*39.8*/else/*39.13*/{_display_(Seq[Any](format.raw/*39.14*/("""
			  	"""),format.raw/*40.7*/("""<label for ="participants">Participants: </label> 
			  """)))}),format.raw/*41.7*/("""
			  	"""),format.raw/*42.7*/("""<table id="participants">
			  		"""),_display_(/*43.9*/for(p <- participants) yield /*43.31*/{_display_(Seq[Any](format.raw/*43.32*/(""" 
					    """),format.raw/*44.10*/("""<tr>
					   		<td style="padding-right:10px">"""),_display_(/*45.43*/p/*45.44*/._1),format.raw/*45.47*/("""</td><td>"""),_display_(/*45.57*/p/*45.58*/._2),format.raw/*45.61*/("""</td>
					    </tr>
						""")))}),format.raw/*47.8*/("""
				"""),format.raw/*48.5*/("""</table><br>
	    </fieldset>
    </form>
</div>

<br>
<table>
	<tr>
		<td style="padding-right:10px">
				<button class="btn btn-primary" onclick="resoudre()"> 
							   Résoudre
				</button>
		</td>
		<td style="padding-right:10px">
			"""),_display_(/*62.5*/helper/*62.11*/.form(action = routes.Admin.deleteProblem, 'class -> "form-horizontal")/*62.82*/ {_display_(Seq[Any](format.raw/*62.84*/("""
				"""),format.raw/*63.5*/("""<button class="btn btn-danger"> 
							   Supprimer le problème
				</button>
			""")))}),format.raw/*66.5*/("""
		"""),format.raw/*67.3*/("""</td>
		<td>
			"""),_display_(/*69.5*/helper/*69.11*/.form(action = routes.Index.index, 'class -> "form-horizontal")/*69.74*/ {_display_(Seq[Any](format.raw/*69.76*/("""
						  
			        """),format.raw/*71.12*/("""<button class="btn btn-primary">Retour à la sélection des problèmes</button>
			""")))}),format.raw/*72.5*/("""
		"""),format.raw/*73.3*/("""</td>
	</tr>
<table>
	"""),_display_(/*76.3*/helper/*76.9*/.form(action = routes.Admin.resolve, 'class -> "form-horizontal", 'id -> "resolveForm")/*76.96*/ {_display_(Seq[Any](format.raw/*76.98*/("""
				"""),format.raw/*77.5*/("""<button name ="submitResolve" type="submit" style="display:none;"> 
							   Résoudre
				</button>
			""")))}),format.raw/*80.5*/("""
""")))}))}
  }

  def render(problemInfo:scala.Tuple6[Int, String, String, String, String, Int],participants:List[scala.Tuple2[String, String]]): play.twirl.api.HtmlFormat.Appendable = apply(problemInfo,participants)

  def f:((scala.Tuple6[Int, String, String, String, String, Int],List[scala.Tuple2[String, String]]) => play.twirl.api.HtmlFormat.Appendable) = (problemInfo,participants) => apply(problemInfo,participants)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:15:50 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/administrationProblem.scala.html
                  HASH: 5ccdf655422b69c1e2708cbefccfca7e2a287fef
                  MATRIX: 604->1|802->96|829->114|856->116|900->152|938->153|965->154|1031->194|1058->195|1091->202|1175->259|1203->260|1231->261|1321->323|1350->324|1384->331|1510->429|1539->430|1574->438|1674->511|1702->512|1739->522|1854->610|1882->611|1910->612|2140->815|2160->826|2184->829|2323->941|2344->952|2369->955|2503->1062|2524->1073|2549->1076|2687->1187|2708->1198|2733->1201|2828->1269|2849->1281|2877->1288|2924->1309|2961->1337|3001->1339|3035->1346|3120->1414|3133->1419|3172->1420|3206->1427|3293->1484|3327->1491|3387->1525|3425->1547|3464->1548|3503->1559|3577->1606|3587->1607|3611->1610|3648->1620|3658->1621|3682->1624|3740->1652|3772->1657|4039->1898|4054->1904|4134->1975|4174->1977|4206->1982|4319->2065|4349->2068|4392->2085|4407->2091|4479->2154|4519->2156|4568->2177|4679->2258|4709->2261|4758->2284|4772->2290|4868->2377|4908->2379|4940->2384|5075->2489
                  LINES: 19->1|22->1|23->3|24->4|24->4|24->4|25->5|27->7|27->7|28->8|31->11|31->11|32->12|34->14|34->14|35->15|37->17|37->17|38->18|40->20|40->20|42->22|44->24|44->24|45->25|51->31|51->31|51->31|52->32|52->32|52->32|53->33|53->33|53->33|54->34|54->34|54->34|55->35|55->35|55->35|57->37|57->37|57->37|58->38|59->39|59->39|59->39|60->40|61->41|62->42|63->43|63->43|63->43|64->44|65->45|65->45|65->45|65->45|65->45|65->45|67->47|68->48|82->62|82->62|82->62|82->62|83->63|86->66|87->67|89->69|89->69|89->69|89->69|91->71|92->72|93->73|96->76|96->76|96->76|96->76|97->77|100->80
                  -- GENERATED --
              */
          