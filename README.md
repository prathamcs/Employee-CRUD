# Employee Management Console Application

A simple Java console-based application demonstrating object-oriented principles and CRUD operations with a dynamic menu-driven interface.

## Features

* **Inheritance & Polymorphism**: Abstract `Employee` base class with concrete subclasses:

  * `Developer` (code languages, tickets resolved)
  * `JuniorDeveloper` (mentor, training tasks)
  * `Manager` (team management, projects)
* **Encapsulation**: Private fields with public getters/setters
* **Dynamic Menu**: Interactive console menu to Add, List, Update, Delete employees, or invoke `performDuties()`
* **Input Validation**: Robust checks for integers, doubles, non-empty strings, valid emails, and dates
* **Bonus Calculation**: Each role implements its own bonus logic
* **Duties Simulation**: Polymorphic `performDuties()` methods print role-specific tasks

## Project Structure

```
src/
├─ Employee.java
├─ Developer.java
├─ JuniorDeveloper.java
├─ Manager.java
├─ EmployeeService.java
├─ Main.java
```

## Prerequisites

* Java 11 or later
* A terminal/command-prompt environment

## Build & Run

1. **Compile**:

   ```sh
   javac -d out src/model/*.java src/service/*.java src/app/*.java
   ```
2. **Run**:

   ```sh
   java -cp out app.Main
   ```

## Usage

* **Add Employee**: Choose type (`dev`, `junior`, `manager`) and provide details
* **List All**: Display all stored employees
* **Update Employee**: Modify name, department, salary, and email by ID
* **Delete Employee**: Remove record by ID
* **Perform Duties**: Execute `performDuties()` for each employee
* **Exit**: Quit the application

## Extending the Application

* Persist data to a database (JDBC, JPA/Hibernate)
* Expose REST/GraphQL API (Spring Boot)
* Add role-based authentication (Spring Security)
* Implement file-based import/export (CSV, JSON)
* Integrate unit and integration tests (JUnit 5, Mockito)

---

*Author: Pratham Patel*
