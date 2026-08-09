class BankAccount {

    final int accountNumber;
    String name;
    double balance;

    BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class BankAccountDisplay {

    public static void main(String[] args) {

        BankAccount account =
            new BankAccount(101, "Swadha", 25000);

        account.display();

        // account.accountNumber = 202;   // Error: final cannot be changed
    }
}