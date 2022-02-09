package com.revature.course_college.menus;

import java.io.BufferedReader;
import java.util.Random;

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
		System.out.print("\n\nPlease enter required information for new account\n");
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
			if(facultyAccountService.allReadyHasAccount(firstName, middleName, lastName) || studentAccountService.allReadyHasAccount(firstName, middleName, lastName)) {
				System.out.print("\nYou Are Already Have A Registerd Account!\n");
				break;
			}
			
			System.out.print("\nAre you a new Faculty Member or a new Student\n1) Faculty\n2) Student\n>");
			String userInput = consoleReader.readLine();
			
				String username = firstName.substring(0, 1).toLowerCase()+ middleName.substring(0, 1).toLowerCase() + lastName.toLowerCase();
				int i = 0;
				while (true) {
					FacultyAccount facultyTest = facultyAccountService.findByUsername(username);
					StudentAccount studentTest = studentAccountService.findByUsername(username);
					if (facultyTest.getUserName() == null && studentTest.getUserName() == null) {
						break;
					}
					i++;
					username = username +i;
				}
				
				Random rand = new Random();
				while (true) {
					i = rand.nextInt((99999 - 10000) + 1) + 10000;
					FacultyAccount facultyTest = facultyAccountService.findByID(i);
					StudentAccount studentTest = studentAccountService.findByID(i);
					if (facultyTest.getUserName() == null && studentTest.getUserName() == null) {
						break;
					}
				}
			
			if (userInput.equals("1")) {
				FacultyAccount newFaculty = new FacultyAccount(firstName, middleName, lastName, password);
				newFaculty.setUserName(username);
				newFaculty.setID(i);
				try {
					facultyAccountService.registerNewFaculty(newFaculty);
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			}
			
			if (userInput.equals("2")) {
				StudentAccount newStudent = new StudentAccount(firstName, middleName, lastName, password);
				newStudent.setUserName(username);
				newStudent.setID(i);
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
