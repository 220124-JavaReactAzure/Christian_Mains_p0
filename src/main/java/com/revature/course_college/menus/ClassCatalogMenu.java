package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.service.ClassService;
import com.revature.course_college.service.FacultyAccountService;
import com.revature.course_college.util.MenuRouter;

public class ClassCatalogMenu extends Menu {

	private ClassService classService;
	private FacultyAccountService facultyAccountService;

	public ClassCatalogMenu(BufferedReader consoleReader, MenuRouter menuRouter, FacultyAccountService facultyAccountService, ClassService classService) {
		super("Class Catalog", "/classcatalog", consoleReader, menuRouter);
		this.facultyAccountService  = facultyAccountService;
		this.classService = classService;
	}

	@Override
	public void render() throws Exception {
		boolean menuRun = true;
		System.out.print("\n\n");
		System.out.print("Class Catalog Menu");
		classService.getAllClasses();

		while (menuRun) {
			System.out.print(classService.classCatalogMenu());
			System.out.print("c)  Create New Class\ne)  Edit Class\nd)  Delete Class\nex) Exit Class Catalog\n>");
			String classSelection = consoleReader.readLine();
			switch (classSelection) {

			case "c":
				System.out.print("Enter New Class ID\n>");
				String newClassID = consoleReader.readLine();
				System.out.print("Enter new Class Name\n>");
				String newClassName = consoleReader.readLine();
				System.out.print("How many credits does this class have\n>");
				try {
					int newClassCredits = Integer.parseInt(consoleReader.readLine());
					if (classService.createNewClass(newClassID, newClassName, newClassCredits)) {
						System.out.print("Class " + newClassID + ": " + newClassName + " has been created\n");
					} else {
						System.out.print("Class Creation of " + newClassID + ": " + newClassName + " has Failed\n");
					}
				} catch (NumberFormatException e) {
					System.out.print("Invalid Entry, Please Enter Number For Credit!\n");
				}
				break;

			case "e":
				System.out.println("What Class Would You like to Edit\n>");
				try {
				int editClass = Integer.parseInt(consoleReader.readLine());
				String oldEdit = classService.printThisClass(editClass);
				if(oldEdit != null) {
					System.out.print("The Class you are editing is:\n"+oldEdit+"\n");
					System.out.print("New Class ID\n>");
					String newID = consoleReader.readLine();
					System.out.print("New Class Name\n>");
					String newName = consoleReader.readLine();
					System.out.print("New Class Credits\n>");
					int newCredits = Integer.parseInt(consoleReader.readLine());
					if(classService.editClass(editClass, newID, newName, newCredits)) {
						System.out.print("Class edit was successful!\n");
					}else {System.out.print("Class edit failed!");}
				}else {System.out.print("\nInvalid Entry!\n");}
				
				}catch(NumberFormatException e) {System.out.print("\nInvalid Entry, Please Enter Number!\n");}
				break;

			case "d":
				int oldClass;
				System.out.print("What Class do you want to delete\n>");
				try {
					oldClass = Integer.parseInt(consoleReader.readLine());
					if (classService.deleteoldClass(oldClass)) {
						System.out.print("Class Deletion is Successfull!\n");
					} else {
						System.out.print("Class Deletion Failed!\n");
					}
				} catch (NumberFormatException e) {
					System.out.print("\nInvalid Entry, Please Enter number!\n");
				}
				break;

			case "ex":
				classService.dumpAllClasses();
				menuRun = false;
				break;
			default:
				System.out.print("\nInvalid Entry, Please Enter A Valid Value!\n");
				break;
			}
		}

	}
}
