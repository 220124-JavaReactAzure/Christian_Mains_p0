package com.revature.course_college.util;

import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.revature.course_college.daos.*;
import com.revature.course_college.service.*;

public class CourseCollegeApp {

	private final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	private static boolean isRunning;

	public CourseCollegeApp() {

		logger.info("Application is innitializing . . . . . . .");

		isRunning = true;
		

		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		FacultyDAO facultyDAO = new FacultyDAO();
		FacultyAccountService facultyAccountService = new FacultyAccountService(facultyDAO);
		
		ClassDAO classDAO = new ClassDAO();
		ClassService classService = new ClassService(classDAO);
		
		StudentDAO studentDAO = new StudentDAO();
		StudentAccountService studentAccountService = new StudentAccountService(studentDAO, classDAO);
		
		

		logger.info("Application initiliazed!");
	}
}
