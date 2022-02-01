package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.util.MenuRouter;

public class LogInMenu extends Menu{

	public LogInMenu(BufferedReader consoleReader, MenuRouter menuRouter) {
		super("LogInMenu", "/loginmenu", consoleReader, menuRouter);
		
	}

	@Override
	public void render() throws Exception {
		System.out.print("need to implement Log In Menu\n\n");
		
	}
	
	

}
