package com.ems.db;

import com.ems.interfaces.IEmployeeManager;
import com.ems.models.Employee;
import com.ems.models.FullTimeEmployee;
import java.sql.*;

// Handles the MariaDB database connection and implements CRUD operations
public class DatabaseConnection implements IEmployeeManager {
	// Database credentials
	private static final String URL = "jdbc:mariadb://localhost:3306/ems_db";
	private static final String USER = "root";
	private static final String PASSWORD = "password";

	// Helper method to establish the database connection
	private Connection connect() throws SQLException {
		// Returns a live connection object to MariaDB
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// Implements the Create operation
	@Override
	public void addEmployee(Employee emp) {
		// SQL query
		String query = "INSERT INTO employees (name, department, employee_type, salary) VALUES (?, ?, ?, ?)";

		// Try-with-resources automatically closes connection to prevent memory leaks
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			// Set the string for the first placeholder (name)
			pstmt.setString(1, emp.getName());
			// Set the string for the second placeholder (department)
			pstmt.setString(2, emp.getDepartment());
			// Determine type based on class instance
			pstmt.setString(3, (emp instanceof FullTimeEmployee) ? "Full-Time" : "Part-Time");
			// Set the salary using the abstract method implementation
			pstmt.setDouble(4, emp.calculateSalary());

			// Execute the update to the database
			pstmt.executeUpdate();
			System.out.println("Employee added successfully!");
		} catch (SQLException e) {
			// Catch and print any database errors
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	// Implements the Read operation
	@Override
	public void viewAllEmployees() {
		// Simple SELECT query to get all rows
		String query = "SELECT * FROM employees";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			// Loop through the result set row by row
			while (rs.next()) {
				// Print formatted output for each employee
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Dept: "
						+ rs.getString("department") + ", Type: " + rs.getString("employee_type") + ", Salary: $"
						+ rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	// Implements the Update operation
	@Override
	public void updateEmployeeSalary(int id, double newSalary) {
		// Update query targeting a specific employee ID
		String query = "UPDATE employees SET salary = ? WHERE id = ?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			// Set the new salary value
			pstmt.setDouble(1, newSalary);
			// Set the target ID
			pstmt.setInt(2, id);
			// Execute the update and store the number of affected rows
			int rows = pstmt.executeUpdate();
			if (rows > 0)
				System.out.println("Salary updated successfully.");
			else
				System.out.println("Employee ID not found.");
		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	// Implements the Delete operation
	@Override
	public void deleteEmployee(int id) {
		// Delete query targeting a specific ID
		String query = "DELETE FROM employees WHERE id = ?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			// Set the target ID to delete
			pstmt.setInt(1, id);
			// Execute the deletion
			int rows = pstmt.executeUpdate();
			if (rows > 0)
				System.out.println("Employee deleted successfully.");
			else
				System.out.println("Employee ID not found.");
		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}
}