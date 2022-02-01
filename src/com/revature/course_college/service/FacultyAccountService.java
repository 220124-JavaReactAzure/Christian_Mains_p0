package com.revature.course_college.service;

import com.revature.course_college.daos.FacultyDAO;
import com.revature.course_college.models.FacultyAccount;

public class FacultyAccountService {
	
	private FacultyDAO facultyDAO = new FacultyDAO();

	public boolean registerNewFaculty(FacultyAccount facultyAccount) {
		facultyDAO.creat(facultyAccount);
		return false;
	}
}
