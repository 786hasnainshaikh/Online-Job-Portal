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


@WebServlet("/updateJob")
public class updateJobServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetch id from edit button in editjob.jsp
		  String input = req.getParameter("id");
		  input = input.trim(); // Remove leading and trailing whitespace
          //converting from String to int
		  int id = Integer.parseInt(input);
		String jobTitle=req.getParameter("jobTitle");
		String location=req.getParameter("location");
		String category = req.getParameter("category");
		String status=req.getParameter("status");
		String description=req.getParameter("description");
		
		// creating job details object and passing values in argument 
		jobDetails details=new jobDetails();
		details.setJobId(id);
		details.setLocation(location);
		details.setTitle(jobTitle);
		details.setCategory(category);
		details.setStatus(status);
		details.setDescription(description);
		
		
		
		boolean updateJobById = jobServiceLayer.updateJobById(details);
		
		HttpSession session = req.getSession();
		
		if (updateJobById == true) {
			// if job updated into database the set success to msg in session object which i get in viewjobs.jsp
			session.setAttribute("msg", "Job Updated Successfully");
			resp.sendRedirect("viewJobs.jsp");
		}
		else {
			// if job NOT updated into database the set error to msg in session object which i get in viewjobs.jsp
			session.setAttribute("msg", "Job not Updated");
			resp.sendRedirect("viewJobs.jsp");
		}
		
		
		
		
		
		
		
		
		
		
	}
	
   
}
