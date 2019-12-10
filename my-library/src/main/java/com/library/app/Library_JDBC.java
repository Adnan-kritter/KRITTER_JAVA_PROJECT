package com.library.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class Library_JDBC{
    static int count=1;
    static int  choice;
    public static void main(String[] args) throws IOException {

        Library_Singleton jdbc= Library_Singleton.getInstance();


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("STUDENT DATABASE OPERATIONS");
            System.out.println(" --------------------- ");
            System.out.println(" 1. Insert Student Details ");
            System.out.println(" 2. View Student Details      ");
            System.out.println(" 3. Delete a Student Details  ");
            System.out.println(" 4. Update a Student Details  ");
            System.out.println(" 5. View all the Student Details  ");
            System.out.println(" 5. Exit      ");

            System.out.print("\n");
            System.out.print("Please enter the choice what you want to perform in the database: ");

            choice=Integer.parseInt(br.readLine());
            switch(choice) {

                case 1:{
                    System.out.print("Enter the Student Name you want to insert data into the database: ");
                    String name=br.readLine();
                    System.out.print("Enter the Branch you want to insert data into the database: ");
                    String branch=br.readLine();
                    System.out.print("Enter the Address you want to insert data into the database: ");
                    String address=br.readLine();

                    try {
                        int i= jdbc.insert(name, branch, address);
                        if (i>0) {
                            System.out.println(" Data has been inserted successfully");
                        }else{
                            System.out.println("Data has not been inserted ");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.println("Press Enter key to continue...");
                    System.in.read();

                }//End of case 1
                break;
                case 2:{
                    System.out.print("Enter the Student Name : ");
                    String name=br.readLine();

                    try  {
                        jdbc.view(name);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();

                }//End of case 2
                break;
                case 3:{
                    System.out.print("Enter the Student ID,  you want to delete: ");
                    int id=Integer.parseInt(br.readLine());

                    try {
                        int i= jdbc.delete(id);
                        if (i>0) {
                            System.out.println(" Data has been deleted successfully");
                        }else{
                            System.out.println("Data has not been deleted");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();

                }//End of case 3
                break;
                case 4:{
                    System.out.print("Enter the Student Name,  you want to update: ");
                    String name=br.readLine();
                    System.out.print("Enter the Student Branch ");
                    String branch=br.readLine();

                    try {
                        int i= jdbc.update(name, branch);
                        if (i>0) {
                            System.out.println( " Data has been updated successfully");
                        }else{
                            System.out.println("Data has not been updated");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();

                }// end of case 4
                break;
                case 5 :{
                    try  {
                        jdbc.view_all();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                default: System.out.println("Enter a Valid Choice");

            }

        } while (choice!=6);
    }
}


