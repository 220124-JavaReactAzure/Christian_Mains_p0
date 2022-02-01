package com.revature.course_college.models;

import com.revature.course_college.util.LinkedList;

public class StudentAccount extends Account{

	LinkedList<Class> classes;
	
	StudentAccount(String firstname, String middlename, String lastname, String password){
		super(firstname, middlename, lastname, password);
		this.classes = new LinkedList<Class>();
	}
	

}
