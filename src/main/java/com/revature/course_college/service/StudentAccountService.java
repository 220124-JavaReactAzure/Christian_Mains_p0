package com.revature.course_college.service;

import java.util.Random;

import com.revature.course_college.daos.StudentDAO;
import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.models.StudentAccount;

public class StudentAccountService {

	private StudentDAO studentDAO;
	private StudentAccount studentSession;

	public StudentAccountService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		this.studentSession = null;
	}

	public boolean registerNewStudent(StudentAccount studentAccount) {

		studentAccount = generateID(studentAccount);
		studentAccount = generateUsername(studentAccount);
		studentAccount.setEmail(studentAccount.getUserName() + "@college.edu");

		StudentAccount account = studentDAO.creat(studentAccount);
		System.out.println("\n\nYour account is created, your information is\n" + account.toString() + "\n");

		return true;
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

	private StudentAccount generateID(StudentAccount account) {
		Random rand = new Random();
		int numID = 0;
		while (true) {
			numID = rand.nextInt((99999 - 10000) + 1) + 10000;
			StudentAccount testaccount = studentDAO.findByID(numID);
			if (testaccount.getID() == 0) {
				account.setID(numID);
				return account;
			}
		}
	}

	private StudentAccount generateUsername(StudentAccount account) {
		String username = account.getFirstName().substring(0, 1).toLowerCase()
				+ account.getMiddleName().substring(0, 1).toLowerCase() + account.getLastName().toLowerCase();
		StudentAccount testaccount = new StudentAccount();
		int i = 0;
		while (true) {
			testaccount = studentDAO.findByUsername(username);
			if (testaccount.getUserName() == null) {
				account.setUserName(username);
				return account;
			}
			i++;
			username = username + i;
		}
	}

	public StudentAccount getStudentSession() {
		return studentSession;
	}
}
