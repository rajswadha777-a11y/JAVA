public class Restaurant {
     // Static variable to count total orders
    static int totalOrders = 0;

    // Dine-in Bill
    void bill(double amount) {
        totalOrders++;
        System.out.println("Dine-in Bill: Rs" + amount);
    }

    // Takeaway Bill
    void bill(double amount, double packingCharge) {
        totalOrders++;
        System.out.println("Takeaway Bill: Rs" + (amount + packingCharge));
    }

    // Delivery Bill
    void bill(double amount, double packingCharge, double deliveryCharge) {
        totalOrders++;
        System.out.println("Delivery Bill: Rs" + (amount + packingCharge + deliveryCharge));
    }

    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        r.bill(500);                  // Dine-in
        r.bill(500, 20);              // Takeaway
        r.bill(500, 20, 50);          // Delivery

        System.out.println("Total Orders: " + totalOrders);
    }
}
