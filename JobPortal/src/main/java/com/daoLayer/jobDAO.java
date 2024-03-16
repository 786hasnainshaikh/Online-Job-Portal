package com.daoLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DBconnection.connection;
import com.entity.jobDetails;

public class jobDAO {

	private static Connection con = connection.getConnection();

	// add job method
	public static boolean addJob(jobDetails details) {
		try {
			String query = "insert into jobDetails(Title, Description,category,status,location) values (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, details.getTitle());
			ps.setString(2, details.getDescription());
			ps.setString(3, details.getCategory());
			ps.setString(4, details.getStatus());
			ps.setString(5, details.getLocation());

			int result = ps.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// get all jobs
	public static List<jobDetails> getAllJobs() {
		List<jobDetails> jobDetalis = new ArrayList<jobDetails>();
		jobDetails details = null;
		try {
			String query = "select * from jobdetails order by JobId";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery(query);
			while (resultSet.next()) {
				// every creating new object and setting values
				details = new jobDetails();

				details.setJobId(resultSet.getInt(1));
				details.setTitle(resultSet.getString(2));
				details.setDescription(resultSet.getString(3));
				details.setStatus(resultSet.getString(5));
				details.setCategory(resultSet.getString(4));
				details.setLocation(resultSet.getString(6));
				details.setPublishDate(resultSet.getTimestamp(7) + "");
				// store that object into array list
				jobDetalis.add(details);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// returning array list of objects
		return jobDetalis;
	}
	
	// get job by id
	public static jobDetails getJobbyId(int id) {
		
		
		try {
			String query = "SELECT * FROM jobdetails WHERE JobId ="+id;
			PreparedStatement ps = con.prepareStatement(query);
			// setting parameter value
//			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery(query);
			
			if (resultSet.next()) {
				// every creating new object and setting values
				jobDetails details = new jobDetails();
				
				details.setJobId(resultSet.getInt(1));
				details.setTitle(resultSet.getString(2));
				details.setDescription(resultSet.getString(3));
				details.setCategory(resultSet.getString(4));
				details.setStatus(resultSet.getString(5));
				details.setLocation(resultSet.getString(6));
				details.setPublishDate(resultSet.getTimestamp(7) + "");
				
				return details;
			}else {
				return null;
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}		
		
	}
    
	
	
	// update job
	public static boolean updateJob(jobDetails details) {
		boolean flage=false;
		try {
			String query="update jobdetails set Title=?, Description=?, category=?, status=?,location=? where JobId =?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, details.getTitle());
			ps.setString(2, details.getDescription());
			ps.setString(3, details.getCategory());
			ps.setString(4, details.getStatus());
			ps.setString(5, details.getLocation());
			ps.setInt(6, details.getJobId());
			
			
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1) {
				return true;
			}
			else {
			    return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return flage;
	}
   
	// delete job
	public static boolean deleteJob(int id) {
		boolean flage=false;
		try {
			String query="delete from jobdetails where JobId ="+ id;
			PreparedStatement ps=con.prepareStatement(query);
			int executeUpdate = ps.executeUpdate();
			
			if (executeUpdate == 1) {
				flage =true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flage;
		
	}
  
	
	// get all jobs whose status is active for show to user
	public static List<jobDetails> getActiveJobs(){
		List<jobDetails> jobDetalis = new ArrayList<jobDetails>();
		jobDetails details = null;
		try {
			// select only records  those whose status is active to show only active jobs to user 
			String query = "select * from jobdetails where status= 'Active' order by JobId";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet resultSet = ps.executeQuery(query);
			while (resultSet.next()) {
				// every creating new object and setting values
				details = new jobDetails();

				details.setJobId(resultSet.getInt(1));
				details.setTitle(resultSet.getString(2));
				details.setDescription(resultSet.getString(3));
				details.setStatus(resultSet.getString(5));
				details.setCategory(resultSet.getString(4));
				details.setLocation(resultSet.getString(6));
				details.setPublishDate(resultSet.getTimestamp(7) + "");
				// store that object into array list
				jobDetalis.add(details);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// returning array list of objects
		return jobDetalis;
	}

	
	
	// fetch jobs based on particular loaction and category
	 public static List<jobDetails> getJobOnLoc_Cat(String category, String location){
		 List<jobDetails> jobDetalis = new ArrayList<jobDetails>();
			jobDetails details = null;
			try {
				String query = "select * from jobdetails where category=? and location=?";
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1, category);
				ps.setString(2, location);
				ResultSet resultSet = ps.executeQuery(query);
				while (resultSet.next()) {
					// every creating new object and setting values
					details = new jobDetails();

					details.setJobId(resultSet.getInt(1));
					details.setTitle(resultSet.getString(2));
					details.setDescription(resultSet.getString(3));
					details.setStatus(resultSet.getString(5));
					details.setCategory(resultSet.getString(4));
					details.setLocation(resultSet.getString(6));
					details.setPublishDate(resultSet.getTimestamp(7) + "");
					// store that object into array list
					jobDetalis.add(details);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			// returning array list of objects
			return jobDetalis;
	   }

}
