package com.revature.course_college.exceptions;

public class InvalidRequestException extends RuntimeException{

	@SuppressWarnings("serial")
	public InvalidRequestException(String message) {
		super(message);
	}
}
