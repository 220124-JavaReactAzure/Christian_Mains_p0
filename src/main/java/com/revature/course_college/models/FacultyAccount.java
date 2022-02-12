package com.revature.course_college.models;


public class FacultyAccount extends Account {

	public FacultyAccount() {
		super();
	}
	
	public FacultyAccount(String firstname, String middlename, String lastname, String password){
		super(firstname, middlename, lastname, password);
		
	}
	
	
	public String toString() {
		String answer = "ID is "+this.ID + "\nUsername is " + this.userName + "\nFirstname is "
	+ this.firstName + "\nMiddlename is " + this.middleName + "\nLastame is " + this.lastName + "\nEmail is " + this.email
	+ "\nPassword is " + this.password;
		return answer;
	}


}
