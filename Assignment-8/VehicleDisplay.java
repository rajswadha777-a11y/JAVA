import java.util.Scanner;

class Vehicle {

    String vehicleNumber;
    String vehicleModel;

    // Parent class constructor
    Vehicle(String vehicleNumber, String vehicleModel) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
    }

    // Parent class method
    void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Model: " + vehicleModel);
    }
}

// Child class
class CarInsurance extends Vehicle {

    double premium;

    CarInsurance(String vehicleNumber, String vehicleModel, double premium) {

        // Calling parent constructor
        super(vehicleNumber, vehicleModel);

        this.premium = premium;
    }

    void displayInsurance() {

        System.out.println("\n----- Car Insurance -----");

        // Accessing parent class variables
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Vehicle Model: " + super.vehicleModel);

        System.out.println("Insurance Premium: Rs. " + premium);

        System.out.println("\nVehicle Information:");

        // Calling parent class method
        super.displayVehicleInfo();
    }
}

// Child class
class BikeInsurance extends Vehicle {

    double premium;

    BikeInsurance(String vehicleNumber, String vehicleModel, double premium) {

        // Calling parent constructor
        super(vehicleNumber, vehicleModel);

        this.premium = premium;
    }

    void displayInsurance() {

        System.out.println("\n----- Bike Insurance -----");

        // Accessing parent class variables
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Vehicle Model: " + super.vehicleModel);

        System.out.println("Insurance Premium: Rs. " + premium);

        System.out.println("\nVehicle Information:");

        // Calling parent class method
        super.displayVehicleInfo();
    }
}

// Main class
public class VehicleDisplay {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== VEHICLE INSURANCE SYSTEM =====");

        // Car Insurance
        System.out.print("\nEnter Car Number: ");
        String carNumber = sc.nextLine();

        System.out.print("Enter Car Model: ");
        String carModel = sc.nextLine();

        System.out.print("Enter Car Insurance Premium: ");
        double carPremium = sc.nextDouble();
        sc.nextLine();

        CarInsurance car = new CarInsurance(
                carNumber,
                carModel,
                carPremium
        );

        car.displayInsurance();

        // Bike Insurance
        System.out.print("\nEnter Bike Number: ");
        String bikeNumber = sc.nextLine();

        System.out.print("Enter Bike Model: ");
        String bikeModel = sc.nextLine();

        System.out.print("Enter Bike Insurance Premium: ");
        double bikePremium = sc.nextDouble();

        BikeInsurance bike = new BikeInsurance(
                bikeNumber,
                bikeModel,
                bikePremium
        );

        bike.displayInsurance();

        sc.close();
    }
}