package com.serviceLayer;

import com.daoLayer.userDAO;
import com.entity.user;

public class userServiceLayer {
	
	
	// add user or sign up service layer
	public static boolean addUser(user user) {

		
		boolean addUser = userDAO.addUser(user);
		return addUser;
	}

	
	public static user login(String email, String password) {
		user login = userDAO.login(email, password);
		return login;
	}
}
