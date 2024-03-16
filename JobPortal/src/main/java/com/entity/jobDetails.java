package com.entity;

public class jobDetails {
       private int jobId;
       private String title;
       private String description;
       private String category;
       private String status;
       private String location;
       private String publishDate;
       
       
	public jobDetails() {
		
	}


	


	public jobDetails(String title, String description, String category, String status, String location) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		this.location = location;
	}





	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}


	@Override
	public String toString() {
		return "jobDetails [jobId=" + jobId + ", title=" + title + ", description=" + description + ", category="
				+ category + ", status=" + status + ", location=" + location + ", publishDate=" + publishDate + "]";
	}
   
       
}
