package com.ems.interfaces;

import com.ems.models.Employee;

// Interface outlining required methods for any class managing employee data
// CRUD -> Create, Read, Update, and Delete
public interface IEmployeeManager {
	// Method signature to add a new employee to the database (Create)
	void addEmployee(Employee emp) throws Exception;

	// Method signature to retrieve and print all employees (Read)
	void viewAllEmployees();

	// Method signature to update an existing employee's salary (Update)
	void updateEmployeeSalary(int id, double newSalary);

	// Method signature to remove an employee from the database (Delete)
	void deleteEmployee(int id);
}