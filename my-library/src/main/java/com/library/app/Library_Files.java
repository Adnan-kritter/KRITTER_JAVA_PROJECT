package com.library.app;


import java.io.*;
import java.util.Scanner;

class Stude
{
    Scanner sc = new Scanner(System.in);
    String name;
    String course;
    String gender;

    void stRead()
    {
        System.out.println("\nEnter the Student Details");
        System.out.println("**************************\n");
        System.out.println("Enter the Student Name :");
        name = sc.nextLine();

        System.out.println("Enter the Student Course :");
        course = sc.nextLine();

        System.out.println("Enter the Student Gender :");
        gender = sc.nextLine();


        try
        {
            FileWriter fw = new FileWriter("Student.txt");
            BufferedWriter br = new BufferedWriter(fw);

            br.write(name);
            br.newLine()	;
            br.write(course);
            br.newLine();
            br.write(gender);
            br.newLine();

            br.close();
            fw.close();
        }


        catch (IOException e)
        {
            System.out.println(e);
        }

    }

    void stDisplay()
    {
        try
        {
            String line;
            FileReader fr = new FileReader("Student.txt");
            BufferedReader br = new BufferedReader(fr);

            System.out.println("\nStudent Details \n****************************** ");
            System.out.println("Student Name : "+br.readLine());
            System.out.println("Student Course : "+br.readLine());
            System.out.println("Student Gender : "+br.readLine());

            br.close();
            fr.close();
        }

        catch (IOException e) {
            System.out.println(e);
        }


    }
}



class Address
{
    String addr;



    void read() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("addr.txt");

        System.out.println("Enter the Student Address :");
        addr = br.readLine();


        try
        {
            fw.write(addr);

            fw.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }



    void display() throws IOException
    {
        FileReader fr= new FileReader("addr.txt");

        int ch;

        System.out.print("Student Address :");
        while ((ch = fr.read()) != -1)
        {
            System.out.print((char) ch);
        }

        fr.close();
    }


}


class Mobile
{
    String mobile;

    void read_mob() throws IOException
    {
        OutputStream output = new FileOutputStream("mobile.txt");
        OutputStreamWriter  out = new OutputStreamWriter(output);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Student Mobile Number :");
        mobile = br.readLine();

        out.write(mobile);

        out.close();
    }


    void disp_mob() throws IOException
    {
        InputStream input       = new FileInputStream("mobile.txt");
        Reader      in = new InputStreamReader(input);

        System.out.print("\nStudent Mobile Number :");
        int data = in.read();

        while(data != -1)
        {
            System.out.print((char) data);
            data = in.read();
        }

        in.close();
    }
}


class Library_Files
{
    public static void main(String args[])
    {
        Stude s = new Stude();

        Address st = new Address();

        Mobile m = new Mobile();
        try
        {
            s.stRead();

            st.read();

            m.read_mob();

            s.stDisplay();

            st.display();

            m.disp_mob();
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }
}

