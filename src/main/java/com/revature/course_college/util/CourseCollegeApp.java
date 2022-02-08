package com.revature.course_college.util;

import java.io.*;

import com.revature.course_college.daos.*;
import com.revature.course_college.menus.*;
import com.revature.course_college.service.*;

public class CourseCollegeApp {

	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter menuRouter;

	public CourseCollegeApp() {

		logger = Logger.getLogger(true);
		logger.log("Application is innitializing . . . . . . .");

		isRunning = true;
		menuRouter = new MenuRouter();

		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		FacultyDAO facultyDAO = new FacultyDAO();
		FacultyAccountService facultyAccountService = new FacultyAccountService(facultyDAO);
		StudentDAO studentDAO = new StudentDAO();
		StudentAccountService studentAccountService = new StudentAccountService(studentDAO);
		ClassDAO classDAO = new ClassDAO();
		ClassService classService = new ClassService(classDAO);
		
		menuRouter.add(new WelcomeMenu(consoleReader, menuRouter));
		menuRouter.add(new LogInMenu(consoleReader, menuRouter, facultyAccountService, studentAccountService));
		menuRouter.add(new RegisterAccountMenu(consoleReader, menuRouter, facultyAccountService, studentAccountService));
		menuRouter.add(new StudentDashboard(consoleReader, menuRouter, studentAccountService));
		menuRouter.add(new FacultyDashboard(consoleReader, menuRouter, facultyAccountService));
		menuRouter.add(new ClassCatalogMenu(consoleReader, menuRouter, classService));
		menuRouter.add(new FacultyAccountMenu(consoleReader, menuRouter, facultyAccountService));

		logger.log("Application initiliazed!");
	}

	public void startUp() {
		try {
			while (isRunning) {
				menuRouter.transfer("/welcome");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void shutDown() {
		isRunning = false;
	}
}
