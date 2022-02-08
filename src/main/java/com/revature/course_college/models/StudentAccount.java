package com.revature.course_college.models;

import com.revature.course_college.util.LinkedList;

public class StudentAccount extends Account{

	LinkedList<Clas> classes;
	
	public StudentAccount(){
		super();
		classes = new LinkedList<Clas>();
	}
	public StudentAccount(String firstname, String middlename, String lastname, String password){
		super(firstname, middlename, lastname, password);
		this.classes = new LinkedList<Clas>();
	}
	
	public boolean addClass(Clas clas) {
		return this.classes.add(clas);
	}
	
	public boolean removeClass(String classID) throws Exception {
		for(int i = 0; i < classes.getSize(); i++) {
			if(classes.get(i).id.equals(classID)) {
				classes.remove(classes.get(i));
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String answer = "ID is "+this.ID + "\nUsername is " + this.userName + "\nFirstname is "
	+ this.firstName + "\nMiddlename is " + this.middleName + "\nLastame is " + this.lastName + "\nEmail is " + this.email
	+ "\nPassword is " + this.password;
		return answer;
	}
	

}
