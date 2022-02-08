package com.revature.course_college.menus;

import java.io.BufferedReader;
import com.revature.course_college.service.FacultyAccountService;
import com.revature.course_college.util.MenuRouter;

public class FacultyDashboard extends Menu{
	
	private FacultyAccountService facultyAccountService;

	public FacultyDashboard(BufferedReader consoleReader, MenuRouter menuRouter, FacultyAccountService facultyAccountService) {
		super("FacultyDashboard", "/facultydashboard", consoleReader, menuRouter);
		this.facultyAccountService = facultyAccountService;
	}

	@Override
	public void render() throws Exception {
		System.out.print("\n\nFaculty Dashboard:\n1) Edit Class Catalog\n2) Edit My Account\n3) Log Out\n>");
		String userInput = consoleReader.readLine();
		switch (userInput){
		case "1":
			System.out.print("\n\n");
			menuRouter.transfer("/classcatalog");
			break;
		case "2":
			menuRouter.transfer("/facultyaccountmenu");
			break;
		case "3":
			facultyAccountService.logout();
			System.out.print("\n\n");
			menuRouter.transfer("/welcomemenu");
			break;
		}
		
	}

}





