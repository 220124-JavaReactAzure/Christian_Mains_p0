package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.service.FacultyAccountService;
import com.revature.course_college.util.MenuRouter;

public class FacultyAccountMenu extends Menu{

	FacultyAccountService facultyAccountService;
	
	public FacultyAccountMenu(BufferedReader consoleReader, MenuRouter menuRouter, FacultyAccountService facultyAccountService) {
		super("Faculty Account Menu", "/facultyaccountmenu", consoleReader, menuRouter);
		this.facultyAccountService = facultyAccountService;
	}



	@Override
	public void render() throws Exception {
		System.out.print("\n\nNeed To Implement Faculty Account Menu!\nPress Enter to return to Faculty Dashboard");
		String userInput = consoleReader.readLine();
		menuRouter.transfer("/facultydashboard");
	}
	
}
