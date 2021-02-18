package com.valuemomentum.training.jdbcdemo;

import java.sql.*;
public class MysqlCon {
	
	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try
		{
			//register JDBC DRIVER
			Class.forName("com.mysql.jdbc.Driver");
			
			//Open a connection
			System.out.println("Connecting to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Isha@123");
			
			
			//create a statement object using connection object
			stmt=con.createStatement();
			
			//execute a query
			rs=stmt.executeQuery("select * from employees");
					
					//Extra data from result set
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " +rs.getString(3)+
								 " " +rs.getString(4) + " " +rs.getString("email") + " " +rs.getString(6) + " " +rs.getString(7) + " " +rs.getString(8));
					}
			rs.close();
			stmt.close();
			con.close();
		}
	
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}

}
