package com.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection Connect()
	{
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection Established");
			
			String url="jdbc:mysql://localhost:3306/sms?user=root&password=root";
			con=DriverManager.getConnection(url);
			System.out.println("Driver Loaded");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
