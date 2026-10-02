# Student Management System

This is a Java-based Student Management System developed using **Java, JDBC, and MySQL**.

I created this project to practice Java database connectivity and understand how a real application can be organized using different layers.

## Features

* Add, update, delete, and view student records
* Manage course details
* Search for students
* Perform CRUD operations using JDBC
* Use `PreparedStatement` for SQL queries
* Use `CallableStatement` to execute stored procedures
* Use DAO and DTO layers to keep the code organized
* Use a Connection Factory for managing database connections

## Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE
* Git & GitHub

## Project Structure

The project is organized into different packages:

* **ConnectionFactory** – Handles database connections
* **DAO** – Contains database operations
* **DTO** – Used to transfer student and course data
* **Stored Procedures** – Used for specific database operations

## Database

MySQL is used as the database for storing student and course information.

The course table contains details such as:

* Course ID
* Course Name
* Duration
* Fees

## What I Learned

Through this project, I gained practical experience with:

* Java and OOP concepts
* JDBC
* MySQL
* CRUD operations
* PreparedStatement
* CallableStatement
* Stored Procedures
* DAO and DTO
* Database connection management
* Git and GitHub

## How to Run

1. Clone the repository.
2. Open the project in Eclipse.
3. Set up the required MySQL database and tables.
4. Configure your MySQL username and password in the connection code.
5. Add the MySQL JDBC driver to the project.
6. Run the application from Eclipse.

## Author

**Sanjair004**

This project was created for learning and practicing **Java, JDBC, and MySQL**.
