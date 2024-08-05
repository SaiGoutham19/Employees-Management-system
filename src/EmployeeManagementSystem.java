import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private HashMap<String, Employee> employeeMap;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employeeMap = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee with this ID already exists.");
        } else {
            employeeMap.put(id, new Employee(id, name, department, salary));
            System.out.println("Employee added successfully.");
        }
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String id = scanner.nextLine();

        Employee emp = employeeMap.get(id);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new Name (leave blank to keep current): ");
        String name = scanner.nextLine();
        System.out.print("Enter new Department (leave blank to keep current): ");
        String department = scanner.nextLine();
        System.out.print("Enter new Salary (leave blank to keep current): ");
        String salaryInput = scanner.nextLine();

        if (!name.isEmpty()) emp.setName(name);
        if (!department.isEmpty()) emp.setDepartment(department);
        if (!salaryInput.isEmpty()) emp.setSalary(Double.parseDouble(salaryInput));

        System.out.println("Employee details updated.");
    }

    public void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String id = scanner.nextLine();

        if (employeeMap.remove(id) != null) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee emp : employeeMap.values()) {
                System.out.println(emp);
            }
        }
    }

    public void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        String id = scanner.nextLine();

        Employee emp = employeeMap.get(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    displayAllEmployees();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.run();
    }
}
