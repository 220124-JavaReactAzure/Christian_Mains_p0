package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.models.*;
import com.revature.course_college.service.*;
import com.revature.course_college.util.MenuRouter;

public class RegisterAccountMenu extends Menu {

	private FacultyAccountService facultyAccountService;
	private StudentAccountService studentAccountService;

	public RegisterAccountMenu(BufferedReader consoleReader, MenuRouter menuRouter,
			FacultyAccountService facultyAccountService, StudentAccountService studentAccountService) {

		super("RegisterAccountMenu", "/registeraccountmenu", consoleReader, menuRouter);
		this.facultyAccountService = facultyAccountService;
		this.studentAccountService = studentAccountService;
	}

	@Override
	public void render() throws Exception {
		String firstName;
		String middleName;
		String lastName;
		String password;
		System.out.print("\n\nPlese enter required information for new account\n");
		while (true) {
			System.out.print("First Name\n>");
			firstName = consoleReader.readLine();
			System.out.print("Middle Name\n>");
			middleName = consoleReader.readLine();
			System.out.print("Last Name\n>");
			lastName = consoleReader.readLine();
			System.out.print("Password\n>");
			password = consoleReader.readLine();
			if (isValid(firstName, middleName, lastName, password)) {
				break;
			}
			System.out.print("\nInvalid Input Please Enter Information Again!\n");
		}

		while (true) {
			System.out.print("\nAre you a new Faculty Member or a new Student\n1) Faculty\n2) Student\n>");
			String userInput = consoleReader.readLine();
			if (userInput.equals("1")) {
				FacultyAccount newFaculty = new FacultyAccount(firstName, middleName, lastName, password);
				try {
					facultyAccountService.registerNewFaculty(newFaculty);
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			}
			if (userInput.equals("2")) {
				StudentAccount newStudent = new StudentAccount(firstName, middleName, lastName, password);
				try {
					studentAccountService.registerNewStudent(newStudent);
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			}
			System.out.print("Invalid Entry, Plese enter the correct value\n");
		}
	}

	private boolean isValid(String firstName, String middleName, String lastName, String password) {
		if (firstName == null || firstName.trim().equals("")) {
			return false;
		}
		if (middleName == null || middleName.trim().equals("")) {
			return false;
		}
		if (lastName == null || lastName.trim().equals("")) {
			return false;
		}
		if (password == null || password.trim().equals("")) {
			return false;
		}
		return true;
	}
}
