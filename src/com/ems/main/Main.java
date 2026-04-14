package com.ems.main;

import com.ems.db.DatabaseConnection;
import com.ems.exceptions.InvalidEmployeeException;
import com.ems.models.FullTimeEmployee;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Instantiate the scanner for user input
		Scanner scanner = new Scanner(System.in);
		// Instantiate the database connection logic
		DatabaseConnection db = new DatabaseConnection();
		// Variable to control the main loop
		boolean running = true;

		// Main application loop
		while (running) {
			// Print the CLI menu options
			System.out.println("\n--- Employee Management System ---");
			System.out.println("1. Add Full-Time Employee");
			System.out.println("2. View All Employees");
			System.out.println("3. Update Employee Salary");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");

			// Read user choice
			String choice = scanner.nextLine();

			// Switch statement to handle user choices
			switch (choice) {
			case "1":
				try {
					System.out.print("Enter Name: ");
					String name = scanner.nextLine();
					// Validation: Check if name is empty
					if (name.trim().isEmpty())
						throw new InvalidEmployeeException("Name cannot be empty.");

					System.out.print("Enter Department: ");
					String dept = scanner.nextLine();

					System.out.print("Enter Annual Salary: ");
					double salary = Double.parseDouble(scanner.nextLine());
					// Validation: Check if salary is realistic
					if (salary < 0)
						throw new InvalidEmployeeException("Salary cannot be negative.");

					// Create the object and pass to the database layer
					FullTimeEmployee emp = new FullTimeEmployee(name, dept, salary);
					db.addEmployee(emp);

				} catch (NumberFormatException e) {
					// Catch if the user enters letters instead of numbers for salary
					System.out.println("Error: Please enter a valid number for salary.");
				} catch (InvalidEmployeeException e) {
					// Catch our custom validation errors
					System.out.println("Validation Error: " + e.getMessage());
				} catch (Exception e) {
					// Catch any unexpected errors
					System.out.println("Unexpected Error: " + e.getMessage());
				}
				break;
			case "2":
				// Call the read operation
				db.viewAllEmployees();
				break;
			case "3":
				System.out.print("Enter Employee ID to update: ");
				int updateId = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter new monthly salary: ");
				double newSalary = Double.parseDouble(scanner.nextLine());
				// Call the update operation
				db.updateEmployeeSalary(updateId, newSalary);
				break;
			case "4":
				System.out.print("Enter Employee ID to delete: ");
				int deleteId = Integer.parseInt(scanner.nextLine());
				// Call the delete operation
				db.deleteEmployee(deleteId);
				break;
			case "5":
				// Exit the loop and end the program
				running = false;
				System.out.println("Exiting System. Goodbye!");
				break;
			default:
				// Handle invalid menu inputs
				System.out.println("Invalid choice. Please try again.");
			}
		}
		// Close the scanner to prevent resource leaks
		scanner.close();
	}
}