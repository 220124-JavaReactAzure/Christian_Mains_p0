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
		System.out.println("Need to Implement Student DashBoard\n");
		
	}

}
