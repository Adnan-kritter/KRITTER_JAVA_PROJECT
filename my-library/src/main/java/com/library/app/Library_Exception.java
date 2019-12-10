package com.library.app;


import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
// import java.lang.*;

class Book
{
    public int bookId;
    public long isbnNo;
    public	String bookName;
    public String author;
    public	float mrp;
    public boolean issueStatus;
    public	String bookDescription;
    public Byte bookGenre;

    public void read() throws IOException
    {
        try
        {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the Book Id:-");
            bookId = Integer.parseInt(sc.next());

            System.out.print("Enter the Book Name:-");
            sc.nextLine();
            bookName = sc.nextLine();

            System.out.print("Enter the Author for the book:-");
            author = sc.nextLine();

            System.out.print("Enter the ISBN Number:-");
            isbnNo = sc.nextLong();

            System.out.print("Enter the Price for the book:-");
            mrp = Float.parseFloat(sc.next());

            System.out.print("Enter the Issue Status for the book :-");
            issueStatus = Boolean.parseBoolean(sc.next());

            System.out.println("Enter the Book Genre:-");
            System.out.println(" 1. Science \n 2. History \n 3. Math \n 4. Computers \n 5. Religious \n 6. Journals \n 7. Encyclopedia \n 8. Biographies \n 9. Other");
            bookGenre = sc.nextByte();



            System.out.print("Enter the Book Description:-");
            sc.nextLine();
            bookDescription = sc.nextLine();
        }

        catch(NumberFormatException e)
        {
            System.out.println("Number Format Exception Occured");
        }

    }
}

class Transact
{
    Scanner sc = new Scanner(System.in);
    int txno;
    int txnid;
    String natureOfTxn = null;
    int amount;

    Transact()
    {
        try
        {
            System.out.println("Enter the total amount spend on library");
            amount = sc.nextInt();

            System.out.println("Enter the Number of Transactions");
            txno = sc.nextInt();

            amount = amount / txno;

            System.out.println("Average Amount Spent on library : "+amount);


        }

        catch(ArithmeticException e)
        {
            System.out.println(" \nArithmetic Exception Occured");
        }

        try
        {
            System.out.println("Transaction Details");

            System.out.println("Enter Transaction ID :");
            txnid = sc.nextInt();


            sc.nextLine();
            System.out.println("Enter the Nature of Transaction :");
            natureOfTxn = sc.nextLine();
        }


        catch (InputMismatchException e) {
            System.out.println("Input Mismatch Exception OCcured");

        }





    }

}

class Stud
{
    Scanner sc = new Scanner(System.in);
    int regno;
    String name;
    String course;
    byte semester;
    String gender = null;
    long mobileNo;

    Stud()
    {
        System.out.println("\nEnter the Student Details");
        System.out.println("**************************\n");
        System.out.println("Enter the Student Register Number :");
        regno = sc.nextInt();

        System.out.println("Enter the Student Name :");
        sc.nextLine();
        name = sc.nextLine();

        System.out.println("Enter the Student Course :");
        course = sc.nextLine();


        System.out.println("Enter the Student Semester :");
        semester = sc.nextByte();

        System.out.println("Enter the Student Mobile Number :");
        mobileNo = sc.nextLong();


    }

    void display()
    {
        try
        {
            System.out.println("\nRegister No.\t Name\t Course\t Semester\t Gender\t Mobile Number\t");
            System.out.println("------------------------------------------------------------------------------------------------------------");

            System.out.println(regno+"\t\t"+name+"\t"+course+"\t"+semester+"\t\t"+gender.charAt(0)+"\t"+mobileNo+"\t");

        }

        catch(NullPointerException e)
        {
            System.out.println("\n Null Pointer Exception Occured");
        }

    }
}


class Teacher
{

    Scanner sc = new Scanner(System.in);
    String name;
    String gender = null;
    Long mobileNo;
    int id;
    String deptName;


    void  details(String type)
    {
        System.out.println("\nEnter the "+type+" Details");
        System.out.println("**************************\n");

        System.out.println("Enter the "+type+" ID :");
        id = sc.nextInt();


        System.out.println("Enter the "+type+" Gender :");
        gender = sc.nextLine();


        System.out.println("Enter the "+type+" Name :");
        name = sc.nextLine();


        System.out.println("Enter the "+type+" Mobile Number :");
        mobileNo = sc.nextLong();


        System.out.println("Enter the "+type+" Department Name :");
        deptName = sc.next();

    }

    void dispTeach()
    {
        try
        {

            System.out.println("Staff ID\t Name\t Department\t Gender\t Mobile Number\t");
            System.out.println("------------------------------------------------------------------------------------------------------------");

            System.out.print(id+"\t\t"+name+"\t"+deptName+"\t"+gender.charAt(0)+"\t"+mobileNo+"\t");

        }

        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("\nString Index Out Of Bounds Exception Occured");
        }
    }
}


class CustomException extends Exception
{
    public CustomException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}

class Library_Exception
{
    public static void main(String args[])
    {
        Transact t = new Transact();

        Stud s = new Stud();

        s.display();

        try
        {
            Thread.sleep(1000);
        }

        catch (InterruptedException e)
        {
            System.out.println("Interrupted Exception Occured");
        }

        Teacher te = new Teacher();

        te.details("Teacher");



        te.dispTeach();

        Books []b = new Books[1];

        b[0] = new Books();

        b[0].read();


        try
        {
            b[1] = new Books();

        }


        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array IndexOut Of Bounds Exception Occured");
        }


        try
        {
            throw new CustomException("This is a Custom Exception");
        }

        catch (CustomException e)
        {
            System.out.println(e.getMessage());
        }

        finally
        {
            System.out.println("Finally Block Executed from Custom Exception and End of all Exceptions");
        }

    }
}

