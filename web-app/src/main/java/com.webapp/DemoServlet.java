package com.webapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

//@WebServlet("/welcome")
public class DemoServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {

        int index = 0;
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();


        Cookie cke[]=req.getCookies();

        for(int i = 0; i < cke.length; i++)
        {
            if(cke[i].getName().equals("userName"))
            {
                index = i;
                break;
            }
//            else
//            {
//                pw.println("<br> Name is "+cke[i].getName()+"value is : "+cke[i].getValue());
//            }
        }

        if(cke[index].getName().equals("userName"))
        {
                 String name = cke[index].getValue();

                ServletConfig config=getServletConfig();
                String driver=config.getInitParameter("driver");

                //creating ServletContext object
                ServletContext context=getServletContext();

                //Getting the value of the initialization parameter and printing it
                String driverName=context.getInitParameter("dname");
                context.setAttribute("company","KRITTER");



                //writing html in the stream
                pw.println("<html><head><body><p ><center style='font-size:30px;'>");
                pw.print("<a href='welcome-name'>HOME</a> | <a href='logout'>Logout</a> <br> <hr>  ");
                pw.println("<br>Welcome to servlet<br>");

                pw.print("Hello "+name);

                pw.println("<br>Servlet Driver is: "+driver);
                pw.println("<br>Application Driver name is="+driverName);

                String n=(String)context.getAttribute("company");
                pw.println("<br>Application Company Name is="+n);
                pw.println("</center></p></body></html>");

            }
            else
            {
                pw.print("Session Expired,Please LOGIN");
                req.getRequestDispatcher("/index.html").include(req, res);
            }



            pw.close();
        }




    }
