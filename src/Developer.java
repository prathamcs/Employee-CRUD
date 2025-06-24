import java.util.*;
import java.time.LocalDate;
class Developer extends Employee {
    private List<String> programmingLanguages = new ArrayList<>();
    private int ticketsResolved;

    public Developer(int id, String name, String department, double salary, String email, LocalDate hireDate) {
        super(id, name, department, salary, email, hireDate);
    }

    public List<String> getProgrammingLanguages() { return programmingLanguages; }
    public void addLanguage(String lang) { programmingLanguages.add(lang); }
    public boolean removeLanguage(String lang) { return programmingLanguages.remove(lang); }

    public int getTicketsResolved() { return ticketsResolved; }
    public void resolveTicket() { ticketsResolved++; }

    @Override
    public double calculateBonus() {
        // 10% salary + $50 per ticket
        return salary * 0.10 + ticketsResolved * 50;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is writing code in " + programmingLanguages + ".");
    }
}