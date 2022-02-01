package com.revature.course_college.models;

import com.revature.course_college.util.LinkedList;

public class FacultyAccount extends Account{
	
	protected LinkedList<Class> classes;
	
	public FacultyAccount(String firstname, String middlename, String lastname, String password){
		super(firstname, middlename, lastname, password);
		this.classes = new LinkedList<Class>();
	}
	
	public String toFileString() {
		String newFaculty;
		newFaculty = firstName + ":" + middleName + ":" + lastName + ":" + password;
		return newFaculty;
	}

}
