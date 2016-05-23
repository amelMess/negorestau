
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
object problemSelection extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[Int,List[scala.Tuple8[Int, String, String, String, String, String, Int, Int]],List[scala.Tuple9[Int, String, String, String, String, String, Int, String, Int]],List[scala.Tuple6[Int, String, String, String, Int, Int]],Form[scala.Tuple2[String, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(idUser: Int,problemsWithoutSolution:List[(Int, String, String, String, String, String, Int, Int)], problemsWithSolution:List[(Int, String, String, String, String, String, Int, String, Int)],
problemsAdmin:List[(Int, String, String, String, Int, Int)], problemForm: Form[(String, String)]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.api.libs.json.Json

Seq[Any](format.raw/*2.98*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/main("Sélection d'un problème")/*6.33*/{_display_(Seq[Any](format.raw/*6.34*/("""


"""),format.raw/*9.1*/("""<script type="text/javascript">
	function submitProblem() """),format.raw/*10.27*/("""{"""),format.raw/*10.28*/("""
		"""),format.raw/*11.3*/("""var radios = document.getElementsByName('problem');
		var valeur = -1;
		for(var i = 0; i < radios.length; i++)"""),format.raw/*13.41*/("""{"""),format.raw/*13.42*/("""
			"""),format.raw/*14.4*/("""if(radios[i].checked)"""),format.raw/*14.25*/("""{"""),format.raw/*14.26*/("""
				"""),format.raw/*15.5*/("""valeur = radios[i].value;
				break;
			"""),format.raw/*17.4*/("""}"""),format.raw/*17.5*/("""
		"""),format.raw/*18.3*/("""}"""),format.raw/*18.4*/("""
		"""),format.raw/*19.3*/("""if(valeur == -1) """),format.raw/*19.20*/("""{"""),format.raw/*19.21*/("""
			"""),format.raw/*20.4*/("""alert("Veuillez choisir un problème")
		"""),format.raw/*21.3*/("""}"""),format.raw/*21.4*/("""else"""),format.raw/*21.8*/("""{"""),format.raw/*21.9*/("""
			"""),format.raw/*22.4*/("""document.getElementById("idProblem").value = valeur;
			document.getElementById("role").value = "participer";
	        document.getElementById("problemForm").submit();
    	"""),format.raw/*25.6*/("""}"""),format.raw/*25.7*/("""
	"""),format.raw/*26.2*/("""}"""),format.raw/*26.3*/("""
	"""),format.raw/*27.2*/("""function submitAdmin() """),format.raw/*27.25*/("""{"""),format.raw/*27.26*/("""
		"""),format.raw/*28.3*/("""var radios = document.getElementsByName('admin');
		var valeur = -1;
		for(var i = 0; i < radios.length; i++)"""),format.raw/*30.41*/("""{"""),format.raw/*30.42*/("""
			"""),format.raw/*31.4*/("""if(radios[i].checked)"""),format.raw/*31.25*/("""{"""),format.raw/*31.26*/("""
				"""),format.raw/*32.5*/("""valeur = radios[i].value;
				break;
			"""),format.raw/*34.4*/("""}"""),format.raw/*34.5*/("""
		"""),format.raw/*35.3*/("""}"""),format.raw/*35.4*/("""
		"""),format.raw/*36.3*/("""if(valeur == -1) """),format.raw/*36.20*/("""{"""),format.raw/*36.21*/("""
			"""),format.raw/*37.4*/("""alert("Veuillez choisir un problème")
		"""),format.raw/*38.3*/("""}"""),format.raw/*38.4*/("""else"""),format.raw/*38.8*/("""{"""),format.raw/*38.9*/("""
			"""),format.raw/*39.4*/("""document.getElementById("idProblem").value = valeur;
			document.getElementById("role").value = "admin";
	        document.getElementById("problemForm").submit();
    	"""),format.raw/*42.6*/("""}"""),format.raw/*42.7*/("""
	"""),format.raw/*43.2*/("""}"""),format.raw/*43.3*/("""
"""),format.raw/*44.1*/("""</script>
"""),_display_(/*45.2*/if(problemsWithSolution.length > 0)/*45.37*/ {_display_(Seq[Any](format.raw/*45.39*/("""
	"""),_display_(/*46.3*/if(problemsWithSolution.length == 1)/*46.39*/{_display_(Seq[Any](format.raw/*46.40*/("""
		"""),format.raw/*47.3*/("""<h3>Problème résolu</h3>
	""")))}/*48.3*/else/*48.8*/{_display_(Seq[Any](format.raw/*48.9*/("""
		"""),format.raw/*49.3*/("""<h3>Problèmes résolus</h3>
	""")))}),format.raw/*50.3*/("""	
	"""),format.raw/*51.2*/("""<div style="overflow:auto;">
	<table id="tableau" style="margin:0;overflow:hidden">
		<tr>
			<th style="width:38%;">Problème</th>
			<th>Date de création</th>
			<th>Créateur</th>
			<th>Nb participants</th>
			<th>Solution</th>
		</tr>
	</table>
	</div>
	<div style="max-height:200px;overflow-Y:auto;">
	<table  id="tableau" style="margin:0;overflow:hidden">
	     """),_display_(/*64.8*/for(p <- problemsWithSolution) yield /*64.38*/{_display_(Seq[Any](format.raw/*64.39*/(""" 
	    """),format.raw/*65.6*/("""<tr>
		   	<td style="width:38%;">"""),_display_(/*66.31*/p/*66.32*/._2),format.raw/*66.35*/("""</td>
		   	<td>"""),_display_(/*67.12*/p/*67.13*/._3),format.raw/*67.16*/("""</td>
		   	<td>"""),_display_(/*68.12*/p/*68.13*/._6),format.raw/*68.16*/(""" """),_display_(/*68.18*/p/*68.19*/._5),format.raw/*68.22*/("""</td>
		   	<td>"""),_display_(/*69.12*/p/*69.13*/._9),format.raw/*69.16*/("""</td>
		   	<td>"""),_display_(/*70.12*/p/*70.13*/._8),format.raw/*70.16*/("""</td>
	   </tr>
		""")))}),format.raw/*72.4*/("""
	"""),format.raw/*73.2*/("""</table>
	</div>
""")))}),format.raw/*75.2*/("""

"""),_display_(/*77.2*/if(problemsWithoutSolution.length > 0)/*77.40*/ {_display_(Seq[Any](format.raw/*77.42*/("""
	"""),_display_(/*78.3*/if(problemsWithoutSolution.length == 1)/*78.42*/ {_display_(Seq[Any](format.raw/*78.44*/("""
		"""),format.raw/*79.3*/("""<h3>Problème en cours</h3>
	""")))}/*80.3*/else/*80.8*/{_display_(Seq[Any](format.raw/*80.9*/("""
		"""),format.raw/*81.3*/("""<h3>Problèmes en cours</h3>
	""")))}),format.raw/*82.3*/("""
	"""),format.raw/*83.2*/("""<div style="overflow:auto;"	>
	<table id="tableau" style="margin:0;overflow:hidden">
		<tr>
			<th></th>
			<th style="width:38%;">Problème</th>
			<th>Date de création</th>
			<th style="width:20%;">Créateur</th>
			<th>Nb participants</th>
		</tr>
	</table>
	</div>
	<div style="max-height:200px;overflow-Y:auto;">
	<table id="tableau" style="margin:0;overflow:hidden">
	     """),_display_(/*96.8*/for(p <- problemsWithoutSolution) yield /*96.41*/{_display_(Seq[Any](format.raw/*96.42*/(""" 
	    """),format.raw/*97.6*/("""<tr>
	    	<td><input type="radio" name="problem" value=""""),_display_(/*98.54*/p/*98.55*/._1),format.raw/*98.58*/(""""></td>
		   	<td>"""),_display_(/*99.12*/p/*99.13*/._2),format.raw/*99.16*/("""</td>
		   	<td>"""),_display_(/*100.12*/p/*100.13*/._3),format.raw/*100.16*/("""</td>
		   	<td>"""),_display_(/*101.12*/p/*101.13*/._6),format.raw/*101.16*/(""" """),_display_(/*101.18*/p/*101.19*/._5),format.raw/*101.22*/("""</td>
		   	<td>"""),_display_(/*102.12*/p/*102.13*/._8),format.raw/*102.16*/("""</td>
	   </tr>
		""")))}),format.raw/*104.4*/("""
	"""),format.raw/*105.2*/("""</table>
</div>

<br/>
<table>
	<tr>
		<td style="padding-right:10px">
			<button class="btn btn-primary" name="submit" onclick="submitProblem()"> 
			   Participer
			</button>
    </tr>
</table>
""")))}),format.raw/*117.2*/("""    
"""),_display_(/*118.2*/if(problemsAdmin.length > 0)/*118.30*/ {_display_(Seq[Any](format.raw/*118.32*/("""
	"""),_display_(/*119.3*/if(problemsAdmin.length == 1)/*119.32*/ {_display_(Seq[Any](format.raw/*119.34*/("""
		"""),format.raw/*120.3*/("""<h3>Problème créé</h3>
	""")))}/*121.3*/else/*121.8*/{_display_(Seq[Any](format.raw/*121.9*/("""
		"""),format.raw/*122.3*/("""<h3>Problèmes créés</h3>
	""")))}),format.raw/*123.3*/("""
	"""),format.raw/*124.2*/("""<div style="overflow:auto;"	>
	<table id="tableau" style="margin:0;overflow:hidden">
		<tr>
			<th></th>
			<th style="width:38%;">Problème</th>
			<th>Date de création</th>
			<th>Nb participants</th>
		</tr>
	</table>
	</div>
	<div style="max-height:200px;overflow-Y:auto;">
	<table id="tableau" style="margin:0;overflow:hidden">
	     """),_display_(/*136.8*/for(p <- problemsAdmin) yield /*136.31*/{_display_(Seq[Any](format.raw/*136.32*/(""" 
	    """),format.raw/*137.6*/("""<tr>
	    	<td style="width:5%;"><input type="radio" name="admin" value=""""),_display_(/*138.70*/p/*138.71*/._1),format.raw/*138.74*/(""""></td>
		   	<td style="width:38%;">"""),_display_(/*139.31*/p/*139.32*/._2),format.raw/*139.35*/("""</td>
		   	<td>"""),_display_(/*140.12*/p/*140.13*/._3),format.raw/*140.16*/("""</td>
		   	<td>"""),_display_(/*141.12*/p/*141.13*/._6),format.raw/*141.16*/("""</td>
	   </tr>
		""")))}),format.raw/*143.4*/("""
	"""),format.raw/*144.2*/("""</table>
</div>
""")))}),format.raw/*146.2*/("""
"""),format.raw/*147.1*/("""<br/>
<table>
	<tr>
		<td style="padding-right:10px">
			"""),_display_(/*151.5*/helper/*151.11*/.form(action = routes.ProblemCreation.creation, 'class -> "form-horizontal")/*151.87*/ {_display_(Seq[Any](format.raw/*151.89*/("""
			  
			            """),format.raw/*153.16*/("""<button class="btn btn-primary">Créer un problème</button>
			    """)))}),format.raw/*154.9*/("""
    	"""),format.raw/*155.6*/("""</td>
    	"""),_display_(/*156.7*/if(problemsAdmin.length > 0)/*156.35*/ {_display_(Seq[Any](format.raw/*156.37*/("""
	    	"""),format.raw/*157.7*/("""<td style="padding-right:10px">
				<button class="btn btn-primary" name="submit" onclick="submitAdmin()"> 
				   Administrer
				</button>
			</td>
		""")))}),format.raw/*162.4*/("""
		"""),format.raw/*163.3*/("""<td >
			"""),_display_(/*164.5*/helper/*164.11*/.form(action = routes.Auth.logout, 'class -> "form-horizontal")/*164.74*/ {_display_(Seq[Any](format.raw/*164.76*/("""
				"""),format.raw/*165.5*/("""<button class="btn btn-danger"> 
				   Se déconnecter
				</button>
			""")))}),format.raw/*168.5*/("""	
		"""),format.raw/*169.3*/("""</td>
    </tr>
</table>    
"""),_display_(/*172.2*/helper/*172.8*/.form(action = routes.Index.submit, 'class -> "form-horizontal", 'id -> "problemForm")/*172.94*/ {_display_(Seq[Any](format.raw/*172.96*/("""
  
    """),format.raw/*174.5*/("""<input type="hidden" id="idProblem" name=""""),_display_(/*174.48*/problemForm("problem")/*174.70*/.name),format.raw/*174.75*/("""">
    <input type="hidden" id="role" name=""""),_display_(/*175.43*/problemForm("role")/*175.62*/.name),format.raw/*175.67*/("""" value="participer">
     <div class="form-actions">
            <button name ="submitProblem" type="submit" class="btn btn-primary" style="display:none;">Submit</button>
      </div>
    """)))}),format.raw/*179.6*/("""
""")))}))}
  }

  def render(idUser:Int,problemsWithoutSolution:List[scala.Tuple8[Int, String, String, String, String, String, Int, Int]],problemsWithSolution:List[scala.Tuple9[Int, String, String, String, String, String, Int, String, Int]],problemsAdmin:List[scala.Tuple6[Int, String, String, String, Int, Int]],problemForm:Form[scala.Tuple2[String, String]]): play.twirl.api.HtmlFormat.Appendable = apply(idUser,problemsWithoutSolution,problemsWithSolution,problemsAdmin,problemForm)

  def f:((Int,List[scala.Tuple8[Int, String, String, String, String, String, Int, Int]],List[scala.Tuple9[Int, String, String, String, String, String, Int, String, Int]],List[scala.Tuple6[Int, String, String, String, Int, Int]],Form[scala.Tuple2[String, String]]) => play.twirl.api.HtmlFormat.Appendable) = (idUser,problemsWithoutSolution,problemsWithSolution,problemsAdmin,problemForm) => apply(idUser,problemsWithoutSolution,problemsWithSolution,problemsAdmin,problemForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:26:36 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/problemSelection.scala.html
                  HASH: 53c250cbbaa49c48e6403281ddd168d8858ea9d4
                  MATRIX: 762->1|1169->290|1197->324|1224->326|1263->357|1301->358|1330->361|1416->419|1445->420|1475->423|1614->534|1643->535|1674->539|1723->560|1752->561|1784->566|1851->606|1879->607|1909->610|1937->611|1967->614|2012->631|2041->632|2072->636|2139->676|2167->677|2198->681|2226->682|2257->686|2457->859|2485->860|2514->862|2542->863|2571->865|2622->888|2651->889|2681->892|2818->1001|2847->1002|2878->1006|2927->1027|2956->1028|2988->1033|3055->1073|3083->1074|3113->1077|3141->1078|3171->1081|3216->1098|3245->1099|3276->1103|3343->1143|3371->1144|3402->1148|3430->1149|3461->1153|3656->1321|3684->1322|3713->1324|3741->1325|3769->1326|3806->1337|3850->1372|3890->1374|3919->1377|3964->1413|4003->1414|4033->1417|4078->1444|4090->1449|4128->1450|4158->1453|4217->1482|4247->1485|4641->1853|4687->1883|4726->1884|4760->1891|4822->1926|4832->1927|4856->1930|4900->1947|4910->1948|4934->1951|4978->1968|4988->1969|5012->1972|5041->1974|5051->1975|5075->1978|5119->1995|5129->1996|5153->1999|5197->2016|5207->2017|5231->2020|5280->2039|5309->2041|5357->2059|5386->2062|5433->2100|5473->2102|5502->2105|5550->2144|5590->2146|5620->2149|5667->2178|5679->2183|5717->2184|5747->2187|5807->2217|5836->2219|6241->2598|6290->2631|6329->2632|6363->2639|6448->2697|6458->2698|6482->2701|6528->2720|6538->2721|6562->2724|6607->2741|6618->2742|6643->2745|6688->2762|6699->2763|6724->2766|6754->2768|6765->2769|6790->2772|6835->2789|6846->2790|6871->2793|6921->2812|6951->2814|7180->3012|7213->3018|7251->3046|7292->3048|7322->3051|7361->3080|7402->3082|7433->3085|7477->3110|7490->3115|7529->3116|7560->3119|7618->3146|7648->3148|8014->3487|8054->3510|8094->3511|8129->3518|8231->3592|8242->3593|8267->3596|8333->3634|8344->3635|8369->3638|8414->3655|8425->3656|8450->3659|8495->3676|8506->3677|8531->3680|8581->3699|8611->3701|8659->3718|8688->3719|8773->3777|8789->3783|8875->3859|8916->3861|8967->3883|9065->3950|9099->3956|9138->3968|9176->3996|9217->3998|9252->4005|9436->4158|9467->4161|9504->4171|9520->4177|9593->4240|9634->4242|9667->4247|9771->4320|9803->4324|9860->4354|9875->4360|9971->4446|10012->4448|10048->4456|10119->4499|10151->4521|10178->4526|10251->4571|10280->4590|10307->4595|10528->4785
                  LINES: 19->1|23->2|25->5|26->6|26->6|26->6|29->9|30->10|30->10|31->11|33->13|33->13|34->14|34->14|34->14|35->15|37->17|37->17|38->18|38->18|39->19|39->19|39->19|40->20|41->21|41->21|41->21|41->21|42->22|45->25|45->25|46->26|46->26|47->27|47->27|47->27|48->28|50->30|50->30|51->31|51->31|51->31|52->32|54->34|54->34|55->35|55->35|56->36|56->36|56->36|57->37|58->38|58->38|58->38|58->38|59->39|62->42|62->42|63->43|63->43|64->44|65->45|65->45|65->45|66->46|66->46|66->46|67->47|68->48|68->48|68->48|69->49|70->50|71->51|84->64|84->64|84->64|85->65|86->66|86->66|86->66|87->67|87->67|87->67|88->68|88->68|88->68|88->68|88->68|88->68|89->69|89->69|89->69|90->70|90->70|90->70|92->72|93->73|95->75|97->77|97->77|97->77|98->78|98->78|98->78|99->79|100->80|100->80|100->80|101->81|102->82|103->83|116->96|116->96|116->96|117->97|118->98|118->98|118->98|119->99|119->99|119->99|120->100|120->100|120->100|121->101|121->101|121->101|121->101|121->101|121->101|122->102|122->102|122->102|124->104|125->105|137->117|138->118|138->118|138->118|139->119|139->119|139->119|140->120|141->121|141->121|141->121|142->122|143->123|144->124|156->136|156->136|156->136|157->137|158->138|158->138|158->138|159->139|159->139|159->139|160->140|160->140|160->140|161->141|161->141|161->141|163->143|164->144|166->146|167->147|171->151|171->151|171->151|171->151|173->153|174->154|175->155|176->156|176->156|176->156|177->157|182->162|183->163|184->164|184->164|184->164|184->164|185->165|188->168|189->169|192->172|192->172|192->172|192->172|194->174|194->174|194->174|194->174|195->175|195->175|195->175|199->179
                  -- GENERATED --
              */
          