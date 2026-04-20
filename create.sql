-- Create the database
CREATE DATABASE ems_db;

-- Tell MariaDB to use this new database
USE ems_db;

-- Create the employees table inside it
CREATE TABLE employees (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	department VARCHAR(50) NOT NULL,
	employee_type VARCHAR(20) NOT NULL,
	salary DOUBLE NOT NULL
);