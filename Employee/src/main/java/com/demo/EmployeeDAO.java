package com.demo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4292338593529944620L;

	private static final String URL = "jdbc:postgresql://localhost:5432/demo";

	private static final String USER = "postgres";

	private static final String PASSWORD = "31101997";

	private static ResultSet rs;

	private static Connection c;

	private static Statement stm;

	private static PreparedStatement pstm;

	public Connection getConnection() {
		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	// get all employees
	public List<Employee> getListEmployees() {
		List<Employee> listEmployees = new ArrayList<Employee>();
		String query = "select * from employee order by id asc;";
		try {
			stm = getConnection().createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setDateOfBirth(rs.getDate(3));
				employee.setEmail(rs.getString(4));
				employee.setPhoneNumber(rs.getString(5));
				employee.setJoinDate(rs.getDate(6));
				listEmployees.add(employee);
			}
			stm.close();
			rs.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEmployees;
	}

	// delete employee by id
	public void deleteEmployeeById(Integer id) {
		String query = "delete from employee where id = ?;";
		try {
			pstm = getConnection().prepareStatement(query);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			pstm.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// update employee
	public void updateEmployeeInfor(Employee employee) {
		String query = "update employee set name = ?, date_of_birth = ?, email = ?, phone_number = ?, join_date = ? where id = ?;";
		try {
			pstm = getConnection().prepareStatement(query);
			pstm.setString(1, employee.getName());
			pstm.setDate(2, new java.sql.Date(employee.getDateOfBirth().getTime()));
			pstm.setString(3, employee.getEmail());
			pstm.setString(4, employee.getPhoneNumber());
			pstm.setDate(5, new java.sql.Date(employee.getJoinDate().getTime()));
			pstm.setInt(6, employee.getId());
			pstm.executeUpdate();
			pstm.close();
			c.close();
			System.out.println("Update successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// insert new employee
	public void insertNewEmployee(Employee employee) {
		String query = "insert into employee(name, date_of_birth, email, phone_number, join_date) values (?, ?, ?, ?, ?);";
		try {
			pstm = getConnection().prepareStatement(query);
			pstm.setString(1, employee.getName());
			pstm.setDate(2, new java.sql.Date(employee.getDateOfBirth().getTime()));
			pstm.setString(3, employee.getEmail());
			pstm.setString(4, employee.getPhoneNumber());
			pstm.setDate(5, new java.sql.Date(employee.getJoinDate().getTime()));
			pstm.executeUpdate();
			pstm.close();
			c.close();
			System.out.println("Insert new employee successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean isEmailExists(String email) {
		String query = "select case when count(e)> 0 then true else false end from employee as e where e.email = ?;";
		Boolean isEmailExists = false;
		try {
			pstm = getConnection().prepareStatement(query);
			pstm.setString(1, email);
			rs = pstm.executeQuery();
			while (rs.next()) {
				isEmailExists = rs.getBoolean("case");
				return isEmailExists;
			}
			pstm.close();
			rs.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isEmailExists;
	}

	public boolean isPhoneNumberExists(String phoneNumber) {
		String query = "select case when count(e)> 0 then true else false end from employee as e where e.phone_number = ?;";
		Boolean isPhoneNumberExists = false;
		try {
			pstm = getConnection().prepareStatement(query);
			pstm.setString(1, phoneNumber);
			rs = pstm.executeQuery();
			while (rs.next()) {
				isPhoneNumberExists = rs.getBoolean("case");
				return isPhoneNumberExists;
			}
			pstm.close();
			rs.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isPhoneNumberExists;
	}
}
