// @SOURCE:/home/amel/Bureau/Master/M1S2/PJI/negoResto/conf/routes
// @HASH:0ebdd0c79144e294124ac3117e38a02476f33540
// @DATE:Wed May 11 13:15:50 CEST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
class ReverseAssets {


// @LINE:11
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:27
// @LINE:26
// @LINE:24
class ReverseAdmin {


// @LINE:27
def resolve(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "resolve")
}
                        

// @LINE:26
def deleteProblem(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "delete")
}
                        

// @LINE:24
def admin(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "admin")
}
                        

}
                          

// @LINE:21
// @LINE:17
class ReverseInscription {


// @LINE:17
def inscription(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "inscription")
}
                        

// @LINE:21
def subscribe(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "inscription")
}
                        

}
                          

// @LINE:14
// @LINE:13
// @LINE:12
class ReverseAuth {


// @LINE:14
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:12
def authenticate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                        

// @LINE:13
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:25
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
class ReverseProblemCreation {


// @LINE:19
def choix(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "choix")
}
                        

// @LINE:25
def submitChoices(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "create")
}
                        

// @LINE:22
def createProblem(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "new")
}
                        

// @LINE:23
def addChoices(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "choix")
}
                        

// @LINE:20
def creation(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "new")
}
                        

}
                          

// @LINE:16
// @LINE:15
class ReverseProblem {


// @LINE:16
def update(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "problem")
}
                        

// @LINE:15
def problem(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "problem")
}
                        

}
                          

// @LINE:7
// @LINE:6
class ReverseIndex {


// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:7
def submit(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix)
}
                        

}
                          
}
                  


// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:11
class ReverseAssets {


// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:27
// @LINE:26
// @LINE:24
class ReverseAdmin {


// @LINE:27
def resolve : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.resolve",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "resolve"})
      }
   """
)
                        

// @LINE:26
def deleteProblem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.deleteProblem",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
      }
   """
)
                        

// @LINE:24
def admin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.admin",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
      }
   """
)
                        

}
              

// @LINE:21
// @LINE:17
class ReverseInscription {


// @LINE:17
def inscription : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Inscription.inscription",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inscription"})
      }
   """
)
                        

// @LINE:21
def subscribe : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Inscription.subscribe",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "inscription"})
      }
   """
)
                        

}
              

// @LINE:14
// @LINE:13
// @LINE:12
class ReverseAuth {


// @LINE:14
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:12
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:13
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Auth.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:25
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
class ReverseProblemCreation {


// @LINE:19
def choix : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProblemCreation.choix",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "choix"})
      }
   """
)
                        

// @LINE:25
def submitChoices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProblemCreation.submitChoices",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "create"})
      }
   """
)
                        

// @LINE:22
def createProblem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProblemCreation.createProblem",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "new"})
      }
   """
)
                        

// @LINE:23
def addChoices : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProblemCreation.addChoices",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "choix"})
      }
   """
)
                        

// @LINE:20
def creation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ProblemCreation.creation",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "new"})
      }
   """
)
                        

}
              

// @LINE:16
// @LINE:15
class ReverseProblem {


// @LINE:16
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problem.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "problem"})
      }
   """
)
                        

// @LINE:15
def problem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Problem.problem",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "problem"})
      }
   """
)
                        

}
              

// @LINE:7
// @LINE:6
class ReverseIndex {


// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Index.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def submit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Index.submit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
class ReverseAssets {


// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:27
// @LINE:26
// @LINE:24
class ReverseAdmin {


// @LINE:27
def resolve(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.resolve(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "resolve", Seq(), "POST", """""", _prefix + """resolve""")
)
                      

// @LINE:26
def deleteProblem(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.deleteProblem(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "deleteProblem", Seq(), "POST", """""", _prefix + """delete""")
)
                      

// @LINE:24
def admin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.admin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Admin", "admin", Seq(), "GET", """""", _prefix + """admin""")
)
                      

}
                          

// @LINE:21
// @LINE:17
class ReverseInscription {


// @LINE:17
def inscription(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Inscription.inscription(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Inscription", "inscription", Seq(), "GET", """""", _prefix + """inscription""")
)
                      

// @LINE:21
def subscribe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Inscription.subscribe(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Inscription", "subscribe", Seq(), "POST", """""", _prefix + """inscription""")
)
                      

}
                          

// @LINE:14
// @LINE:13
// @LINE:12
class ReverseAuth {


// @LINE:14
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:12
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.authenticate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:13
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Auth.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Auth", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      

}
                          

// @LINE:25
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
class ReverseProblemCreation {


// @LINE:19
def choix(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProblemCreation.choix(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "choix", Seq(), "GET", """""", _prefix + """choix""")
)
                      

// @LINE:25
def submitChoices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProblemCreation.submitChoices(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "submitChoices", Seq(), "POST", """""", _prefix + """create""")
)
                      

// @LINE:22
def createProblem(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProblemCreation.createProblem(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "createProblem", Seq(), "POST", """""", _prefix + """new""")
)
                      

// @LINE:23
def addChoices(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProblemCreation.addChoices(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "addChoices", Seq(), "POST", """""", _prefix + """choix""")
)
                      

// @LINE:20
def creation(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ProblemCreation.creation(), HandlerDef(this.getClass.getClassLoader, "", "controllers.ProblemCreation", "creation", Seq(), "GET", """""", _prefix + """new""")
)
                      

}
                          

// @LINE:16
// @LINE:15
class ReverseProblem {


// @LINE:16
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problem.update(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problem", "update", Seq(), "POST", """""", _prefix + """problem""")
)
                      

// @LINE:15
def problem(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Problem.problem(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Problem", "problem", Seq(), "GET", """""", _prefix + """problem""")
)
                      

}
                          

// @LINE:7
// @LINE:6
class ReverseIndex {


// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Index.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Index", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def submit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Index.submit(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Index", "submit", Seq(), "POST", """""", _prefix + """""")
)
                      

}
                          
}
        
    