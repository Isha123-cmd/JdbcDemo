package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// JDBC program to display candidates details and their skills

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC Program that displays candidate details and theirs skills
public class JoinsDemo {

 public static void main(String[] args) {
Connection con;
Statement stmt;
ResultSet rs;
try
{
//register JDBC driver
Class.forName("com.mysql.cj.jdbc.Driver");
//open a connection
System.out.println("connecting to database..");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Isha@123");
// create a statement obj using Connection obj
stmt=con.createStatement();
//execute a query
rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN candidate_skills s ON c.id=candidate_id INNER JOIN skills sk ON s.skill_id=sk.id");
//Extract data from result set
while(rs.next()) // next() is method in rs
{
System.out.println(rs.getInt(1)+" "+rs.getString(2)
+" "+rs.getString(3));
}
rs.close();
stmt.close();
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}

}