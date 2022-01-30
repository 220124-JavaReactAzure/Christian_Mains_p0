package com.revature.course_college.menus;

import java.io.BufferedReader;

import com.revature.course_college.util.MenuRouter;

public abstract class Menu {
	
	protected String name;
	protected String rout;
	protected BufferedReader consoleReader;
	protected MenuRouter menuRouter;
	
	public Menu(String name, String rout, BufferedReader consoleReader, MenuRouter menuRouter) {
		
		this.name = name;
		this.rout = rout;
		this.consoleReader = consoleReader;
		this.menuRouter = menuRouter;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRout() {
		return this.rout;
	}
	
	public abstract void render() throws Exception;

}
