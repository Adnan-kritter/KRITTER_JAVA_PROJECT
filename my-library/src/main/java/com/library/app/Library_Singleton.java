package com.library.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Library_Singleton {
    //Step 1
    // create a JDBCSingleton class.
    //static member holds only one instance of the JDBCSingleton class.

    private static Library_Singleton jdbc;

    //JDBCSingleton prevents the instantiation from any other class.
    private Library_Singleton() {  }

    //Now we are providing gloabal point of access.
    public static Library_Singleton getInstance() {
        if (jdbc==null)
        {
            jdbc=new  Library_Singleton();
        }
        return jdbc;
    }

    // to get the connection from methods like insert, view etc.
    private static Connection getConnection()throws ClassNotFoundException, SQLException
    {

        Connection con=null;
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kritter_test","adnan","Kritter12!");
        return con;

    }

    //to insert the record into the database
    public int insert(String name, String branch, String address) throws SQLException
    {
        Connection c=null;

        PreparedStatement ps=null;

        int recordCounter=0;

        try {

            c=this.getConnection();
            ps=c.prepareStatement("insert into student(name,branch,address)values(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, branch);
            ps.setString(3, address);
            recordCounter=ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); } finally{
            if (ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;
    }

    //to view the data from the database
    public  void view(String name) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con=this.getConnection();
            ps=con.prepareStatement("select * from student where name=?");
            ps.setString(1, name);
            rs=ps.executeQuery();
            while (rs.next()) {
                System.out.println("STUDENT ID="+rs.getString(1)+"\t"+"Name= "+rs.getString(2)+"\t"+"Branch= "+rs.getString(3)+"\t"+"Address= "+rs.getString(4));

            }

        } catch (Exception e) { System.out.println(e);}
        finally{
            if(rs!=null){
                rs.close();
            }if (ps!=null){
                ps.close();
            }if(con!=null){
                con.close();
            }
        }
    }


    public  void view_all() throws SQLException
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            con=this.getConnection();
            st=con.createStatement();
            rs = st.executeQuery("select * from student");
            System.out.println("STUDENT ID \t NAME \t BRANCH \t ADDRESS\n-------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }

        } catch (Exception e) { System.out.println(e);}
        finally{
            if(rs!=null){
                rs.close();
            }if (st!=null){
                st.close();
            }if(con!=null){
                con.close();
            }
        }
    }
    // to update the password for the given username
    public int update(String name, String branch) throws SQLException  {
        Connection c=null;
        PreparedStatement ps=null;

        int recordCounter=0;
        try {
            c=this.getConnection();
            ps=c.prepareStatement(" update student set branch=? where name='"+name+"' ");
            ps.setString(1, branch);
            recordCounter=ps.executeUpdate();
        } catch (Exception e) {  e.printStackTrace(); } finally{

            if (ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;
    }

    // to delete the data from the database
    public int delete(int userid) throws SQLException{
        Connection c=null;
        PreparedStatement ps=null;
        int recordCounter=0;
        try {
            c=this.getConnection();
            ps=c.prepareStatement(" delete from student where student_id='"+userid+"' ");
            recordCounter=ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        finally{
            if (ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;
    }
}
