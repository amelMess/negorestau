
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
object problem extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template8[Int,scala.Tuple7[Int, String, String, String, String, String, String],List[scala.Tuple4[Int, String, String, String]],List[scala.Tuple2[Int, Int]],List[scala.Tuple2[Int, String]],List[scala.Tuple2[Int, String]],List[scala.Tuple2[Int, String]],Form[scala.Tuple4[String, String, String, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: Int, problem: (Int, String, String, String, String, String, String), choices: List[(Int, String, String, String)], prefer: List[(Int, Int)], 
dominantNames: List[(Int, String)], dominatedNames: List[(Int, String)], admissibleChoices:List[(Int, String)], updateForm: Form[(String, String, String,String)]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.163*/("""

"""),_display_(/*4.2*/main("Participation à un problème")/*4.37*/ {_display_(Seq[Any](format.raw/*4.39*/("""

  """),format.raw/*6.3*/("""<h2>"""),_display_(/*6.8*/problem/*6.15*/._2),format.raw/*6.18*/("""</h2>
  <h4>Par """),_display_(/*7.12*/problem/*7.19*/._6),format.raw/*7.22*/(""" """),_display_(/*7.24*/problem/*7.31*/._5),format.raw/*7.34*/("""</h4>
  <h4>"""),_display_(/*8.8*/problem/*8.15*/._3),format.raw/*8.18*/("""</h4>
  <h4>"""),_display_(/*9.8*/problem/*9.15*/._7),format.raw/*9.18*/("""</h4>
  
 
  <table cellspacing="2">
    <tr>
      <td rowspan=15><div id="mynetwork"></div></td>
    </tr>
     """),_display_(/*16.7*/for(c <- choices) yield /*16.24*/{_display_(Seq[Any](format.raw/*16.25*/(""" 
    """),format.raw/*17.5*/("""<tr>
   	<td valign="top"><button id=""""),_display_(/*18.35*/c/*18.36*/._1),format.raw/*18.39*/("""" style="width:100px" class="btn btn-primary" title=""""),_display_(/*18.93*/c/*18.94*/._3),format.raw/*18.97*/("""" name=""""),_display_(/*18.106*/c/*18.107*/._2),format.raw/*18.110*/("""" onclick="addNodeWithId(this.name, this.id);"> """),_display_(/*18.159*/c/*18.160*/._2),format.raw/*18.163*/("""</button></td>
   </tr>
	""")))}),format.raw/*20.3*/("""
"""),format.raw/*21.1*/("""</table>
<table>
  <tr>
    <td style="padding-right:10px">
      <button class="btn btn-primary" name="submit" onclick="submitChoices()"> 
         Envoyer
      </button>
    </td>
    <td>
      """),_display_(/*30.8*/helper/*30.14*/.form(action = routes.Index.index, 'class -> "form-horizontal")/*30.77*/ {_display_(Seq[Any](format.raw/*30.79*/("""
                    
                    """),format.raw/*32.21*/("""<button class="btn btn-primary">Retour à la sélection des problèmes</button>
            """)))}),format.raw/*33.14*/("""
    """),format.raw/*34.5*/("""</td>
  </tr>
</table>
<script type="text/javascript">
    // create an array with nodes
    
    var nodes = new vis.DataSet([

    ]);
    
    // create an array with edges
    var edges = new vis.DataSet([
       /* """),format.raw/*46.11*/("""{"""),format.raw/*46.12*/("""from: 1, to: 3"""),format.raw/*46.26*/("""}"""),format.raw/*46.27*/(""",
        """),format.raw/*47.9*/("""{"""),format.raw/*47.10*/("""from: 1, to: 2"""),format.raw/*47.24*/("""}"""),format.raw/*47.25*/(""",
        """),format.raw/*48.9*/("""{"""),format.raw/*48.10*/("""from: 2, to: 4"""),format.raw/*48.24*/("""}"""),format.raw/*48.25*/(""",
        """),format.raw/*49.9*/("""{"""),format.raw/*49.10*/("""from: 2, to: 5"""),format.raw/*49.24*/("""}"""),format.raw/*49.25*/("""*/
    ]);

    // create a network
    var container = document.getElementById('mynetwork');

    // provide the data in the vis format
    var data = """),format.raw/*56.16*/("""{"""),format.raw/*56.17*/("""
        """),format.raw/*57.9*/("""nodes: nodes,
        edges: edges
    """),format.raw/*59.5*/("""}"""),format.raw/*59.6*/(""";
    
    var locales = """),format.raw/*61.19*/("""{"""),format.raw/*61.20*/("""
      """),format.raw/*62.7*/("""en: """),format.raw/*62.11*/("""{"""),format.raw/*62.12*/("""
        """),format.raw/*63.9*/("""edit: 'Editer',
        del: 'Supprimer',
        back: 'Retour',
        addEdge: 'Ajouter un arc',
        editEdge: 'Editer l\'arc',
        edgeDescription: 'Cliquez sur un noeud et faites glisser vers un autre noeud pour les relier.',
        editEdgeDescription: 'Cliquez sur les points et faites glisser vers un noeud pour les relier.'
      """),format.raw/*70.7*/("""}"""),format.raw/*70.8*/("""
    """),format.raw/*71.5*/("""}"""),format.raw/*71.6*/("""
    """),format.raw/*72.5*/("""var options = """),format.raw/*72.19*/("""{"""),format.raw/*72.20*/("""
      """),format.raw/*73.7*/("""autoResize: false,
      locales: locales,
      manipulation: """),format.raw/*75.21*/("""{"""),format.raw/*75.22*/("""
        """),format.raw/*76.9*/("""enabled: true,
        initiallyActive: true,
        addNode: false,
        addEdge: true,
        editNode: undefined,
        editEdge: true,
        deleteNode: true,
        deleteEdge: true,
        controlNodeStyle:"""),format.raw/*84.26*/("""{"""),format.raw/*84.27*/("""
        """),format.raw/*85.9*/("""}"""),format.raw/*85.10*/("""
      """),format.raw/*86.7*/("""}"""),format.raw/*86.8*/(""",
      layout: """),format.raw/*87.15*/("""{"""),format.raw/*87.16*/("""
        """),format.raw/*88.9*/("""randomSeed:undefined,  
        improvedLayout:true,
        hierarchical: """),format.raw/*90.23*/("""{"""),format.raw/*90.24*/("""
          """),format.raw/*91.11*/("""enabled:false,
          levelSeparation: 70,
          direction: 'UD',   // UD, DU, LR, RL
          sortMethod: 'directed' // hubsize, directed
        """),format.raw/*95.9*/("""}"""),format.raw/*95.10*/("""
      """),format.raw/*96.7*/("""}"""),format.raw/*96.8*/(""",
      edges:"""),format.raw/*97.13*/("""{"""),format.raw/*97.14*/("""
        """),format.raw/*98.9*/("""arrows: 'to',
      """),format.raw/*99.7*/("""}"""),format.raw/*99.8*/(""",
      physics:"""),format.raw/*100.15*/("""{"""),format.raw/*100.16*/("""
        """),format.raw/*101.9*/("""enabled: true,
        repulsion: """),format.raw/*102.20*/("""{"""),format.raw/*102.21*/("""
          """),format.raw/*103.11*/("""nodeDistance: 50
        """),format.raw/*104.9*/("""}"""),format.raw/*104.10*/(""",
        maxVelocity: 5,
        solver: 'barnesHut',
        stabilization: """),format.raw/*107.24*/("""{"""),format.raw/*107.25*/("""
          """),format.raw/*108.11*/("""enabled: false
        """),format.raw/*109.9*/("""}"""),format.raw/*109.10*/("""
      """),format.raw/*110.7*/("""}"""),format.raw/*110.8*/("""
      
    """),format.raw/*112.5*/("""}"""),format.raw/*112.6*/("""

    """),format.raw/*114.5*/("""// initialize your network!
    var network = new vis.Network(container, data, options);
    
    """),_display_(/*117.6*/for(d <- admissibleChoices) yield /*117.33*/{_display_(Seq[Any](format.raw/*117.34*/("""
    
      """),format.raw/*119.7*/("""addNodeWithId('"""),_display_(/*119.23*/d/*119.24*/._2),format.raw/*119.27*/("""', '"""),_display_(/*119.32*/d/*119.33*/._1),format.raw/*119.36*/("""')
    """)))}),format.raw/*120.6*/("""
    """),_display_(/*121.6*/for(d <- dominantNames) yield /*121.29*/{_display_(Seq[Any](format.raw/*121.30*/("""
    
      """),format.raw/*123.7*/("""addNodeWithId('"""),_display_(/*123.23*/d/*123.24*/._2),format.raw/*123.27*/("""', '"""),_display_(/*123.32*/d/*123.33*/._1),format.raw/*123.36*/("""')
    """)))}),format.raw/*124.6*/("""
    """),_display_(/*125.6*/for(d <- dominatedNames) yield /*125.30*/{_display_(Seq[Any](format.raw/*125.31*/("""
      
      """),format.raw/*127.7*/("""addNodeWithId('"""),_display_(/*127.23*/d/*127.24*/._2),format.raw/*127.27*/("""', '"""),_display_(/*127.32*/d/*127.33*/._1),format.raw/*127.36*/("""')
    """)))}),format.raw/*128.6*/("""
    """),_display_(/*129.6*/for(p <- prefer) yield /*129.22*/{_display_(Seq[Any](format.raw/*129.23*/("""
      
      """),format.raw/*131.7*/("""addEdge('"""),_display_(/*131.17*/p/*131.18*/._1),format.raw/*131.21*/("""', '"""),_display_(/*131.26*/p/*131.27*/._2),format.raw/*131.30*/("""')
    """)))}),format.raw/*132.6*/("""
    

    """),format.raw/*135.5*/("""function addNode(name) """),format.raw/*135.28*/("""{"""),format.raw/*135.29*/("""
        """),format.raw/*136.9*/("""//S'il n'existe pas de noeud avec ce label
        var node = nodes.get("""),format.raw/*137.30*/("""{"""),format.raw/*137.31*/("""
          """),format.raw/*138.11*/("""filter: function (item) """),format.raw/*138.35*/("""{"""),format.raw/*138.36*/("""
            """),format.raw/*139.13*/("""return (item.label == name);
          """),format.raw/*140.11*/("""}"""),format.raw/*140.12*/("""
        """),format.raw/*141.9*/("""}"""),format.raw/*141.10*/(""");
        //recuperer l'objet d'id max
        var maxId = nodes.max('id');
        if(maxId == null)
        	nodes.add("""),format.raw/*145.20*/("""{"""),format.raw/*145.21*/("""id:1, label:name"""),format.raw/*145.37*/("""}"""),format.raw/*145.38*/(""");
        else if(node.length == 0)
	        nodes.add("""),format.raw/*147.20*/("""{"""),format.raw/*147.21*/("""id:maxId.id+1, label:name"""),format.raw/*147.46*/("""}"""),format.raw/*147.47*/(""");
    """),format.raw/*148.5*/("""}"""),format.raw/*148.6*/("""

    """),format.raw/*150.5*/("""function addNodeWithId(name, idNode) """),format.raw/*150.42*/("""{"""),format.raw/*150.43*/("""
		  """),format.raw/*151.5*/("""var node = nodes.get("""),format.raw/*151.26*/("""{"""),format.raw/*151.27*/("""
          """),format.raw/*152.11*/("""filter: function (item) """),format.raw/*152.35*/("""{"""),format.raw/*152.36*/("""
            """),format.raw/*153.13*/("""return (item.id == idNode);
          """),format.raw/*154.11*/("""}"""),format.raw/*154.12*/("""
        """),format.raw/*155.9*/("""}"""),format.raw/*155.10*/(""");
      if(node.length == 0)
        nodes.add("""),format.raw/*157.19*/("""{"""),format.raw/*157.20*/("""id:idNode, label:name"""),format.raw/*157.41*/("""}"""),format.raw/*157.42*/(""");
    """),format.raw/*158.5*/("""}"""),format.raw/*158.6*/("""
    """),format.raw/*159.5*/("""function addEdge(idDominant, idDominated) """),format.raw/*159.47*/("""{"""),format.raw/*159.48*/("""
        """),format.raw/*160.9*/("""edges.add("""),format.raw/*160.19*/("""{"""),format.raw/*160.20*/("""from:idDominant, to:idDominated"""),format.raw/*160.51*/("""}"""),format.raw/*160.52*/(""");
    """),format.raw/*161.5*/("""}"""),format.raw/*161.6*/("""

    """),format.raw/*163.5*/("""function submitChoices() """),format.raw/*163.30*/("""{"""),format.raw/*163.31*/("""
      """),format.raw/*164.7*/("""var i, j;
      var nodesIds = nodes.getIds();
      
      var froms = edges.get("""),format.raw/*167.29*/("""{"""),format.raw/*167.30*/("""
        """),format.raw/*168.9*/("""fields: ['from'], 
        type: """),format.raw/*169.15*/("""{"""),format.raw/*169.16*/("""
          """),format.raw/*170.11*/("""from: 'String'
        """),format.raw/*171.9*/("""}"""),format.raw/*171.10*/("""
      """),format.raw/*172.7*/("""}"""),format.raw/*172.8*/(""");
      var tos = edges.get("""),format.raw/*173.27*/("""{"""),format.raw/*173.28*/("""
        """),format.raw/*174.9*/("""fields: ['to'], 
        type: """),format.raw/*175.15*/("""{"""),format.raw/*175.16*/("""
          """),format.raw/*176.11*/("""to: 'String'
        """),format.raw/*177.9*/("""}"""),format.raw/*177.10*/("""
      """),format.raw/*178.7*/("""}"""),format.raw/*178.8*/(""");
      var admissible = "";
      for (i = 0; i < nodesIds.length; i++) """),format.raw/*180.45*/("""{"""),format.raw/*180.46*/("""
        """),format.raw/*181.9*/("""if(i==0)
          admissible = admissible + nodesIds[i]
        else
          admissible = admissible + " " + nodesIds[i]
      """),format.raw/*185.7*/("""}"""),format.raw/*185.8*/("""
    
      """),format.raw/*187.7*/("""var prefer = "";
      for (j = 0; j < froms.length; j++) """),format.raw/*188.42*/("""{"""),format.raw/*188.43*/("""
          """),format.raw/*189.11*/("""if(j==0)
            prefer = prefer + froms[j]["from"] + " " + tos[j]["to"]
          else
            prefer = prefer + "," + froms[j]["from"] + " " + tos[j]["to"]
      """),format.raw/*193.7*/("""}"""),format.raw/*193.8*/("""

        """),format.raw/*195.9*/("""document.getElementById("admissible").value = admissible;
        
        document.getElementById("prefer").value = prefer;

        document.getElementById("updateForm").submit();
        alert("Préférences enregistrées")  
    """),format.raw/*201.5*/("""}"""),format.raw/*201.6*/("""
    
"""),format.raw/*203.1*/("""</script>
"""),_display_(/*204.2*/helper/*204.8*/.form(action = routes.Problem.update, 'class -> "form-horizontal", 'id -> "updateForm")/*204.95*/ {_display_(Seq[Any](format.raw/*204.97*/("""
  
    """),format.raw/*206.5*/("""<input type="hidden" name=""""),_display_(/*206.33*/updateForm("problem")/*206.54*/.name),format.raw/*206.59*/("""" value =""""),_display_(/*206.70*/problem/*206.77*/._1),format.raw/*206.80*/("""">
    <input type="hidden" name=""""),_display_(/*207.33*/updateForm("user")/*207.51*/.name),format.raw/*207.56*/("""" value =""""),_display_(/*207.67*/user),format.raw/*207.71*/("""">
    <input type="hidden" id ="prefer" name=""""),_display_(/*208.46*/updateForm("preferChoice")/*208.72*/.name),format.raw/*208.77*/("""">
    <input type="hidden" id ="admissible" name=""""),_display_(/*209.50*/updateForm("admissible")/*209.74*/.name),format.raw/*209.79*/("""" >
     <div class="form-actions">
            <button name ="submitGraph" type="submit" class="btn btn-primary" style="display:none;">Submit</button>
      </div>
    <br><br>
    """)))}),format.raw/*214.6*/("""
    
""")))}),format.raw/*216.2*/("""
"""))}
  }

  def render(user:Int,problem:scala.Tuple7[Int, String, String, String, String, String, String],choices:List[scala.Tuple4[Int, String, String, String]],prefer:List[scala.Tuple2[Int, Int]],dominantNames:List[scala.Tuple2[Int, String]],dominatedNames:List[scala.Tuple2[Int, String]],admissibleChoices:List[scala.Tuple2[Int, String]],updateForm:Form[scala.Tuple4[String, String, String, String]]): play.twirl.api.HtmlFormat.Appendable = apply(user,problem,choices,prefer,dominantNames,dominatedNames,admissibleChoices,updateForm)

  def f:((Int,scala.Tuple7[Int, String, String, String, String, String, String],List[scala.Tuple4[Int, String, String, String]],List[scala.Tuple2[Int, Int]],List[scala.Tuple2[Int, String]],List[scala.Tuple2[Int, String]],List[scala.Tuple2[Int, String]],Form[scala.Tuple4[String, String, String, String]]) => play.twirl.api.HtmlFormat.Appendable) = (user,problem,choices,prefer,dominantNames,dominatedNames,admissibleChoices,updateForm) => apply(user,problem,choices,prefer,dominantNames,dominatedNames,admissibleChoices,updateForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 11 13:15:51 CEST 2016
                  SOURCE: /home/amel/Bureau/Master/M1S2/PJI/negoResto/app/views/problem.scala.html
                  HASH: a0024f87ef2369fddc0c8a3679157275747e528c
                  MATRIX: 794->1|1194->312|1222->315|1265->350|1304->352|1334->356|1364->361|1379->368|1402->371|1445->388|1460->395|1483->398|1511->400|1526->407|1549->410|1587->423|1602->430|1625->433|1663->446|1678->453|1701->456|1842->571|1875->588|1914->589|1947->595|2013->634|2023->635|2047->638|2128->692|2138->693|2162->696|2199->705|2210->706|2235->709|2312->758|2323->759|2348->762|2404->788|2432->789|2657->988|2672->994|2744->1057|2784->1059|2854->1101|2975->1191|3007->1196|3255->1416|3284->1417|3326->1431|3355->1432|3392->1442|3421->1443|3463->1457|3492->1458|3529->1468|3558->1469|3600->1483|3629->1484|3666->1494|3695->1495|3737->1509|3766->1510|3946->1662|3975->1663|4011->1672|4077->1711|4105->1712|4158->1737|4187->1738|4221->1745|4253->1749|4282->1750|4318->1759|4694->2108|4722->2109|4754->2114|4782->2115|4814->2120|4856->2134|4885->2135|4919->2142|5010->2205|5039->2206|5075->2215|5326->2438|5355->2439|5391->2448|5420->2449|5454->2456|5482->2457|5526->2473|5555->2474|5591->2483|5694->2558|5723->2559|5762->2570|5944->2725|5973->2726|6007->2733|6035->2734|6077->2748|6106->2749|6142->2758|6189->2778|6217->2779|6262->2795|6292->2796|6329->2805|6392->2839|6422->2840|6462->2851|6515->2876|6545->2877|6652->2955|6682->2956|6722->2967|6773->2990|6803->2991|6838->2998|6867->2999|6907->3011|6936->3012|6970->3018|7096->3117|7140->3144|7180->3145|7220->3157|7264->3173|7275->3174|7300->3177|7333->3182|7344->3183|7369->3186|7408->3194|7441->3200|7481->3223|7521->3224|7561->3236|7605->3252|7616->3253|7641->3256|7674->3261|7685->3262|7710->3265|7749->3273|7782->3279|7823->3303|7863->3304|7905->3318|7949->3334|7960->3335|7985->3338|8018->3343|8029->3344|8054->3347|8093->3355|8126->3361|8159->3377|8199->3378|8241->3392|8279->3402|8290->3403|8315->3406|8348->3411|8359->3412|8384->3415|8423->3423|8462->3434|8514->3457|8544->3458|8581->3467|8682->3539|8712->3540|8752->3551|8805->3575|8835->3576|8877->3589|8945->3628|8975->3629|9012->3638|9042->3639|9193->3761|9223->3762|9268->3778|9298->3779|9383->3835|9413->3836|9467->3861|9497->3862|9532->3869|9561->3870|9595->3876|9661->3913|9691->3914|9724->3919|9774->3940|9804->3941|9844->3952|9897->3976|9927->3977|9969->3990|10036->4028|10066->4029|10103->4038|10133->4039|10210->4087|10240->4088|10290->4109|10320->4110|10355->4117|10384->4118|10417->4123|10488->4165|10518->4166|10555->4175|10594->4185|10624->4186|10684->4217|10714->4218|10749->4225|10778->4226|10812->4232|10866->4257|10896->4258|10931->4265|11042->4347|11072->4348|11109->4357|11171->4390|11201->4391|11241->4402|11292->4425|11322->4426|11357->4433|11386->4434|11444->4463|11474->4464|11511->4473|11571->4504|11601->4505|11641->4516|11690->4537|11720->4538|11755->4545|11784->4546|11887->4620|11917->4621|11954->4630|12112->4760|12141->4761|12181->4773|12268->4831|12298->4832|12338->4843|12538->5015|12567->5016|12605->5026|12863->5256|12892->5257|12926->5263|12964->5274|12979->5280|13076->5367|13117->5369|13153->5377|13209->5405|13240->5426|13267->5431|13306->5442|13323->5449|13348->5452|13411->5487|13439->5505|13466->5510|13505->5521|13531->5525|13607->5573|13643->5599|13670->5604|13750->5656|13784->5680|13811->5685|14025->5868|14063->5875
                  LINES: 19->1|23->2|25->4|25->4|25->4|27->6|27->6|27->6|27->6|28->7|28->7|28->7|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|37->16|37->16|37->16|38->17|39->18|39->18|39->18|39->18|39->18|39->18|39->18|39->18|39->18|39->18|39->18|39->18|41->20|42->21|51->30|51->30|51->30|51->30|53->32|54->33|55->34|67->46|67->46|67->46|67->46|68->47|68->47|68->47|68->47|69->48|69->48|69->48|69->48|70->49|70->49|70->49|70->49|77->56|77->56|78->57|80->59|80->59|82->61|82->61|83->62|83->62|83->62|84->63|91->70|91->70|92->71|92->71|93->72|93->72|93->72|94->73|96->75|96->75|97->76|105->84|105->84|106->85|106->85|107->86|107->86|108->87|108->87|109->88|111->90|111->90|112->91|116->95|116->95|117->96|117->96|118->97|118->97|119->98|120->99|120->99|121->100|121->100|122->101|123->102|123->102|124->103|125->104|125->104|128->107|128->107|129->108|130->109|130->109|131->110|131->110|133->112|133->112|135->114|138->117|138->117|138->117|140->119|140->119|140->119|140->119|140->119|140->119|140->119|141->120|142->121|142->121|142->121|144->123|144->123|144->123|144->123|144->123|144->123|144->123|145->124|146->125|146->125|146->125|148->127|148->127|148->127|148->127|148->127|148->127|148->127|149->128|150->129|150->129|150->129|152->131|152->131|152->131|152->131|152->131|152->131|152->131|153->132|156->135|156->135|156->135|157->136|158->137|158->137|159->138|159->138|159->138|160->139|161->140|161->140|162->141|162->141|166->145|166->145|166->145|166->145|168->147|168->147|168->147|168->147|169->148|169->148|171->150|171->150|171->150|172->151|172->151|172->151|173->152|173->152|173->152|174->153|175->154|175->154|176->155|176->155|178->157|178->157|178->157|178->157|179->158|179->158|180->159|180->159|180->159|181->160|181->160|181->160|181->160|181->160|182->161|182->161|184->163|184->163|184->163|185->164|188->167|188->167|189->168|190->169|190->169|191->170|192->171|192->171|193->172|193->172|194->173|194->173|195->174|196->175|196->175|197->176|198->177|198->177|199->178|199->178|201->180|201->180|202->181|206->185|206->185|208->187|209->188|209->188|210->189|214->193|214->193|216->195|222->201|222->201|224->203|225->204|225->204|225->204|225->204|227->206|227->206|227->206|227->206|227->206|227->206|227->206|228->207|228->207|228->207|228->207|228->207|229->208|229->208|229->208|230->209|230->209|230->209|235->214|237->216
                  -- GENERATED --
              */
          