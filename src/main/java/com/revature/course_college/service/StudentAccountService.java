package com.revature.course_college.service;

import java.util.Random;

import com.revature.course_college.daos.ClassDAO;
import com.revature.course_college.daos.StudentDAO;
import com.revature.course_college.models.Clas;
import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.models.StudentAccount;
import com.revature.course_college.util.LinkedList;

public class StudentAccountService {

	private StudentDAO studentDAO;
	private ClassDAO classDAO;
	private StudentAccount studentSession;

	public StudentAccountService(StudentDAO studentDAO, ClassDAO classDAO) {
		this.studentDAO = studentDAO;
		this.classDAO = classDAO;
		this.studentSession = null;
	}

	public boolean registerNewStudent(StudentAccount studentAccount) {

		studentAccount.setEmail(studentAccount.getUserName() + "@college.edu");

		StudentAccount account = studentDAO.creat(studentAccount);
		System.out.println("\n\nYour account is created, your information is\n" + account.toString() + "\n");

		return true;
	}
	
	public boolean allReadyHasAccount(String firstName, String middleName, String lastName) {
		return studentDAO.allReadyHasAccount(firstName, middleName, lastName);
	}

	public boolean login(String userName, String passWord) {
		StudentAccount account = studentDAO.loginByUsernamePassword(userName, passWord);
		if (account.getUserName() != null) {
			studentSession = account;
			return true;
		}
		return false;
	}

	public void logout() {
		studentSession = null;
	}

	public StudentAccount getStudentSession() {
		return studentSession;
	}
	
	public StudentAccount findByUsername(String username) {
		return studentDAO.findByUsername(username);
	}

	public StudentAccount findByID(int id) {
		return studentDAO.findByID(id);
	}
	
	public String printMyRigisteredClasses() throws Exception {
		return studentSession.printClasses();
	}
	
	public void getMyRegisteredClasses() {
		LinkedList<Clas> myClass = classDAO.myClassList(studentSession.getID());
		studentSession.setClasses(myClass);
	}
}
