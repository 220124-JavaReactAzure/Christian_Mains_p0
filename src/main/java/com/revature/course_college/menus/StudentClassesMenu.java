package com.revature.course_college.menus;

import java.io.BufferedReader;
import com.revature.course_college.service.ClassService;
import com.revature.course_college.service.StudentAccountService;
import com.revature.course_college.util.MenuRouter;

public class StudentClassesMenu extends Menu{
	
	private StudentAccountService studentAccountService;

	public StudentClassesMenu(BufferedReader consoleReader, MenuRouter menuRouter, StudentAccountService studentAccountService) {
		super("Student Classes Menu", "/studentclassesmenu", consoleReader, menuRouter);
		this.studentAccountService = studentAccountService;
	}

	@Override
	public void render() throws Exception {
		studentAccountService.getMyRegisteredClasses();
		boolean menuRun = true;
		System.out.print(studentAccountService.printMyRigisteredClasses());
		
	}

}
