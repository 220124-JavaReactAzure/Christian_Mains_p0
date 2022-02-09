package com.revature.course_college.service;

import java.util.Random;

import com.revature.course_college.daos.FacultyDAO;
import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.util.LinkedList;

public class FacultyAccountService {

	private FacultyDAO facultyDAO;
	private FacultyAccount facultySession;

	public FacultyAccountService(FacultyDAO facultyDAO) {
		this.facultyDAO = facultyDAO;
		this.facultySession = null;
	}

	public boolean registerNewFaculty(FacultyAccount facultyAccount) {

		facultyAccount.setEmail(facultyAccount.getUserName() + "@college.edu");

		FacultyAccount account = facultyDAO.creat(facultyAccount);
		System.out.println("\n\nYour account is created, your information is\n" + account.toString() + "\n");

		return true;
	}
	
	public boolean allReadyHasAccount(String firstName, String middleName, String lastName) {
		return facultyDAO.allReadyHasAccount(firstName, middleName, lastName);
	}

	public boolean login(String userName, String passWord) {
		FacultyAccount account = facultyDAO.loginByUsernamePassword(userName, passWord);
		if (account.getUserName() != null) {
			facultySession = account;
			return true;
		}
		return false;
	}

	public void logout() {
		facultySession = null;
	}

	public FacultyAccount getFacultySession() {
		return facultySession;
	}

	public FacultyAccount findByUsername(String username) {
		return facultyDAO.findByUsername(username);
	}

	public FacultyAccount findByID(int id) {
		return facultyDAO.findByID(id);
	}
}// end FacultyAccountService
