package com.revature.course_college.models;


public abstract class Account {

	protected int ID;
	protected String userName;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String email;
	protected String password;
	
	public Account() {
		super();
	}
	public Account(String firstname, String middlename, String lastname, String password) {
		this.ID = 0;
		this.userName = null;
		this.firstName = firstname;
		this.middleName = middlename;
		this.lastName = lastname;
		this.email = null;
		this.password = password;
		
	}
	public void setID(int id) {
		ID = id;
	}
	public int getID() {
		return ID;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setFirstName(String first) {
		lastName = first;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMiddleName() {
		return middleName;
	}
	
	public void setLastName(String last) {
		lastName = last;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setPassWord(String passWord) {
		this.password = passWord;
	}
	public String getPassWord() {
		return password;
	}
}
