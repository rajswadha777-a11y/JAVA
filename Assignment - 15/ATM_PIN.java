import java.util.Scanner;

class ATM_PIN {

    static void verifyPIN(int pin) throws Exception {

        int correctPIN = 1234;

        if (pin != correctPIN) {
            throw new Exception("Invalid PIN! Please enter the correct PIN.");
        }

        System.out.println("PIN verified successfully!");
        System.out.println("You can proceed with your transaction.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("        ATM PIN VERIFICATION        ");
        System.out.println("====================================");

        System.out.print("Enter your 4-digit PIN: ");
        int pin = sc.nextInt();

        try {

            System.out.println("\nVerifying PIN...");

            verifyPIN(pin);

        } catch (Exception e) {

            System.out.println("PIN Verification Failed!");
            System.out.println("Error: " + e.getMessage());

        } finally {

            System.out.println("\n------------------------------------");
            System.out.println("PIN verification process completed.");
            System.out.println("------------------------------------");
        }

        sc.close();
    }
}