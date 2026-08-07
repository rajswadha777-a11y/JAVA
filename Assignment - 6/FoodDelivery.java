import java.util.Scanner;

public class FoodDelivery {

    String customerName;
    String foodItem;
    int quantity;

    // Constructor
    FoodDelivery(String customerName, String foodItem, int quantity) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    // Inner Class
    class OrderDetails {

        void displayOrder() {
            System.out.println("\n----- Order Details -----");
            System.out.println("Customer Name : " + customerName);
            System.out.println("Food Item     : " + foodItem);
            System.out.println("Quantity      : " + quantity);
        }
    }

    // Interface
    interface DeliveryStatus {
        void updateStatus();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Food Item: ");
        String item = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        // Create FoodDelivery Object
        FoodDelivery order = new FoodDelivery(name, item, qty);

        // Create Inner Class Object
        OrderDetails details = order.new OrderDetails();

        // Display Order Details
        details.displayOrder();

        // Anonymous Class for Delivery Status
        DeliveryStatus status = new DeliveryStatus() {

            public void updateStatus() {
                System.out.println("\n----- Delivery Status -----");
                System.out.println("Order Confirmed");
                System.out.println("Food is Being Prepared");
                System.out.println("Out for Delivery");
                System.out.println("Order Delivered Successfully!");
            }
        };

        // Call Anonymous Class Method
        status.updateStatus();

        sc.close();
    }
}