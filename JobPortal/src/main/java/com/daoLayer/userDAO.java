package com.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DBconnection.connection;
import com.entity.user;

public class userDAO {
	
 static Connection con=connection.getConnection();
 
 
 // add user or sign up 
 public static boolean addUser(user user) {
	 boolean flage=false;
	 try {
		String query="insert into user (Name, Email,Qualification,JobRole,password) values (?, ?,? ,?,?)";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getQualification());
		ps.setString(4, "user");
		ps.setString(5, user.getPassword());
		
		
		int executeUpdate = ps.executeUpdate();
		if (executeUpdate == 1) {
			flage=true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	 return flage;
 }

 
 public static user login(String email, String password) {
	 user user=null;
	 try {
		String query="SELECT * FROM user where Email = ? and password= ?";
		PreparedStatement ps =con.prepareStatement(query);
		
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			// create new user object
			user=new user();
			
			//set values in user object which get from database
			user.setUseId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setQualification(rs.getString(4));
			user.setRole(rs.getString(5));
			user.setPassword(rs.getString(6));
			
			// return object
			return user;
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	 
	 return null;
 }
}
