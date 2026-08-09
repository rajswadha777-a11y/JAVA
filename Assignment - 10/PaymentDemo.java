abstract class Payment {

    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract void makePayment();

    void displayAmount() {
        System.out.println("Payment Amount: Rs. " + amount);
    }
}

class CreditCard extends Payment {

    CreditCard(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment made using Credit Card.");
    }
}

class UPI extends Payment {

    UPI(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment made using UPI.");
    }
}

public class PaymentDemo {

    public static void main(String[] args) {

        CreditCard card = new CreditCard(1500);
        card.displayAmount();
        card.makePayment();

        System.out.println();

        UPI upi = new UPI(1000);
        upi.displayAmount();
        upi.makePayment();
    }
}