package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.service.StudentAccountService;
import com.revature.course_college.util.MenuRouter;

public class StudentDashboard extends Menu{
	
	StudentAccountService studentAccountService;

	public StudentDashboard(BufferedReader consoleReader, MenuRouter menuRouter, StudentAccountService studentAccountService) {
		super("StudentDashboard", "/studentdashboard", consoleReader, menuRouter);
		this.studentAccountService = studentAccountService;
	}

	@Override
	public void render() throws Exception {
		System.out.print("\n\n");
		boolean menuRun = true;
		while(menuRun) {
			System.out.print("Student Dashboard\n0) View Open Classes\n1) View My Classes\n2) Exit Student Dashboard\n>");
			String userInput = consoleReader.readLine();
			switch(userInput) {
			case "0":
				menuRouter.transfer("/studentopenclassesmenu");
				break;
			case "1":
				menuRouter.transfer("/studentclassesmenu");
				break;
			case "2":
				studentAccountService.logout();
				menuRun = false;
				System.out.print("\n\n");
				break;
			default:
				System.out.print("Invalid Entry\n");
				break;
			}
		}
		
	}

}
