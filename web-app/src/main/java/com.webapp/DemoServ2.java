package com.webapp;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServ2 extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        int index = 0;
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();

        String name = req.getParameter("userName");


        Cookie cke[]=req.getCookies();

        for(int i = 0; i < cke.length; i++)
        {
            if(cke[i].getName()=="userName")
            {
                index = i;
                break;
            }
        }

        if(!cke[index].getName().equals("userName"))
        {

            pw.print("<a href='welcome' style='font-size:30px;'>DETAILS</a> | <a href='logout' style='font-size:30px;'>LOGOUT</a> <br> <hr>  ");
            pw.println("<center><h1> welcome "+name+ "</h1></center>");

        }
        else
        {
            pw.print("Please login first");
            req.getRequestDispatcher("/index.html").include(req, res);
        }



        pw.close();
    }




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

            pw.print("<a href='welcome' style='font-size:30px;'>DETAILS</a> | <a href='logout' style='font-size:30px;'>LOGOUT</a> <br> <hr>  ");
            pw.println("<center><h1> Welcome "+name+"</h1></center>");

        }
        else
        {
            pw.print("Session Expired,Please LOGIN");
            req.getRequestDispatcher("/index.html").include(req, res);
        }



        pw.close();
    }

    }