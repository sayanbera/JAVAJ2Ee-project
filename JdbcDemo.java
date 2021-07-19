package org.btm.jdbcApp;
import java.sql.*;
public class JdbcDemo {
public static void main(String[] args)
{
	Connection con=null;
	Statement Statement=null;
	String qry1="insert into btm.student values(1,'sai',69.36)";
	String qry2="insert into btm.student values(2,'ram',85.63)";
	String qry3="insert into btm.student values(3,'sayan',99.56)";
	try 
	{
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver class loaded & Registered");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
	System.out.println("Connection Established with the Database server");
	Statement=con.createStatement();
	System.out.println("Platform Created");
	Statement.executeUpdate(qry1);
	Statement.executeUpdate(qry2);
	Statement.executeUpdate(qry3);
	System.out.println("Data Inserted!!!!!");
	} 
	catch (ClassNotFoundException|SQLException exception) 
	{
		
	exception.printStackTrace();
	}
	finally {
		if(Statement!=null)
		{
			try {
				Statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Close all costly Resources");
		}
	}
}
}
