import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class Pets
{
    public static void main( String[] args )
            throws Exception
    {
        /*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        /*  organize our data  */
        ArrayList list = new ArrayList();
        Map map = new HashMap();
        map.put("name", "horse");
        map.put("price", "00.00");
        list.add( map );

        map = new HashMap();
        map.put("name", "dog");
        map.put("price", "9.99");
        list.add( map );
        map = new HashMap();
        map.put("name", "bear");
        map.put("price", ".99");
        list.add( map );
        /*  add that list to a VelocityContext  */
        VelocityContext context = new VelocityContext();
        context.put("petList", list);
        /*  get the Template  */
//        Template t = ve.getTemplate( "./src/main/resources/petstore.html" );
        /*  now render the template into a Writer  */
//        StringWriter writer = new StringWriter();
//        t.merge( context, writer );
        /* use the output in your email body */

//        System.out.println( writer.toString() );

        Writer write = new FileWriter(new File("./src/main/resources/hello-velocity.html"));
        Velocity.mergeTemplate("./src/main/resources/petstore.html", "UTF-8", context, write);
        write.flush();
        write.close();




    }
}