import java.util.Scanner;

class OnlineShopping {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String productName;
        double productPrice;
        int quantity;
        double totalAmount;

        System.out.println("====================================");
        System.out.println("       ONLINE SHOPPING SYSTEM        ");
        System.out.println("====================================");

        System.out.print("Enter product name: ");
        productName = sc.nextLine();

        System.out.print("Enter product price: ");
        productPrice = sc.nextDouble();

        System.out.print("Enter product quantity: ");
        quantity = sc.nextInt();

        try {
            if (quantity <= 0) {
                throw new Exception(
                    "Invalid product quantity! Quantity must be greater than zero."
                );
            }

            totalAmount = productPrice * quantity;

            System.out.println("\n---------- ORDER DETAILS ----------");
            System.out.println("Product Name   : " + productName);
            System.out.println("Product Price  : Rs." + productPrice);
            System.out.println("Quantity       : " + quantity);
            System.out.println("Total Amount   : Rs." + totalAmount);
            System.out.println("-----------------------------------");
            System.out.println("Order placed successfully!");

        } catch (Exception e) {

            System.out.println("\n---------- ERROR ----------");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please enter a valid product quantity.");
            System.out.println("---------------------------");
        }

        System.out.println("\nThank you for shopping with us!");
        sc.close();
    }
}