package com.revature.course_college.daos;

import java.sql.*;
import org.postgresql.util.PSQLException;
import com.revature.course_college.util.*;
import com.revature.course_college.models.FacultyAccount;
import com.revature.course_college.models.StudentAccount;

public class StudentDAO implements CrudDAO<StudentAccount> {

	@Override
	public StudentAccount creat(StudentAccount newStudent) {
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "insert into StudentAccount (student_id, user_name, first_name, middle_name, last_name, email, password) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, newStudent.getID());
			ps.setString(2, newStudent.getUserName());
			ps.setString(3, newStudent.getFirstName());
			ps.setString(4, newStudent.getMiddleName());
			ps.setString(5, newStudent.getLastName());
			ps.setString(6, newStudent.getEmail());
			ps.setString(7, newStudent.getPassWord());

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted != 0) {
				return newStudent;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public LinkedList<StudentAccount> findAll() {
		LinkedList<StudentAccount> studentList = new LinkedList<>();
		try {Connection connection = ConnectionFactory.getInstance().getConnection();
		
			String sql = "select * from StudentAccount";
			Statement s = connection.createStatement();
			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				StudentAccount studentAccount = new StudentAccount();
				studentAccount.setID(resultSet.getInt("student_id"));
				studentAccount.setUserName(resultSet.getString("user_name"));
				studentAccount.setFirstName(resultSet.getString("first_name"));
				studentAccount.setMiddleName(resultSet.getString("middle_name"));
				studentAccount.setLastName(resultSet.getString("last_name"));
				studentAccount.setEmail(resultSet.getString("email"));
				studentAccount.setPassWord(resultSet.getString("password"));
				studentList.add(studentAccount);
			}
			return studentList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StudentAccount findByID(int id) {
		StudentAccount account = new StudentAccount();
		try {Connection connection = ConnectionFactory.getInstance().getConnection();

			String sql = "select * from StudentAccount where student_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				account.setID(resultset.getInt("student_id"));
				account.setUserName(resultset.getString("user_name"));
				account.setFirstName(resultset.getString("first_name"));
				account.setMiddleName(resultset.getString("middle_name"));
				account.setLastName(resultset.getString("last_name"));
				account.setEmail(resultset.getString("email"));
				account.setPassWord(resultset.getString("password"));
			}
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StudentAccount findByUsername(String userName) {
		StudentAccount account = new StudentAccount();
		try {Connection connection = ConnectionFactory.getInstance().getConnection();

			String sql = "select * from StudentAccount where user_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  userName);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				account.setID(resultset.getInt("student_id"));
				account.setUserName(resultset.getString("user_name"));
				account.setFirstName(resultset.getString("first_name"));
				account.setMiddleName(resultset.getString("middle_name"));
				account.setLastName(resultset.getString("last_name"));
				account.setEmail(resultset.getString("email"));
				account.setPassWord(resultset.getString("password"));
			}
			return account;
		} catch (PSQLException e) {
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(StudentAccount updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(StudentAccount oldObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudentAccount loginByUsernamePassword(String username, String password) {
		StudentAccount account = new StudentAccount();
		try {Connection connection = ConnectionFactory.getInstance().getConnection();

			String sql = "select * from StudentAccount where user_name = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  username);
			preparedStatement.setString(2,  password);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				account.setID(resultset.getInt("student_id"));
				account.setUserName(resultset.getString("user_name"));
				account.setFirstName(resultset.getString("first_name"));
				account.setMiddleName(resultset.getString("middle_name"));
				account.setLastName(resultset.getString("last_name"));
				account.setEmail(resultset.getString("email"));
				account.setPassWord(resultset.getString("password"));
			}
			return account;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
