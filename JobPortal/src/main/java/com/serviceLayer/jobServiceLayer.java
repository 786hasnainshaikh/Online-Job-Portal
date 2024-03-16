package com.serviceLayer;


import java.util.ArrayList;
import java.util.List;

import com.daoLayer.jobDAO;
import com.entity.jobDetails;

public class jobServiceLayer {
	
	// add job business login
   public static boolean addJob(jobDetails details) {
	   // passing object to dao layer 
	   boolean addJob = jobDAO.addJob(details);
	   return addJob;
	   
   }
   
   
   
   
   
   // fetch job business logic
   public static List<jobDetails> getJobDetails(){
	   List<jobDetails> allJobs = jobDAO.getAllJobs();
	   return allJobs;
   }

   // get job by id
   public static jobDetails getJobbyId(int id) {
	   
	  jobDetails jobbyId = jobDAO.getJobbyId(id); 
	  
	  return jobbyId;
   }
   
   
   // update job 
   public static boolean updateJobById(jobDetails details ) {
	   
	   boolean updateJob = jobDAO.updateJob(details);
	   
	   return updateJob;
   }
 
   // delete job
   public static boolean deleteJob(int id) {
	   boolean deleteJob = jobDAO.deleteJob(id);
	   
	  return deleteJob; 
   }
   
   // show jobs whose status is active
   public static List<jobDetails> getAtiveJobs(){
	   
	  List<jobDetails> activeJobs = jobDAO.getActiveJobs();
	   return activeJobs;
   }
   
   
   
   
   // fetch jobs based on particular loaction and category
   public static List<jobDetails> getJobOnLoc_Cat(String category, String location){
	   
	     List<jobDetails> jobOnLoc_Cat = jobDAO.getJobOnLoc_Cat(category,location );
	   return jobOnLoc_Cat;
   }
   
   
   
   
}
