package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.service.FacultyAccountService;
import com.revature.course_college.util.MenuRouter;

public class RegisterAccountMenu extends Menu{
	
	private FacultyAccountService facultyAccountService;
	
	public RegisterAccountMenu(BufferedReader consoleReader, MenuRouter menuRouter, FacultyAccountService facultyAccountService) {
		super("RegisterAccountMenu", "/registeraccountmenu", consoleReader, menuRouter);
		this.facultyAccountService = facultyAccountService;
		
	}

	@Override
	public void render() throws Exception {
		String firstName; String middleName; String lastName; String passWord;
		boolean validPassWord = false;
		
		System.out.print("Plese enter required information for new account\nFirst Name\n>");
		firstName = consoleReader.readLine();
		System.out.print("Middle Name\n>");
		middleName = consoleReader.readLine();
		System.out.print("Last Name\n>");
		lastName = consoleReader.readLine();
		System.out.print("Password\n>");
		passWord = consoleReader.readLine();
		FacultyAccount newAccount = new FacultyAccount(firstName, middleName, lastName, passWord);
		
		try {
			facultyAccountService.registerNewFaculty(newAccount);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
