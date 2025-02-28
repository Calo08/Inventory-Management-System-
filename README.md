# Inventory-Management-System-

This Inventory Management System is a desktop application developed in Java using JavaFX for the frontend and MySQL for the backend database. The system helps manage products, track stock, and process sales for a retail business.

Features
	•	User Authentication: Simple username and password setup for logging in.
	•	Product Management: Add, update, delete, and list products in the inventory.
	•	Sales Processing: Track sales and update stock levels.
	•	Database: MySQL database to store user credentials, product details, and sales records.

Technologies Used
	•	Java 11 (or later)
	•	JavaFX for GUI
	•	MySQL for database manag
	•	JDBC for database connectivity
	•	Maven (or Gradle) for dependency management

Prerequisites

Before running the project, ensure you have the following installed:
	•	Java Development Kit (JDK) version 11 or later
	•	MySQL Server running locally or on a remote server
	•	Maven or Gradle for building the project

MySQL Setup
	1.	Create a MySQL database with the name inventory_db.
	2.	Run the provided SQL script to create the necessary tables. The script will also insert a default admin user for the system.

SQL Script:

CREATE DATABASE inventory_db;
USE inventory_db;

-- Users Table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'cashier') NOT NULL
);

-- Products Table
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    stock INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE SET NULL
);

-- Suppliers Table
CREATE TABLE suppliers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(50),
    email VARCHAR(100)
);

-- Sales Table
CREATE TABLE sales (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    total DECIMAL(10,2) NOT NULL,
    sale_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Sales Items Table (Tracks products in each sale)
CREATE TABLE sales_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sale_id INT,
    product_id INT,
    quantity INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (sale_id) REFERENCES sales(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

-- Insert Default Admin User
INSERT INTO users (username, password, role) VALUES ('admin', 'admin123', 'admin');

Database Configuration
	1.	Configure the database connection in the DatabaseConnection.java file:
	•	Set the URL, USER, and PASSWORD for your MySQL database.

private static final String URL = "jdbc:mysql://localhost:3306/inventory_db";
private static final String USER = "root";  // Change if needed
private static final String PASSWORD = "";  // Change if needed

How to Run
	1.	Clone the repository to your local machine:

git clone https://github.com/your-repo/inventory-management-system.git
cd inventory-management-system


	2.	Compile and run the project:
	•	If using Maven, run:

mvn clean install
mvn javafx:run


	•	If using IntelliJ IDEA:
	•	Open the project and configure the src/main/java as the main source directory.
	•	Set the Main class to the class containing launch() (e.g., Main.java).
	•	Run the project directly from the IDE.

	3.	Login with the default admin credentials:
	•	Username: admin
	•	Password: admin123
	4.	Once logged in, you can manage products, track stock levels, and process sales transactions.

Project Structure

├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controllers
│   │   │   │   ├── LoginController.java
│   │   │   │   ├── ProductManagementController.java
│   │   │   ├── dao
│   │   │   │   ├── ProductDAO.java
│   │   │   │   ├── UserDAO.java
│   │   │   ├── model
│   │   │   │   ├── Product.java
│   │   │   │   ├── User.java
│   │   │   ├── database
│   │   │   │   ├── DatabaseConnection.java
│   ├── resources
│   │   ├── views
│   │   │   ├── Login.fxml
│   │   │   ├── ProductManagement.fxml
│   │   │   ├── Dashboard.fxml
└── pom.xml (or build.gradle)

Future Improvements
	•	Advanced Reporting: Add more complex sales and inventory reports.
	•	User Roles: Implement different permissions for admin and cashier roles.
	•	Security: Hash passwords before storing them in the database.
	•	Supplier Management: Add the ability to manage suppliers more effectively.

License

This project is licensed under the MIT License - see the LICENSE file for details.
