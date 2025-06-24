// Base class demonstrating inheritance and polymorphism
import java.util.*;
import java.time.*;
abstract class Employee {
    protected int id;
    protected String name;
    protected String department;
    protected double salary;
    protected String email;
    protected LocalDate hireDate;

    public Employee(int id, String name, String department, double salary, String email, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.hireDate = hireDate;
    }

    // Common getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getHireDate() { return hireDate; }

    // Polymorphic method for calculating bonus
    public abstract double calculateBonus();

    // Another polymorphic behavior
    public abstract void performDuties();

    @Override
    public String toString() {
        return String.format(
                "ID: %d, Name: %s, Dept: %s, Salary: %.2f, Email: %s, Hired: %s, Bonus: %.2f",
                id, name, department, salary, email, hireDate, calculateBonus()
        );
    }
}
