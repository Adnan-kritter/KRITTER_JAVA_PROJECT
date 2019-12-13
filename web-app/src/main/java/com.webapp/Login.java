package com.webapp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name;
        int index = 0;

        Cookie cke[]=request.getCookies();

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
            String user = request.getParameter("userName");
            String password = request.getParameter("userPass");

            if(user.equals("Admin")&&password.equals("servlet")){

                Cookie ck=new Cookie("userName",user);
                response.addCookie(ck);


                request.getRequestDispatcher("welcome-name").forward(request, response);

//                Cookie c[]=request.getCookies();
//                if(c != null)
//                    out.println(c[0].getName());
//
//                else
//                    name = "";
            }
            else{
                out.print("sorry, username or password error!");
                request.getRequestDispatcher("index.html").include(request, response);
            }

        }
        else {
            Cookie ck=new Cookie("userName","");
            ck.setMaxAge(0);
            response.addCookie(ck);
            out.print("Error Occured while log-in, Try Again to Login");
            request.getRequestDispatcher("index.html").include(request, response);
        }










out.close();
    }

}