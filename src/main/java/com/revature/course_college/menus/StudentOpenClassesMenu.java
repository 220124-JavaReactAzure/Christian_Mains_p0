package com.revature.course_college.menus;

import java.io.BufferedReader;
import com.revature.course_college.service.ClassService;
import com.revature.course_college.service.StudentAccountService;
import com.revature.course_college.util.MenuRouter;

public class StudentOpenClassesMenu extends Menu{
	
	private StudentAccountService studentAccountService;
	private ClassService classService;

	public StudentOpenClassesMenu(BufferedReader consoleReader, MenuRouter menuRouter, StudentAccountService studentAccountService, ClassService classService) {
		super("Student Open Classes Menu", "/studentopenclassesmenu", consoleReader, menuRouter);
		this.studentAccountService = studentAccountService;
		this.classService = classService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		classService.getAllClasses();
		System.out.print("\n\n");
		boolean menuRun = true;
		while(menuRun) {
			System.out.print("Class List:\n"+classService.classCatalogMenu());
			System.out.print("r) Register For A class\ne) Exit Class List");
		}
		
	}

}
