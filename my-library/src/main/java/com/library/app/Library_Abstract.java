package com.library.app;


import java.util.Scanner;
import java.io.*;

abstract class Transaction
{
    Scanner sc = new Scanner(System.in);
    static int id = 1000;
    int txnid;
    String natureOfTxn;
    String transactionPerson;

    abstract void buy();





}

class Issue extends Transaction
{
    String issueDate;
    String renewExpiry;
    String issuerName;


    void buy()
    {
        char ch;



        System.out.println("Do you like to BUY Book [Y|N] :");
        ch = sc.next().charAt(0);

        if(ch == 'Y')
        {
            assignId();

            txnid = id;

            sc.nextLine();
            System.out.println("Enter the Nature of Transaction :");
            natureOfTxn = sc.nextLine();

            transactionPerson = issuerName;

        }
    }

    static void assignId()
    {

        id++;
    }

    void details()
    {
        System.out.println("\nEnter the Issue Details");
        System.out.println("**************************\n");

        sc.nextLine();
        System.out.println("Enter the Book Issue Date :");
        issueDate = sc.nextLine();

        System.out.println("Enter the Book Expiry Date : ");
        renewExpiry = sc.nextLine();

        System.out.println("Enter the Issuer Name :");
        issuerName = sc.nextLine();

        buy();
    }



}

class Books extends Issue
{
    public int bookId;
    public long isbnNo;
    public	String bookName;
    public String author;
    public	float mrp;

    public void read()
    {
        System.out.println("\nEnter the Book Details");
        System.out.println("**************************\n");


        System.out.println("Enter the Book Id:-");
        bookId = sc.nextInt();

        System.out.println("Enter the Book Name:-");
        sc.nextLine();
        bookName = sc.nextLine();

        System.out.println("Enter the Author for the book:-");
        author = sc.nextLine();

        System.out.println("Enter the ISBN Number:-");
        isbnNo = sc.nextLong();

        System.out.println("Enter the Price for the book:-");
        mrp = Float.parseFloat(sc.next());


    }
}

class Studen extends Books
{

    int regno;
    String name;
    String course;
    byte semester;


    Studen()
    {
        System.out.println("\nEnter the Student Details");
        System.out.println("**************************\n");
        System.out.println("Enter the Student Register Number :");
        regno = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter the Student Name :");
        name = sc.nextLine();

        System.out.println("Enter the Student Course :");
        course = sc.nextLine();

        System.out.println("Enter the Student Semester :");
        semester = sc.nextByte();

        read();
        details();

    }
}



class Library_Abstract
{
    public static void main(String args[])
    {
        boolean loop = true;
        Studen []st = new Studen[50];
        byte ch,i,n = 0;
        char c;
        Scanner sc = new Scanner(System.in);

        while(loop)
        {
            System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("**************************");
            System.out.println("\n 1. Issue a Book");
            System.out.println(" 2. Issued Details");
            System.out.println(" 3. Exit ");


            System.out.println("Enter your choice :");
            ch = Byte.parseByte(sc.next());

            switch(ch)
            {
                case 1 :
                    st[n] = new Studen();

                    n++;
                    break;

                case 2:
                    System.out.println("\nIssued Details \n *******************************");

                    for(i = 0 ;i<n;i++)
                    {

                        if(st[i].txnid > 0)
                        {
                            System.out.println("\nSL No.\t Book ID Book Name\t Issued Date\t Issued Expiry\t Issuer Name\t Transaction ID\t Transaction Nature");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------");
                            System.out.print((i+1)+"\t"+st[i].bookId+"\t"+st[i].bookName+"\t\t"+st[i].issueDate+"\t"+st[i].renewExpiry+"\t"+st[i].issuerName+"\t\t"+st[i].txnid+"\t"+st[i].natureOfTxn+"\n");
                        }
                        else
                        {

                            System.out.println("\nSL No.\t Book ID\t Book Name\t\t Issued Date\t Issued Expiry\t Issuer Name\t Transaction");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------");
                            System.out.print((i+1)+"\t"+st[i].bookId+"\t"+st[i].bookName+"\t\t"+st[i].issueDate+"\t"+st[i].renewExpiry+"\t"+st[i].issuerName);
                            System.out.print("\tNo\n");
                        }

                        System.out.print("Do you like to get more Details [Y|N]:");
                        c = sc.next().charAt(0);

                        if(c == 'Y')
                        {
                            System.out.println("\nBook ID\t Book Name\t Book Author\t Price\t Register No.\t Student Name\t Course\t Semester\t");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------");
                            System.out.print(st[i].bookId+"\t"+st[i].bookName+"\t\t"+st[i].author+"\t"+st[i].mrp+"\t"+st[i].regno+"\t"+st[i].name+"\t"+st[i].course+"\t"+st[i].semester);

                        }



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

