package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.service.ClassService;
import com.revature.course_college.util.MenuRouter;

public class ClassCatalogMenu extends Menu{
	
	private ClassService classService;

	public ClassCatalogMenu(BufferedReader consoleReader, MenuRouter menuRouter, ClassService classService) {
		super("Class Catalog", "/classcatalog", consoleReader, menuRouter);
		this.classService = classService;
	}

	@Override
	public void render() throws Exception {
		classService.getAllClasses();
		System.out.print(classService.classCatalogMenu());
		System.out.print("1) Create New Class\n2) Edit Class\n3) Delete Class\n4) Exit Class Catalog\n>");
		String classRouter = consoleReader.readLine();
		switch(classRouter) {
		case "1":
			System.out.print("Enter New Class ID\n>");
			String newClassID = consoleReader.readLine();
			System.out.print("Enter new Class Name\n>");
			String newClassName = consoleReader.readLine();
			System.out.print("How many credits does this class have\n>");
			int newClassCredits = consoleReader.read();
			
		case "2":
		case "3":
		case "4":
			menuRouter.transfer("/facultydashboard");
			break;
		}
		
	}
}
