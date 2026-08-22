import java.util.Scanner;

class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = 10000;

        try {
            System.out.println("----- ATM SYSTEM -----");
            System.out.println("Available Balance: Rs." + balance);

            System.out.print("Enter withdrawal amount: ");
            int amount = sc.nextInt();

            try {
                if (amount <= 0) {
                    throw new Exception("Withdrawal amount must be greater than zero.");
                }

                if (amount > balance) {
                    throw new Exception("Insufficient balance.");
                }

                if (amount % 100 != 0) {
                    throw new Exception("Amount must be in multiples of 100.");
                }

                balance = balance - amount;

                System.out.println("Withdrawal successful!");
                System.out.println("Withdrawn Amount: Rs." + amount);
                System.out.println("Remaining Balance: Rs." + balance);
            }

            catch (Exception e) {
                System.out.println("Transaction Error: " + e.getMessage());
            }
        }

        catch (java.util.InputMismatchException e) {
            System.out.println("Input Error: Please enter a valid numeric amount.");
        }

        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Thank you for using the ATM.");
    }
}