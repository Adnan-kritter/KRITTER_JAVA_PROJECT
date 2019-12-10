package com.library.app;


import java.util.Scanner;


class Student
{
    Scanner sc = new Scanner(System.in);
    int regno;
    String name;
    String course;
    byte semester;
    char gender;
    long mobileNo;

    Student(String stu)
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

        System.out.println("Enter the Student Gender :");
        gender = sc.next().charAt(0);

        System.out.println("Enter the Student Mobile Number :");
        mobileNo = sc.nextLong();


    }

    void display(Attendance at)
    {
        System.out.println("\nRegister No.\t Name\t Course\t Semester\t Gender\t Mobile Number\t IN-TIME\t OUT-TIME");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println(regno+"\t\t"+name+"\t"+course+"\t"+semester+"\t\t"+gender+"\t"+mobileNo+"\t"+at.inTime+"\t\t"+at.outTime);

    }


}


class Attendance extends Student
{

    String inTime;
    String outTime;
    int regNo;
    String name;


    Attendance()
    {
        super("Student");
        System.out.println("\nEnter the Attendance Details");
        System.out.println("**************************\n");

        System.out.println("Enter the IN-TIME :");
        sc.nextLine();
        inTime = sc.nextLine();


        System.out.println("Enter the OUT-TIME :");

        outTime = sc.nextLine();

        this.name = super.name;
        this.regNo = super.regno;

    }

    void display()
    {
        display(this);
    }

}

class Locker extends Attendance
{
    static short lo = 101;
    short lockerNo;
    String status;
    String userName;
    int userId;

    Locker()
    {

        this(5);
        this.lockerNo = lo;
        lo++;
        this.userName = name;
        this.userId = regno;
    }

    Locker(int val)
    {
        System.out.println("\nEnter the Locker Details");
        System.out.println("**************************\n");

        System.out.println("Enter the Locker Status :");
        status = sc.nextLine();
    }

    void disp()
    {
        System.out.println("Locker No.\t Locker Status\t User\t User ID");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(lockerNo+"\t\t"+status+"\t"+userName+"\t"+userId);

        System.out.println("\nDo you want to know the Information of Locker User [Y|N] : ");
        char ch = sc.next().charAt(0);
        if(ch == 'Y')
        {
            super.display();
        }

    }

    void display()
    {
        System.out.println("This is Derived class and Overriding Method");
    }

}

class Library_Inheritance
{
    public static void main(String args[])
    {
        boolean loop = true;
        Locker []at = new Locker[50];
        byte ch,i,n = 0;
        Scanner sc = new Scanner(System.in);

        while(loop)
        {
            System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("**************************");
            System.out.println("\n 1. Provide New Locker");
            System.out.println(" 2. Display All the Lockers Provided");
            System.out.println(" 3. Exit ");


            System.out.println(" Enter your choice :");
            ch = Byte.parseByte(sc.next());

            switch(ch)
            {
                case 1 :
                    at[n] = new Locker();
                    n++;
                    break;

                case 2:
                    System.out.println("\n Locker Details \n *******************************\n");
                    for(i = 0 ;i<n;i++)
                    {

                        at[i].disp();
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


