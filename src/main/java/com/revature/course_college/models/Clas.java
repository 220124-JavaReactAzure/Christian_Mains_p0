package com.revature.course_college.models;

public class Clas {

	protected String id;
	protected String name;
	protected int credits;

	public Clas() {
		super();
	}

	public Clas(String id, String name, int credits) {
		this.id = id;
		this.name = name;
		this.credits = credits;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public String toString() {
		return id + ": " + name + ": " + credits + " Credits";
	}
}
