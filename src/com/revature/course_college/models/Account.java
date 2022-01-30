package com.revature.course_college.models;


public abstract class Account {

	String firstName;
	String middleName;
	String lastName;
	String userName;
	String email;
	String password;
	
	public Account(String firstname, String middlename, String lastname, String email, String password) {
		this.firstName = firstname;
		this.middleName = middlename;
		this.lastName = lastname;
		this.userName = generateUserName(firstname, middlename, lastname);
		this.email = generateCollegeEmail(this.userName);
		this.password = password;
		
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public void setMiddleName(String middle) {
		this.middleName = middle;
	}
	
	public void setPassWord(String pass) {
		this.password = pass;
	}
	
	private boolean isValidPassword(String pass) {
		if(pass.length() < 8 || pass.length() > 17) {
			return false;
		}
		return true;
	}
	
	private String generateUserName(String first, String middle, String last) {
		String newPassword = first.charAt(0) + middle.charAt(0) + last;
		return newPassword;
	}
	
	private String generateCollegeEmail(String username) {
		String newEmail = username + "@coursecollege.edu";
		return newEmail;
	}
}
