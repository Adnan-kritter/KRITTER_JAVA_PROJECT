package com.library.app;


import java.util.Scanner;
import java.io.*;


class Staff
{
    static int id;
    String name;
    String role;
    char gender;
    long mobile;
    static double salary;


    static
    {
        id = 1001;
        salary = 20000.0;
        System.out.println("Library Staff Details");
    }



    static void assignId()
    {
        System.out.print(id);
        id++;
    }

    void read() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the Staff Name:");
        name = br.readLine();

        System.out.println("Enter the Staff Role:");
        role = br.readLine();


        System.out.println("Enter the Staff Gender:");
        gender =  (char)br.read();



        System.out.println("Enter the Staff Phone Number:");
        br.readLine();
        mobile = Long.parseLong(br.readLine());


    }


    void display()
    {
        assignId();
        System.out.print("\t"+name+"\t"+role+"\t"+gender+"\t"+mobile+"\t\t"+salary+"\n");

    }

}


class Library_Static
{
    public static void main(String args[]) throws IOException
    {

        short n=0,i;
        byte ch;
        boolean loop = true;

        Scanner sc= new Scanner(System.in);

        Staff []s = new Staff[100];

        while(loop)
        {
            System.out.println("\n 1. Enter Library Staff Details");
            System.out.println(" 2. Display Library Staff Details");

            System.out.println(" 3. Exit ");


            System.out.println(" Enter your choice :");
            ch = Byte.parseByte(sc.next());

            switch(ch)
            {
                case 1 :
                    System.out.println("Enter the Number of Staff Details to be Entered [1-100]");
                    n = Short.parseShort(sc.next());

                    while(n < 1 || n > 100)
                    {
                        System.out.println("Enter the Number of Staff Details to be Entered [1-100]");
                        n = Short.parseShort(sc.next());
                    }
                    for(i = 0 ;i < n ;i++)
                    {
                        s[i] = new Staff();
                        System.out.println("\nEnter the Staff"+(i+1)+" Details");
                        System.out.println("----------------------------------------");
                        s[i].read();
                    }
                    break;

                case 2:
                    System.out.println("Staff ID Staff Name \t Staff Role \t Gender\t Mobile\t\tSalary");
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    for(i = 0 ;i<n;i++)
                    {

                        s[i].display();
                    }

                    break;

                case 3 :
                    loop = false;
                    break;

                default : System.out.println("Invalid Option");
            }
        }
    }
}