import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;
import java.util.regex.Pattern;
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Employee Management Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. List All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Perform Duties");
            System.out.println("6. Exit");
            int choice = readInt("Select option (1-6): ", 1, 6);
            switch (choice) {
                case 1: addEmployeeMenu(service); break;
                case 2: listAll(service); break;
                case 3: updateEmployeeMenu(service); break;
                case 4: deleteEmployeeMenu(service); break;
                case 5: performDuties(service); break;
                case 6: exit = true; break;
            }
        }
        scanner.close();
    }

    private static void addEmployeeMenu(EmployeeService service) {
        String type;
        do {
            type = readNonEmpty("Enter type (dev/junior/manager): ").toLowerCase();
        } while (!type.matches("dev|junior|manager"));

        int id = readInt("ID (positive integer): ", 1, Integer.MAX_VALUE);
        String name = readNonEmpty("Name: ");
        String dept = readNonEmpty("Department: ");
        double sal = readDouble("Salary (>=0): ", 0, Double.MAX_VALUE);
        String email = readEmail("Email: ");
        LocalDate hd = readDate("Hire Date (YYYY-MM-DD): ");

        switch (type) {
            case "dev":
                Developer d = new Developer(id, name, dept, sal, email, hd);
                String langs = readNonEmpty("Enter languages (comma-separated): ");
                for (String lang : langs.split(",")) d.addLanguage(lang.trim());
                service.addEmployee(d);
                break;
            case "junior":
                String mentor = readNonEmpty("Mentor name: ");
                JuniorDeveloper jd = new JuniorDeveloper(id, name, dept, sal, email, hd, mentor);
                String jlangs = readNonEmpty("Enter languages (comma-separated): ");
                for (String lang : jlangs.split(",")) jd.addLanguage(lang.trim());
                service.addEmployee(jd);
                break;
            case "manager":
                Manager m = new Manager(id, name, dept, sal, email, hd);
                service.addEmployee(m);
                break;
        }
        System.out.println("Employee added successfully.");
    }

    private static void listAll(EmployeeService service) {
        System.out.println("\n-- All Employees --");
        service.getAllEmployees().forEach(e -> System.out.println(e));
    }

    private static void updateEmployeeMenu(EmployeeService service) {
        int id = readInt("ID to update: ", 1, Integer.MAX_VALUE);
        if (service.getEmployee(id) == null) {
            System.out.println("Employee not found.");
            return;
        }
        String name = readNonEmpty("New Name: ");
        String dept = readNonEmpty("New Dept: ");
        double sal = readDouble("New Salary (>=0): ", 0, Double.MAX_VALUE);
        String email = readEmail("New Email: ");
        boolean ok = service.updateEmployee(id, name, dept, sal, email);
        System.out.println(ok ? "Updated successfully." : "Update failed.");
    }

    private static void deleteEmployeeMenu(EmployeeService service) {
        int id = readInt("ID to delete: ", 1, Integer.MAX_VALUE);
        boolean ok = service.deleteEmployee(id);
        System.out.println(ok ? "Deleted." : "Employee not found.");
    }

    private static void performDuties(EmployeeService service) {
        System.out.println("\n-- Perform Duties --");
        service.getAllEmployees().forEach(e -> e.performDuties());
    }

    // Input helpers with validation
    private static int readInt(String prompt, int min, int max) {
        int val;
        while (true) {
            try {
                System.out.print(prompt);
                val = Integer.parseInt(scanner.nextLine());
                if (val < min || val > max) throw new NumberFormatException();
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer between " + min + " and " + max + ".");
            }
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        double val;
        while (true) {
            try {
                System.out.print(prompt);
                val = Double.parseDouble(scanner.nextLine());
                if (val < min || val > max) throw new NumberFormatException();
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between " + min + " and " + max + ".");
            }
        }
    }

    private static String readNonEmpty(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    private static String readEmail(String prompt) {
        String email;
        do {
            System.out.print(prompt);
            email = scanner.nextLine().trim();
        } while (!EMAIL_PATTERN.matcher(email).matches());
        return email;
    }

    private static LocalDate readDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Please enter a valid date in YYYY-MM-DD format.");
            }
        }
    }
}