package com.revature.course_college.service;

import org.junit.*;

import com.revature.course_college.exceptions.*;
import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.service.*;

public class ClassServiceTestSuite {

	FacultyAccountService sut;
	@Before
	public void testCaseSetUp() {
		sut = new FacultyAccountService();
	}
	@Test
	public void test_isFacultyValid_returnTrue_givenValidUser() {
		
		//Arrange
		FacultyAccount validFaculty = new FacultyAccount();

		//Act
		boolean actualResult = sut.isFacultyValid();
		//Assert
		Assert.assertTrue(actualResult);
	}
	
	@Test(expected = InvalidRequestException.class)
	public void test_Faculty() {
		
	}
}


