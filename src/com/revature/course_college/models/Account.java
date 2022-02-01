package com.revature.course_college.models;


public abstract class Account {

	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String userName;
	protected String email;
	protected String password;
	
	public Account(String firstname, String middlename, String lastname, String password) {
		this.firstName = firstname;
		this.middleName = middlename;
		this.lastName = lastname;
		this.userName = generateUserName(firstname, middlename, lastname);
		this.email = generateCollegeEmail(this.userName);
		this.password = password;
		
	}
	
	public void setLastName(String last) {
		lastName = last;
	}
	
	public void getLastName(String last) {
		lastName = last;
	}
	
	public void setFirstName(String first) {
		firstName = first;
	}
	
	public void setMiddleName(String middle) {
		middleName = middle;
	}
	
	public void setPassWord(String pass) {
		password = pass;
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
