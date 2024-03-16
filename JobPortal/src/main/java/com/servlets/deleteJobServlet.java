package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.jobServiceLayer;

@WebServlet("/deleteServlet")
public class deleteJobServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		// fetch id from delete button defined in viewjob.jsp by default return type of getparameter is string
		String input = req.getParameter("id");
		// Remove leading and trailing whitespace
		input = input.trim(); 
		// converting from String to int
		int id = Integer.parseInt(input);
        // pass id in delete job method to delete particular job
		boolean deleteJob = jobServiceLayer.deleteJob(id);

		HttpSession session = req.getSession();

		if (deleteJob == true) {
			// if job deleted from database set msg in session object which we get in viewJobs.jsp
			session.setAttribute("msg", "Job Deleted successfully");
			resp.sendRedirect("viewJobs.jsp");
		} else {
			// if job NOT deleted from database set msg in session object which we get in viewJobs.jsp
			session.setAttribute("msg", "Job not deleted Deleted");
			resp.sendRedirect("viewJobs.jsp");
		}

	}
}
