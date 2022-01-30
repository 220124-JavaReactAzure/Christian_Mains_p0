package com.revature.course_college.models;

import com.revature.course_college.util.LinkedList;

public class FacultyAccount extends Account{
	
	LinkedList<Class> classes;
	
	FacultyAccount(String firstname, String middlename, String lastname, String email, String password){
		super(firstname, middlename, lastname, email, password);
		this.classes = new LinkedList<Class>();
	}

}
