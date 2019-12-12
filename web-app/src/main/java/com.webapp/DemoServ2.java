package com.webapp;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServ2 extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();

        String name=req.getParameter("userName");//will return value
        pw.println("Welcome "+name);

        pw.close();
    }}