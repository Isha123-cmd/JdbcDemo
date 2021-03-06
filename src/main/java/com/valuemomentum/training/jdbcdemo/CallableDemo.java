package com.valuemomentum.training.jdbcdemo;



 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;

 

public class CallableDemo {

 

    Connection con;
    java.sql.CallableStatement cstmt;
    ResultSet rs;
    
    CallableDemo() // empty constructor
    {
        
    }
void createConnection() // method
{
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // creating connection object
        System.out.println("Connection to database");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Isha@123");
        
    }
    catch(Exception e) {
        System.out.println(e);
        }
}
public void getSkills(int candidateId) { //method2
    try {
        String query = "{call get_candidate_skill(?)}";
        cstmt = con.prepareCall(query);
        cstmt.setInt(1, candidateId);
        
        rs = cstmt.executeQuery();
        while(rs.next())
        {
            System.out.println(String.format("%s - %s",rs.getString("first_name")+" "+rs.getString("last_name"),rs.getString("skill")));
            
        }
    }
    catch(Exception e) {
        System.out.println(e);
        }
}
    public static void main(String[] args) {
    CallableDemo cd1=new CallableDemo();
    cd1.createConnection();
    cd1.getSkills(133);
    }

 

}
