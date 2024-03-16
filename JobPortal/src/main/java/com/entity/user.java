package com.entity;

public class user {
	private int useId;
	private String name;
	private String email;
	private String password;
	private String qualification;
	public String role;
	
	


	public user() {
		super();
	}


	public user( String name, String email, String password, String qualification, String role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.qualification = qualification;
		this.role = role;
	}


	public int getUseId() {
		return useId;
	}


	public void setUseId(int useId) {
		this.useId = useId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}



	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	


	@Override
	public String toString() {
		return "user [useId=" + useId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", qualification=" + qualification + ", jobRole=" + role + "]";
	}

	

}
