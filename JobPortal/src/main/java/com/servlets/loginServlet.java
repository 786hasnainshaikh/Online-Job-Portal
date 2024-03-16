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


@WebServlet("/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// fetching email,password from login.jsp
			String email=req.getParameter("email");
			String Password=req.getParameter("password");
			
			user user=new user();
			HttpSession session=req.getSession();
			
			
//          set static email for Admin = admin@gmail.com and password =	admin123		
//			if condition is for Admin try to login
//          if user input matches with admin email,password			
			if ("admin@gmail.com".equals(email) && "admin123".equals(Password)) {
				session.setAttribute("user", user);
				// we defined user role as admin 
				user.setRole("admin");
				// then redirect to admin.jsp
				resp.sendRedirect("admin.jsp");
			}
			
//          else it is general user	
     		else {
				// go to user table in database and return value if user exist with this email or password
				user loginUser = userServiceLayer.login(email, Password);
				if (loginUser != null) {
					// set complete loginUser in session object which we get in home.jsp to fetch name to in button
					session.setAttribute("user", loginUser);
					resp.sendRedirect("home.jsp");
				}
				else {
					// if user is null or not present in database redirect to login page
					session.setAttribute("userNotExist", "Invalid User Name or Passowrd");
					resp.sendRedirect("login.jsp");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
