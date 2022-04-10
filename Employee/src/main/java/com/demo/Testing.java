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

@SuppressWarnings("serial")
public class Testing implements Serializable {

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

	public void closeStatementsAndConnection() {
		try {
			stm.close();
			pstm.close();
			rs.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementsAndConnection();
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
			System.out.println("Update successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementsAndConnection();
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
			System.out.println("Insert new employee successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementsAndConnection();
		}
	}

	public Boolean isEmailExists(String email) {
		String query = "select case when count(e)> 0 then true else false end from employee as e where e.email = ?;";
		Boolean isEmailExists = false;
		try {
			pstm = getConnection().prepareStatement(query);
			pstm.setString(1, email);
			rs = pstm.executeQuery();
			if (rs.next()) {
				isEmailExists = rs.getBoolean(1);
				return isEmailExists;
			}
		} catch (

		SQLException e) {
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
			if (rs.next()) {
				isPhoneNumberExists = rs.getBoolean("case");
				return isPhoneNumberExists;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isPhoneNumberExists;
	}

	public void countEmail() {
		String query = "select count(e.email) from employee as e where e.email = ?;";
		try {
			pstm = getConnection().prepareStatement(query);
			pstm.setString(1, "tranminhquang@gmail.com");
			rs = pstm.executeQuery();
			if (rs.next()) {
				Integer count = rs.getInt(1);
				System.out.println("count: " + count);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Testing t = new Testing();
		System.out.println(t.isEmailExists("quang@gmail.com"));
	}

}
