package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.jobDetails;
import com.serviceLayer.jobServiceLayer;


@WebServlet("/addjob")
public class addJobServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetching data from add_Job.jsp
		String jobTitle =req.getParameter("jobTitle");
		String location =req.getParameter("location");
		String category=req.getParameter("category");
		String status=req.getParameter("status");
		String description=req.getParameter("description");
		
		// passing all details in jobdetails object
		jobDetails jobDetails =new jobDetails(jobTitle, description,category,status,location);
		
		// pass  that object to jobService layer to jobDAO layer
		boolean addJob = jobServiceLayer.addJob(jobDetails);
		
		HttpSession session=req.getSession();
		
		if (addJob == true) {
			// if job inserted into database set success msg in session which we get in add_Job.jsp
			session.setAttribute("Msg", "Data Inserted Successfully");
			resp.sendRedirect("add_Job.jsp");
		}
		else {
			// if job NOT inserted into database set Error msg in session which we get in add_Job.jsp
			session.setAttribute("Msg", "Error!!!!!");
			resp.sendRedirect("add_Job.jsp");
		}
		
		
		
		
	}
	

}
