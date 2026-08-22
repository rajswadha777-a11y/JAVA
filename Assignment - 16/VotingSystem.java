import java.util.Scanner;

// User-defined exception class
class InvalidVotingAgeException extends Exception {

    InvalidVotingAgeException(String message) {
        super(message);
    }
}

// Main class
public class VotingSystem {

    // Method to check voting eligibility
    static void checkVotingEligibility(int age)
            throws InvalidVotingAgeException {

        if (age < 18) {
            throw new InvalidVotingAgeException(
                "You are not eligible to vote. Minimum age required is 18."
            );
        }

        System.out.println("You are eligible to vote.");
        System.out.println("You can cast your vote.");
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("          VOTING SYSTEM             ");
        System.out.println("====================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {

            System.out.println("\nChecking voting eligibility...");

            checkVotingEligibility(age);

        } catch (InvalidVotingAgeException e) {

            System.out.println("\nVoting Eligibility Failed!");
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nThank you, " + name + ".");
        System.out.println("Voting eligibility check completed.");

        sc.close();
    }
}