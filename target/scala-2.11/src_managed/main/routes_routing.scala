// @SOURCE:/home/amel/Bureau/Master/M1S2/PJI/negoResto/conf/routes
// @HASH:0ebdd0c79144e294124ac3117e38a02476f33540
// @DATE:Wed May 11 13:15:50 CEST 2016


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Index_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Index_index0_invoker = createInvoker(
controllers.Index.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Index", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Index_submit1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Index_submit1_invoker = createInvoker(
controllers.Index.submit,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Index", "submit", Nil,"POST", """""", Routes.prefix + """"""))
        

// @LINE:11
private[this] lazy val controllers_Assets_at2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at2_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:12
private[this] lazy val controllers_Auth_authenticate3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Auth_authenticate3_invoker = createInvoker(
controllers.Auth.authenticate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:13
private[this] lazy val controllers_Auth_login4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Auth_login4_invoker = createInvoker(
controllers.Auth.login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "login", Nil,"GET", """""", Routes.prefix + """login"""))
        

// @LINE:14
private[this] lazy val controllers_Auth_logout5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Auth_logout5_invoker = createInvoker(
controllers.Auth.logout,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:15
private[this] lazy val controllers_Problem_problem6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("problem"))))
private[this] lazy val controllers_Problem_problem6_invoker = createInvoker(
controllers.Problem.problem,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problem", "problem", Nil,"GET", """""", Routes.prefix + """problem"""))
        

// @LINE:16
private[this] lazy val controllers_Problem_update7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("problem"))))
private[this] lazy val controllers_Problem_update7_invoker = createInvoker(
controllers.Problem.update,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Problem", "update", Nil,"POST", """""", Routes.prefix + """problem"""))
        

// @LINE:17
private[this] lazy val controllers_Inscription_inscription8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inscription"))))
private[this] lazy val controllers_Inscription_inscription8_invoker = createInvoker(
controllers.Inscription.inscription,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Inscription", "inscription", Nil,"GET", """""", Routes.prefix + """inscription"""))
        

// @LINE:19
private[this] lazy val controllers_ProblemCreation_choix9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("choix"))))
private[this] lazy val controllers_ProblemCreation_choix9_invoker = createInvoker(
controllers.ProblemCreation.choix,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "choix", Nil,"GET", """""", Routes.prefix + """choix"""))
        

// @LINE:20
private[this] lazy val controllers_ProblemCreation_creation10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("new"))))
private[this] lazy val controllers_ProblemCreation_creation10_invoker = createInvoker(
controllers.ProblemCreation.creation,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "creation", Nil,"GET", """""", Routes.prefix + """new"""))
        

// @LINE:21
private[this] lazy val controllers_Inscription_subscribe11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inscription"))))
private[this] lazy val controllers_Inscription_subscribe11_invoker = createInvoker(
controllers.Inscription.subscribe,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Inscription", "subscribe", Nil,"POST", """""", Routes.prefix + """inscription"""))
        

// @LINE:22
private[this] lazy val controllers_ProblemCreation_createProblem12_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("new"))))
private[this] lazy val controllers_ProblemCreation_createProblem12_invoker = createInvoker(
controllers.ProblemCreation.createProblem,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "createProblem", Nil,"POST", """""", Routes.prefix + """new"""))
        

// @LINE:23
private[this] lazy val controllers_ProblemCreation_addChoices13_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("choix"))))
private[this] lazy val controllers_ProblemCreation_addChoices13_invoker = createInvoker(
controllers.ProblemCreation.addChoices,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "addChoices", Nil,"POST", """""", Routes.prefix + """choix"""))
        

// @LINE:24
private[this] lazy val controllers_Admin_admin14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin"))))
private[this] lazy val controllers_Admin_admin14_invoker = createInvoker(
controllers.Admin.admin,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "admin", Nil,"GET", """""", Routes.prefix + """admin"""))
        

// @LINE:25
private[this] lazy val controllers_ProblemCreation_submitChoices15_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("create"))))
private[this] lazy val controllers_ProblemCreation_submitChoices15_invoker = createInvoker(
controllers.ProblemCreation.submitChoices,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "submitChoices", Nil,"POST", """""", Routes.prefix + """create"""))
        

// @LINE:26
private[this] lazy val controllers_Admin_deleteProblem16_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delete"))))
private[this] lazy val controllers_Admin_deleteProblem16_invoker = createInvoker(
controllers.Admin.deleteProblem,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "deleteProblem", Nil,"POST", """""", Routes.prefix + """delete"""))
        

// @LINE:27
private[this] lazy val controllers_Admin_resolve17_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("resolve"))))
private[this] lazy val controllers_Admin_resolve17_invoker = createInvoker(
controllers.Admin.resolve,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "resolve", Nil,"POST", """""", Routes.prefix + """resolve"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Index.index"""),("""POST""", prefix,"""controllers.Index.submit"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Auth.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Auth.login"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Auth.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problem""","""controllers.Problem.problem"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """problem""","""controllers.Problem.update"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inscription""","""controllers.Inscription.inscription"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """choix""","""controllers.ProblemCreation.choix"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """new""","""controllers.ProblemCreation.creation"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inscription""","""controllers.Inscription.subscribe"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """new""","""controllers.ProblemCreation.createProblem"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """choix""","""controllers.ProblemCreation.addChoices"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin""","""controllers.Admin.admin"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """create""","""controllers.ProblemCreation.submitChoices"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delete""","""controllers.Admin.deleteProblem"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """resolve""","""controllers.Admin.resolve""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Index_index0_route(params) => {
   call { 
        controllers_Index_index0_invoker.call(controllers.Index.index)
   }
}
        

// @LINE:7
case controllers_Index_submit1_route(params) => {
   call { 
        controllers_Index_submit1_invoker.call(controllers.Index.submit)
   }
}
        

// @LINE:11
case controllers_Assets_at2_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at2_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:12
case controllers_Auth_authenticate3_route(params) => {
   call { 
        controllers_Auth_authenticate3_invoker.call(controllers.Auth.authenticate)
   }
}
        

// @LINE:13
case controllers_Auth_login4_route(params) => {
   call { 
        controllers_Auth_login4_invoker.call(controllers.Auth.login)
   }
}
        

// @LINE:14
case controllers_Auth_logout5_route(params) => {
   call { 
        controllers_Auth_logout5_invoker.call(controllers.Auth.logout)
   }
}
        

// @LINE:15
case controllers_Problem_problem6_route(params) => {
   call { 
        controllers_Problem_problem6_invoker.call(controllers.Problem.problem)
   }
}
        

// @LINE:16
case controllers_Problem_update7_route(params) => {
   call { 
        controllers_Problem_update7_invoker.call(controllers.Problem.update)
   }
}
        

// @LINE:17
case controllers_Inscription_inscription8_route(params) => {
   call { 
        controllers_Inscription_inscription8_invoker.call(controllers.Inscription.inscription)
   }
}
        

// @LINE:19
case controllers_ProblemCreation_choix9_route(params) => {
   call { 
        controllers_ProblemCreation_choix9_invoker.call(controllers.ProblemCreation.choix)
   }
}
        

// @LINE:20
case controllers_ProblemCreation_creation10_route(params) => {
   call { 
        controllers_ProblemCreation_creation10_invoker.call(controllers.ProblemCreation.creation)
   }
}
        

// @LINE:21
case controllers_Inscription_subscribe11_route(params) => {
   call { 
        controllers_Inscription_subscribe11_invoker.call(controllers.Inscription.subscribe)
   }
}
        

// @LINE:22
case controllers_ProblemCreation_createProblem12_route(params) => {
   call { 
        controllers_ProblemCreation_createProblem12_invoker.call(controllers.ProblemCreation.createProblem)
   }
}
        

// @LINE:23
case controllers_ProblemCreation_addChoices13_route(params) => {
   call { 
        controllers_ProblemCreation_addChoices13_invoker.call(controllers.ProblemCreation.addChoices)
   }
}
        

// @LINE:24
case controllers_Admin_admin14_route(params) => {
   call { 
        controllers_Admin_admin14_invoker.call(controllers.Admin.admin)
   }
}
        

// @LINE:25
case controllers_ProblemCreation_submitChoices15_route(params) => {
   call { 
        controllers_ProblemCreation_submitChoices15_invoker.call(controllers.ProblemCreation.submitChoices)
   }
}
        

// @LINE:26
case controllers_Admin_deleteProblem16_route(params) => {
   call { 
        controllers_Admin_deleteProblem16_invoker.call(controllers.Admin.deleteProblem)
   }
}
        

// @LINE:27
case controllers_Admin_resolve17_route(params) => {
   call { 
        controllers_Admin_resolve17_invoker.call(controllers.Admin.resolve)
   }
}
        
}

}
     