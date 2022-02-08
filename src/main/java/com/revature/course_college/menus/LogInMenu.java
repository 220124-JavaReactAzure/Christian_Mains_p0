package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.service.*;
import com.revature.course_college.util.MenuRouter;

public class LogInMenu extends Menu {

	private FacultyAccountService facultyAccountService;
	private StudentAccountService studentAccountService;

	public LogInMenu(BufferedReader consoleReader, MenuRouter menuRouter, FacultyAccountService facultyAccountService,
			StudentAccountService studentAccountService) {
		super("LogInMenu", "/loginmenu", consoleReader, menuRouter);
		this.facultyAccountService = facultyAccountService;
		this.studentAccountService = studentAccountService;
	}

	@Override
	public void render() throws Exception {
		while (true) {
			System.out.print("Please Entre Your Login Information\nUserName> ");
			String userName = consoleReader.readLine();
			System.out.print("PassWord> ");
			String passWord = consoleReader.readLine();
			if (facultyAccountService.login(userName, passWord)) {
				menuRouter.transfer("/facultydashboard");
				break;
			}
			if (studentAccountService.login(userName, passWord)) {
				menuRouter.transfer("/studentdashboard");
				break;
			}
			System.out.print("Username or Password is Incorrect!\n");
			
		}

	}

}
