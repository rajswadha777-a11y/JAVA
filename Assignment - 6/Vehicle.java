import java.util.Scanner;

public class Vehicle {

    String brand;
    String model;
    int year;

    // Constructor
    Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Inner Class
    class VehicleDetails {

        void displayDetails() {
            System.out.println("\n----- Vehicle Details -----");
            System.out.println("Brand : " + brand);
            System.out.println("Model : " + model);
            System.out.println("Year  : " + year);
        }
    }

    // Interface for Anonymous Class
    interface Action {
        void performAction();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Vehicle Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Manufacturing Year: ");
        int year = sc.nextInt();

        // Create Vehicle Object
        Vehicle v = new Vehicle(brand, model, year);

        // Create Inner Class Object
        VehicleDetails details = v.new VehicleDetails();

        // Display Vehicle Details
        details.displayDetails();

        // Anonymous Class
        Action startVehicle = new Action() {

            @Override
            public void performAction() {
                System.out.println("\nVehicle is Starting...");
                System.out.println("Drive Safely!");
            }
        };

        // Call Anonymous Class Method
        startVehicle.performAction();

        sc.close();
    }
}