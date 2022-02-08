package com.revature.course_college.daos;

import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.util.LinkedList;

public interface CrudDAO<T> {
	
	public T creat(T newObject);
	
	public LinkedList<T> findAll();
	
	public T findByID(int id);
	
	public T findByUsername(String userName);
	
	public T loginByUsernamePassword(String username, String password);
	
	public boolean update(T updateObject);
	
	public boolean delete(T oldObject);

}
