package com.ems.exceptions;

// Custom exception class to handle specific validation errors related to employee data entry
// Extends the built-in Exception class to create a custom checked exception
public class InvalidEmployeeException extends Exception {
	// Constructor that accepts a custom error message
	// Will be used in other classes
	public InvalidEmployeeException(String message) {
		// Passes the message to the parent Exception class
		super(message);
	}
}