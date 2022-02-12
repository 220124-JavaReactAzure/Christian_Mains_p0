package com.revature.course_college.service;

import java.util.LinkedList;

import com.revature.course_college.daos.ClassDAO;
import com.revature.course_college.models.Clas;

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
	
	public void dumpAllClasses() {
		classes = null;
	}
	
	public String printThisClass(int i) throws Exception {
		if(i < 0 || i >= classes.size()) {return null;}
		Clas cuo = classes.get(i);
		return cuo.getID()+": "+cuo.getName()+" Credits = "+cuo.getCredits();
	}
	
	public String classCatalogMenu() throws Exception{
		String answer = "";
		for(int i = 0; i < classes.size(); i++) {
			answer = answer + i + ") " + classes.get(i).toString() + "\n";
		}
		return answer + "\n";
	}
	
	public boolean createNewClass(String classID, String className, int classCredit) {
		Clas newClass = new Clas(classID, className, classCredit);
		newClass = classDAO.creat(newClass);
		if(newClass != null) {
			classes.add(newClass);
			return true;
		}
		return false;
	}
	
	public boolean deleteoldClass(int i) throws Exception {
		if(i < 0 || i >= classes.size()) {return false;}
		Clas oldClass = classes.get(i);
		if(classDAO.delete(oldClass)) {
			classes.remove(oldClass);
			return true;
		}
		return false;
	}
	
	public boolean editClass(int oldClass, String newID, String newName, int newCredits) throws Exception {
		if(oldClass < 0 || oldClass >= classes.size()) {return false;}
		Clas editclass = classes.get(oldClass);
		if(classDAO.update(editclass, newID, newName, newCredits)) {
			editclass.setID(newID);
			editclass.setName(newName);
			editclass.setCredits(newCredits);
			return true;
		}
		else {	return false;}
	}
}
