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

		facultyAccount = generateID(facultyAccount);
		facultyAccount = generateUsername(facultyAccount);
		facultyAccount.setEmail(facultyAccount.getUserName() + "@college.edu");

		FacultyAccount account = facultyDAO.creat(facultyAccount);
		System.out.println("\n\nYour account is created, your information is\n" + account.toString() + "\n");

		return true;
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

	private FacultyAccount generateID(FacultyAccount account) {
		Random rand = new Random();
		int numID = 0;
		while (true) {
			numID = rand.nextInt((99999 - 10000) + 1) + 10000;
			FacultyAccount testaccount = facultyDAO.findByID(numID);
			if (testaccount.getID() == 0) {
				account.setID(numID);
				return account;
			}
		}
	}

	private FacultyAccount generateUsername(FacultyAccount account) {
		String username = account.getFirstName().substring(0, 1).toLowerCase()
				+ account.getMiddleName().substring(0, 1).toLowerCase() + account.getLastName().toLowerCase();
		FacultyAccount testaccount = new FacultyAccount();
		int i = 0;
		while (true) {
			testaccount = facultyDAO.findByUsername(username);
			if (testaccount.getUserName() == null) {
				account.setUserName(username);
				return account;
			}
			i++;
			username = username + i;
		}
	}
}// end FacultyAccountService
