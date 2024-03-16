package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/logOutServlet")
public class logoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		// get  the object either user or admin form navbar.jsp
		session.getAttribute("user");
		// remove the object or destroy the object 
		session.removeAttribute("user");
		
		// then set a value in session object 
		session.setAttribute("userNotExist", "Logout Successfully");
		// then redirect to login page if want to login again
		resp.sendRedirect("login.jsp");
	}
	

}
