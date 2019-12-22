
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""

<!--    """),_display_(Seq[Any](/*5.10*/play20/*5.16*/.welcome(message, style = "Java"))),format.raw/*5.49*/("""-->
<br>

<form action="/hello" method="GET" >
    <input type="text" name="myName" required placeholder="Enter Your Name" style="font-size:30px;" />
    <input type="submit" value="Say hello!" style="font-size:30px;" />
</form>

""")))})),format.raw/*13.2*/("""
    """))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:52:40 IST 2019
                    SOURCE: /home/sciera/maven-study/play-project/helloworld/app/views/index.scala.html
                    HASH: ddf5f81ec69de97e0e1d2ede428e07264925f065
                    MATRIX: 774->1|885->18|922->21|953->44|992->46|1038->57|1052->63|1106->96|1368->327
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|41->13
                    -- GENERATED --
                */
            