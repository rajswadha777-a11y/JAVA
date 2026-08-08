import java.util.Scanner;

class Employee {

    String name;
    double salary;

    // Parent class constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Parent class method
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: Rs. " + salary);
    }
}

class Manager extends Employee {

    String department;

    // Child class constructor
    Manager(String name, double salary, String department) {

        // Calling parent class constructor
        super(name, salary);

        this.department = department;
    }

    void displayManagerDetails() {

        System.out.println("\n----- Manager Details -----");

        // Accessing parent class variables
        System.out.println("Employee Name: " + super.name);
        System.out.println("Salary: Rs. " + super.salary);

        System.out.println("Department: " + department);

        System.out.println("\nEmployee Information:");
        
        // Calling parent class method
        super.displayDetails();
    }
}

public class EmployeeManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== EMPLOYEE MANAGEMENT SYSTEM =====");

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        Manager manager = new Manager(name, salary, department);

        manager.displayManagerDetails();

        sc.close();
    }
}