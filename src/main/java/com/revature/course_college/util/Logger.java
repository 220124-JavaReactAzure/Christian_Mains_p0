package com.revature.course_college.util;

import java.io.*;

public class Logger {
	
	private static Logger logger;
	private final boolean printToConsole;
	
	private Logger (boolean printToConsole) {
		this.printToConsole = printToConsole;
	}
	
	
	public static Logger getLogger(boolean printToConsole) {
		if(logger == null) {
			logger = new Logger(printToConsole);
		}
		return logger;	
	}
	
	
	public void log(String message){
		try {
			try (Writer logWriter = new FileWriter("src/main/resources/course_college.log", true)) {
				logWriter.write(message + "\n");
			}
			if(printToConsole) {
				System.out.println(message);
			}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
