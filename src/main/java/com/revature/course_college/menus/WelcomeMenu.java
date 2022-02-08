package com.revature.course_college.menus;

import java.io.*;
import com.revature.course_college.util.MenuRouter;
import com.revature.course_college.util.CourseCollegeApp;

public class WelcomeMenu extends Menu{

	public WelcomeMenu(BufferedReader consoleReader, MenuRouter menuRouter) {
		super("Welcome", "/welcome",consoleReader, menuRouter);
		
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
			menuRouter.transfer("/loginmenu");
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
