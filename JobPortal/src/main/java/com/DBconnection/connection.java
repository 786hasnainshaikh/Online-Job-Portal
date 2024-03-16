package com.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	
	public static Connection con;
	public static Connection getConnection() {
		try {
			// load the drivers 
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/onlineJobPortal","root", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
