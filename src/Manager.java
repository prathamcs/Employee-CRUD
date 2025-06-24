// Subclass for Managers
import java.time.LocalDate;
import java.util.*;

class Manager extends Employee {
    private List<Employee> team = new ArrayList<>();
    private int projectsManaged;

    public Manager(int id, String name, String department, double salary, String email, LocalDate hireDate) {
        super(id, name, department, salary, email, hireDate);
    }

    public void addToTeam(Employee e) { team.add(e); }
    public boolean removeFromTeam(Employee e) { return team.remove(e); }
    public int getTeamSize() { return team.size(); }

    public int getProjectsManaged() { return projectsManaged; }
    public void manageProject() { projectsManaged++; }

    @Override
    public double calculateBonus() {
        // 20% salary + $500 per project
        return salary * 0.20 + projectsManaged * 500;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is managing a team of " + getTeamSize() + " employees.");
    }

    @Override
    public String toString() {
        return "Manager -> " + super.toString() + String.format(
                ", TeamSize: %d, Projects: %d",
                getTeamSize(), projectsManaged
        );
    }
}