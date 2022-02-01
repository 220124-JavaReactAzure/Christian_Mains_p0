package com.revature.course_college.daos;

import com.revature.course_college.util.LinkedList;

public interface CrudDAO<T> {
	
	public T creat(T newObject);
	
	public LinkedList<T> findAll();
	
	public T findByUsername(String userName);
	
	public boolean update(T updateObject);
	
	public boolean delete(T oldObject);

}
