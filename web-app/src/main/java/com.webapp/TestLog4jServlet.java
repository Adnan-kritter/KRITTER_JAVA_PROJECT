package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebServlet("/test")
public class TestLog4jServlet extends HttpServlet {

    static final Logger LOGGER = Logger.getLogger(TestLog4jServlet.class);

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info("This is a logging statement from log4j");

        PrintWriter out = response.getWriter();
        String log4jConfigFile = "/home/sciera/maven-study/web-app/src/main/webapp/WEB-INF/log4j.properties";

        PropertyConfigurator.configure(log4jConfigFile);

        String html = "<html><h2>Log4j has been initialized successfully!</h2></html>";
        out.println(html);
    }

}