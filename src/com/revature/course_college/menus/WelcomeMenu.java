package com.revature.course_college.menus;

import java.io.*;

public class WelcomeMenu extends Menu{

	public WelcomeMenu(BufferedReader consoleReader, MenuRouter menuRouter) {
		super("Welcome", "/welcome",consoleReader, menuRouter);
		
	}
	
	public void render() throws Exception{
		
		System.out.print("Welcome to Course College\n"
				+ "1) Log in \n2) Register a new account\n3) Exit menu\n>");
		
		String userSelection = consoleReader.readLine();
		
		switch(userSelection) {
		case "1":
			System.out.print("You Chose 1");
			break;
		case "2":
			System.out.print("You chose 2");
			break;
		case "3":
			shutDown();
			break;
		default: 
			System.out.print("invalid input");
			break;
		}
	}
		

}
