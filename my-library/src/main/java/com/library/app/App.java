package com.library.app;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    String address;

    static String col = "CHRIST";

    enum Deaneries {SCIENCE,MANAGEMENT,COMMERCE,ARTS,SOCIAL}

    static //this is static block
    {
        System.out.println( "Welcome to CHRIST KNOWLEDGE PRO\n" );
    }


    static void change()
    {
        col = "CHRIST DEEMED TO BE UNIVERSITY";

    }


    App(String addr)
    {
        address = addr;
    }

    void display()
    {
        int c = 1;
        System.out.println(col);
        System.out.println(address);
        System.out.println("\nWE HAVE THE FOLLOWING DEANERIES");
        for(Deaneries d : Deaneries.values())
            System.out.println((c++)+". "+d);

        sets();
        linkedList();
    }

    void sets()
    {
        int c = 1;

        Set<String> branches = new HashSet<String>();
        branches.add("HOSUR ROAD CAMPUS");
        branches.add("BANNERGHATTA ROAD CAMPUS");
        branches.add("KENGERI CAMPUS");

        System.out.println("\nDISPLAYING "+branches.size()+" BRANCHES :");
        for(String b : branches)
            System.out.println(c+++". "+b);
    }

    void linkedList()
    {
        int c = 1;

        LinkedList<String> courses = new LinkedList<String>();

        courses.add("MCA");
        courses.add("MCs");
        courses.add("M.Com");
        courses.add("MPCO");
        courses.add("MSW");
        courses.add("BCA");
        courses.add("B.Com");
        courses.add("BBA");
        courses.add("BSc");
        courses.add("BA");
        courses.add("BHM");

        System.out.println("\nDISPLAYING COURSES :");
        for(String co  : courses)
            System.out.println(c+++". "+co);


    }


    public static void main(String[] args)
    {
        App.change();

        App s = new App("HOSUR ROAD, NEAR DIARY CIRCLE, BANGALORE - 29");

        s.display();


    }


}
