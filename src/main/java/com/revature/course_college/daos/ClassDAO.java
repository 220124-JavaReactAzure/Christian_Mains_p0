package com.revature.course_college.daos;

import java.sql.*;

import com.revature.course_college.models.Clas;
import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.util.ConnectionFactory;
import com.revature.course_college.util.LinkedList;

public class ClassDAO{

	public Clas creat(Clas newObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Clas> findAll() {
		LinkedList<Clas> clasList = new LinkedList<>();
		try {Connection connection = ConnectionFactory.getInstance().getConnection();
		
			String sql = "select * from Clas";
			Statement s = connection.createStatement();
			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				Clas new_clas = new Clas();
				new_clas.setID(resultSet.getString("class_id"));
				new_clas.setName(resultSet.getString("class_name"));
				new_clas.setCredits(resultSet.getInt("class_credits"));
				clasList.add(new_clas);
			}
			return clasList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean update(Clas updateObject) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean delete(Clas oldObject) {
		// TODO Auto-generated method stub
		return false;
	}
}
