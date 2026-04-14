# Java Final Project
## Employee Management System (EMS)

### The Problem This Solves
Many small-to-medium businesses rely on paper files, spreadsheets, or disconnected software to manage their staff records. This leads to data loss, human error, and a lack of security. Plus, without a centralized database, it is difficult to quickly update or retrieve specific employee information.

### Functionality
The Employee Management System (EMS) is a secure CLI for Human Resources to manage personnel. It can do this:

- Data Persistence: Database integration using `MariaDB`.
- CRUD Operations: The ability to Create, Read, Update, and Delete employee records.
- Input Validation: Custom Exception handling prevents the application from crashing, if a user inputs empty names or negative salary amounts.
- Polymorphism: Automatically calculates monthly pay rates dynamically using inherited abstract methods based on the employee type.

### How Does It Work?
Here's how:

- The user interacts with the `Main.java` class, which is a CLI program.
- When data is entered, it is validated using the 'InvalidEmployeeException' class.
- If valid, the data is mapped to an Object-Oriented model (`FullTimeEmployee` or `PartTimeEmployee`, which inherit from the abstract `Employee` class).
- The object is then passed to the `DatabaseConnection` class.
- This class implements the `IEmployeeManager` interface and uses the `MariaDB JDBC driver` to send secure Prepared SQL Statements to the local database, ensuring the data is permanently saved or updated.

> Group 3: Daniil Sakov, Eric Rancourt, Giorgio Saccomani
