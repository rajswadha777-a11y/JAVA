import java.util.Scanner;

// User-defined exception class
class InvalidDrivingAgeException extends Exception {

    InvalidDrivingAgeException(String message) {
        super(message);
    }
}

class DrivingLicenseSystem {

    static void checkLicenseEligibility(int age)
            throws InvalidDrivingAgeException {

        if (age < 18) {
            throw new InvalidDrivingAgeException(
                "You are not eligible for a driving license. Minimum age required is 18."
            );
        }

        System.out.println("You are eligible for a driving license.");
        System.out.println("You can apply for a driving license.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("      DRIVING LICENSE SYSTEM         ");
        System.out.println("====================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {

            System.out.println("\nChecking license eligibility...");

            checkLicenseEligibility(age);

        } catch (InvalidDrivingAgeException e) {

            System.out.println("License Eligibility Failed!");
            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("\nApplicant Name: " + name);
        System.out.println("License eligibility check completed.");

        sc.close();
    }
}