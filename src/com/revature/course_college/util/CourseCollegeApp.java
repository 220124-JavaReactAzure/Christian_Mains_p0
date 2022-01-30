package com.revature.course_college.util;

import java.io.*;

import com.revature.course_college.menus.*;

public class CourseCollegeApp {
	
	private boolean isRunning;
	private final MenuRouter menuRouter;
	
	public CourseCollegeApp() {
		
		this.isRunning = true;
		this.menuRouter = new MenuRouter();
		
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
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
	
	public void shutDown() {
		isRunning = false;
	}
}
