package com.revature.course_college.daos;

import java.sql.*;
import java.util.LinkedList;

import com.revature.course_college.models.Clas;
import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.util.ConnectionFactory;

public class ClassDAO{

	public Clas creat(Clas newClass) {
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "insert into Clas (class_id, class_name, class_credits) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, newClass.getID());
			ps.setString(2, newClass.getName());
			ps.setInt(3, newClass.getCredits());

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted != 0) {
				return newClass;
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}

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


	public boolean update(Clas updateClass, String newID, String newName, int newCredits) {
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "update Clas set class_id = ?, class_name = ?, class_credits = ? where class_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, newID);
			ps.setString(2, newName);
			ps.setInt(3, newCredits);
			ps.setString(4,  updateClass.getID());

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted != 0) {
				return true;
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}

		return false;
	}
	
	public boolean delete(Clas oldClass) {
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "delete from Clas where class_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, oldClass.getID());

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted != 0) {
				return true;
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}

		return false;
	}
	
	public LinkedList<Clas> myClassList(int studentID){
		LinkedList<String> myClass = new LinkedList<String>();
		LinkedList<Clas> answer = new LinkedList<Clas>();
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select class_id from classRegistry where student_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, studentID);
			ResultSet resultSet = ps.executeQuery(sql);
			
			while (resultSet.next()) {
				myClass.add(resultSet.getString("class_id"));
			}
			while(!myClass.isEmpty()) {
				sql = "select * from Clas where class_id = ?";
				ps = connection.prepareStatement(sql);
				ps.setString(1, myClass.remove());
				resultSet = ps.executeQuery(sql);
				Clas newClass = new Clas();
				newClass.setID(resultSet.getString("class_id"));
				newClass.setName(resultSet.getString("class_name"));
				newClass.setCredits(resultSet.getInt("class_credits"));
				answer.add(newClass);
			}
			return answer;
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
}
