import java.util.*;
class EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(Employee emp) { employeeMap.put(emp.getId(), emp); }
    public Employee getEmployee(int id) { return employeeMap.get(id); }
    public List<Employee> getAllEmployees() { return new ArrayList<>(employeeMap.values()); }
    public boolean updateEmployee(int id, String name, String department, double salary, String email) {
        Employee emp = employeeMap.get(id);
        if (emp == null) return false;
        emp.setName(name);
        emp.setDepartment(department);
        emp.setSalary(salary);
        emp.setEmail(email);
        return true;
    }
    public boolean deleteEmployee(int id) { return employeeMap.remove(id) != null; }
}
