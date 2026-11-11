# Employee Management System (EMS)

A RESTful Employee Management System built using Java, Spring Boot, and MySQL. This project helps manage employee information and department details through REST APIs.

##  Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Postman
- Git & GitHub

##  Features

### Employee Management
- Add new employees
- View all employees
- View employee details by ID
- Update employee information
- Delete employees

### Department Management
- Create departments
- View all departments
- Associate employees with departments

### Additional Features
- RESTful API architecture
- DTO-based data transfer
- MySQL database integration
- One-to-Many / Many-to-One relationship between departments and employees

##  Project Structure

```text
src/main/java/com/example/employeemanagementsystem
│
├── controller
├── Service
├── Repository
├── entity
└── dto
```

## API Endpoints

### Employee APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/employees | Create employee |
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get employee by ID |
| PUT | /api/employees/{id} | Update employee |
| DELETE | /api/employees/{id} | Delete employee |

### Department APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/departments | Create department |
| GET | /api/departments | Get all departments |

##  How to Run the Project

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Configure your MySQL database.
4. Set your database username and password using environment variables or local configuration.
5. Build the project using Maven.
6. Run the Spring Boot application.

##  Project Goal

The goal of this project is to gain practical experience in Java backend development, Spring Boot, REST APIs, database relationships, and CRUD operations.

## 👨‍💻 Developer

Developed as a hands-on backend development project using Java and Spring Boot.
