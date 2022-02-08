package com.revature.course_college.service;

import com.revature.course_college.daos.ClassDAO;
import com.revature.course_college.models.Clas;
import com.revature.course_college.util.LinkedList;

public class ClassService {

	private ClassDAO classDAO;
	private LinkedList<Clas> classes;
	
	public ClassService(ClassDAO classDAO) {
		this.classDAO = classDAO;
		this.classes =null;
	}
	
	public void getAllClasses() {
		classes = classDAO.findAll();
	}
	
	public String classCatalogMenu() throws Exception{
		String answer = "";
		for(int i = 0; i < classes.getSize(); i++) {
			answer = answer + i + ") " + classes.get(i).toString() + "\n";
		}
		return answer + "\n";
	}
	
	public boolean createNewClass()
}
