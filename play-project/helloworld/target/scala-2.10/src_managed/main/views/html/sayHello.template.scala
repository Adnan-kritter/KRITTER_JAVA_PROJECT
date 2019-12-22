
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object sayHello extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""

    """),_display_(Seq[Any](/*5.6*/play20/*5.12*/.welcome(message, style = "Java"))),format.raw/*5.45*/("""



""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Dec 17 17:31:35 IST 2019
                    SOURCE: /home/sciera/maven-study/play-project/helloworld/app/views/sayHello.scala.html
                    HASH: 6b02ca261b48e09feed9ab4298ba478959bee48b
                    MATRIX: 777->1|888->18|925->21|956->44|995->46|1036->53|1050->59|1104->92|1139->97
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|37->9
                    -- GENERATED --
                */
            