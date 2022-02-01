package com.revature.course_college.util;

import java.io.*;

import com.revature.course_college.menus.*;
import com.revature.course_college.service.*;

public class CourseCollegeApp {
	
	private static boolean isRunning;
	private final MenuRouter menuRouter;
	
	public CourseCollegeApp() {
		
		isRunning = true;
		menuRouter = new MenuRouter();
		
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		FacultyAccountService facultyAccountService = new FacultyAccountService();
		
		menuRouter.add(new LogInMenu(consoleReader, menuRouter));
		menuRouter.add(new RegisterAccountMenu(consoleReader, menuRouter, facultyAccountService));
		menuRouter.add(new WelcomeMenu(consoleReader, menuRouter));
	}
	
	public void startUp() {
		try {
			while(isRunning) {
				menuRouter.transfer("/welcome");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void shutDown() {
		isRunning = false;
	}
}
