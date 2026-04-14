package com.ems.models;

// Inherits from the abstract Employee class, representing a part-time worker
public class PartTimeEmployee extends Employee {
	// Private attributes specific to part-time employees
	private double hourlyRate;
	private int hoursWorked;

	// Constructor calling the superclass constructor
	public PartTimeEmployee(String name, String department, double hourlyRate, int hoursWorked) {
		// Passes name and department up to the abstract Employee class
		super(name, department);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	// Implementing the abstract method from the parent class
	@Override
	public double calculateSalary() {
		// Calculates total pay based on hours worked and the hourly rate
		return hourlyRate * hoursWorked;
	}
}