package com.revature.course_college.daos;

import java.sql.*;
import org.postgresql.util.PSQLException;
import com.revature.course_college.util.*;
import com.revature.course_college.models.FacultyAccount;

public class FacultyDAO implements CrudDAO<FacultyAccount> {

	@Override
	public FacultyAccount creat(FacultyAccount newFaculty) {
		try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "insert into FacultyAccount (faculty_id, user_name, first_name, middle_name, last_name, email, password) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, newFaculty.getID());
			ps.setString(2, newFaculty.getUserName());
			ps.setString(3, newFaculty.getFirstName());
			ps.setString(4, newFaculty.getMiddleName());
			ps.setString(5, newFaculty.getLastName());
			ps.setString(6, newFaculty.getEmail());
			ps.setString(7, newFaculty.getPassWord());

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted != 0) {
				return newFaculty;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public LinkedList<FacultyAccount> findAll() {
		LinkedList<FacultyAccount> facultyList = new LinkedList<>();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();
			String sql = "select * from FacultyAccount";
			Statement s = connection.createStatement();
			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				FacultyAccount facultyAccount = new FacultyAccount();
				facultyAccount.setID(resultSet.getInt("faculty_id"));
				facultyAccount.setUserName(resultSet.getString("user_name"));
				facultyAccount.setFirstName(resultSet.getString("first_name"));
				facultyAccount.setMiddleName(resultSet.getString("middle_name"));
				facultyAccount.setLastName(resultSet.getString("last_name"));
				facultyAccount.setEmail(resultSet.getString("email"));
				facultyAccount.setPassWord(resultSet.getString("password"));
				facultyList.add(facultyAccount);
			}
			return facultyList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FacultyAccount findByID(int id) {
		FacultyAccount account = new FacultyAccount();
		try {Connection connection = ConnectionFactory.getInstance().getConnection();

			String sql = "select * from FacultyAccount where faculty_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,  id);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				account.setID(resultset.getInt("faculty_id"));
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
	public FacultyAccount findByUsername(String userName) {
		FacultyAccount account = new FacultyAccount();
		try {Connection connection = ConnectionFactory.getInstance().getConnection();

			String sql = "select * from FacultyAccount where user_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  userName);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				account.setID(resultSet.getInt("faculty_id"));
				account.setUserName(resultSet.getString("user_name"));
				account.setFirstName(resultSet.getString("first_name"));
				account.setMiddleName(resultSet.getString("middle_name"));
				account.setLastName(resultSet.getString("last_name"));
				account.setEmail(resultSet.getString("email"));
				account.setPassWord(resultSet.getString("password"));
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
	public FacultyAccount loginByUsernamePassword(String username, String password) {
		FacultyAccount account = new FacultyAccount();
		try {
			Connection connection = ConnectionFactory.getInstance().getConnection();

			String sql = "select * from FacultyAccount where user_name = ? and password = ?" ;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  username);
			preparedStatement.setString(2,  password);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				account.setID(resultset.getInt("faculty_id"));
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

	@Override
	public boolean update(FacultyAccount updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(FacultyAccount oldObject) {
		// TODO Auto-generated method stub
		return false;
	}
}
