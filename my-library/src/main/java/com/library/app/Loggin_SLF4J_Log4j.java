package com.library.app;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;
import org.slf4j.profiler.TimeInstrument;

import java.io.FileWriter;
import java.io.IOException;

public class Loggin_SLF4J_Log4j {

    public static void  main(String args[]) throws IOException {
        BasicConfigurator.configure();
        Logger l = LoggerFactory.getLogger(Loggin_SLF4J_Log4j.class);

        l.info("Logging without parameters");

        int value = 100;
        l.info("Logging with Parameters by displaying value {}",value);

        Loggin_SLF4J_Log4j lo = new Loggin_SLF4J_Log4j();
        lo.profiler();

    }

    void profiler() throws IOException {
        Profiler p = new Profiler("PROFILER");

        p.start("Task 1");
        task1();

        p.start("Task 2");
        task2();

        TimeInstrument tm = p.stop();

        //System.out.println(tm.toString());
        //tm.print();

        FileWriter f = new FileWriter("logging.txt");

        f.write(tm.toString());
        f.close();


    }

    void task1()
    {
        System.out.println("Performing Task 1");
    }

    void task2()
    {
        System.out.println("Performing Task 2");
    }


}
