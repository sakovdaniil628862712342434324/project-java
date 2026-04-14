package com.ems.models;

// Inherits from the abstract Employee class, representing a full-time worker
public class FullTimeEmployee extends Employee {
	// Private attribute specific to full-time employees
	private double annualSalary;

	// Constructor calling the superclass constructor
	public FullTimeEmployee(String name, String department, double annualSalary) {
		// Passes name and department up to the abstract Employee class
		super(name, department);
		this.annualSalary = annualSalary;
	}

	// Implementing the abstract method from the parent class
	@Override
	public double calculateSalary() {
		// Returns the annual salary divided by 12 for a monthly figure
		return annualSalary / 12;
	}
}