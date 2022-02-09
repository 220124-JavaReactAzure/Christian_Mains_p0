package com.revature.course_college.menus;

import java.io.*;
import com.revature.course_college.util.MenuRouter;
import com.revature.course_college.service.FacultyAccountService;
import com.revature.course_college.service.StudentAccountService;
import com.revature.course_college.util.CourseCollegeApp;

public class WelcomeMenu extends Menu{

	private FacultyAccountService facultyAccountService;
	private StudentAccountService studentAccountService;
	
	public WelcomeMenu(BufferedReader consoleReader, MenuRouter menuRouter, FacultyAccountService facultyAccountService,
			StudentAccountService studentAccountService) {
		super("Welcome", "/welcome",consoleReader, menuRouter);
		this.facultyAccountService = facultyAccountService;
		this.studentAccountService = studentAccountService;
	}
	
	public void render() throws Exception{
		
		System.out.print("Welcome to Course College\n"
						+ "1) Log in "
					  + "\n2) Register a new account"
					  + "\n3) Exit menu"
					  + "\n>");
		
		String userSelection = consoleReader.readLine();
		
		switch(userSelection) {
		case "1":
			System.out.print("\n");
			while (true) {
				System.out.print("Please Enter Your Login Information\nOr Enter q to exit\nUserName> ");
				String userName = consoleReader.readLine();
				System.out.print("PassWord> ");
				String passWord = consoleReader.readLine();
				if(userName.equals("q") || passWord.equals("q")) {
					System.out.print("\n\n");
					break;}
				if (facultyAccountService.login(userName, passWord)) {
					menuRouter.transfer("/facultydashboard");
					break;
				}
				if (studentAccountService.login(userName, passWord)) {
					menuRouter.transfer("/studentdashboard");
					break;
				}
				System.out.print("\nUsername or Password is Incorrect!\n");
				
			}
			break;
		case "2":
			menuRouter.transfer("/registeraccountmenu");
			break;
		case "3":
			System.out.print("\nWe Look forward to your next fisit, Good By!\nCourse College");
			CourseCollegeApp.shutDown();
			break;
		default: 
			System.out.print("\nInvalid Entry\n");
			break;
			
		}
	}
		

}
