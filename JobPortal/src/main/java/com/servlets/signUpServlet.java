package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.user;
import com.serviceLayer.userServiceLayer;


@WebServlet("/signUp")
public class signUpServlet extends HttpServlet{  
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetching fields from signup.jsp
		String fullName= req.getParameter("fullName");
		String qualification= req.getParameter("qualification");
		String email= req.getParameter("email");
		String Password=req.getParameter("password");
		
		
		
		// create user object and pass values
		user user =new user();
		// set values in user object
		user.setName(fullName);
		user.setQualification(qualification);
		user.setEmail(email);
		user.setPassword(Password);
		
		// add user to database
		boolean addUser = userServiceLayer.addUser(user);
		
		HttpSession session=req.getSession();
		
		if (addUser == true) {
			// if user inserted into database successfully then set success msg in session object which i get in signup.jsp
			session.setAttribute("msg", "Sign Up Successfully");
			resp.sendRedirect("signUp.jsp");
		}
		else {
			// if user NOT inserted into database successfully then set error msg in session object which i get in signup.jsp
			session.setAttribute("msg", "Sign Up error");
			resp.sendRedirect("signUp.jsp");
		}
		
		
	}
	

}
