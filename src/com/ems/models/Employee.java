package com.ems.models;

// Abstract class representing a generic employee
// Uses encapsulation and cannot be instantiated directly
public abstract class Employee {
	// Protected attributes allow subclasses to access them directly
	protected int id;
	protected String name;
	protected String department;

	// Constructor to initialize common employee attributes
	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	// Abstract method that forces subclasses to define how salary is calculated
	public abstract double calculateSalary();

	// Getters for encapsulated fields
	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	// Setter for ID
	public void setId(int id) {
		this.id = id;
	}
}