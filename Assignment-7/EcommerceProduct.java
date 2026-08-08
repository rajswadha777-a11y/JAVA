import java.util.Scanner;

// Parent class
class Product {

    String name;
    double price;

    // Constructor
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Common method
    void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: Rs. " + price);
    }
}

// Interface
interface ProductOperations {

    void displayDetails();
    void calculateDiscount();
}

// Electronic class inherits Product and implements interface
class Electronic extends Product implements ProductOperations {

    String brand;

    Electronic(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public void displayDetails() {
        System.out.println("\n----- Electronic Product -----");
        displayProduct();
        System.out.println("Brand: " + brand);
    }

    public void calculateDiscount() {
        double discount = price * 0.10;
        double finalPrice = price - discount;

        System.out.println("Discount: Rs. " + discount);
        System.out.println("Final Price: Rs. " + finalPrice);
    }
}

// Clothing class inherits Product and implements interface
class Clothing extends Product implements ProductOperations {

    String size;

    Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public void displayDetails() {
        System.out.println("\n----- Clothing Product -----");
        displayProduct();
        System.out.println("Size: " + size);
    }

    public void calculateDiscount() {
        double discount = price * 0.15;
        double finalPrice = price - discount;

        System.out.println("Discount: Rs. " + discount);
        System.out.println("Final Price: Rs. " + finalPrice);
    }
}

// Grocery class inherits Product and implements interface
class Grocery extends Product implements ProductOperations {

    String expiryDate;

    Grocery(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public void displayDetails() {
        System.out.println("\n----- Grocery Product -----");
        displayProduct();
        System.out.println("Expiry Date: " + expiryDate);
    }

    public void calculateDiscount() {
        double discount = price * 0.05;
        double finalPrice = price - discount;

        System.out.println("Discount: Rs. " + discount);
        System.out.println("Final Price: Rs. " + finalPrice);
    }
}

// Main class
public class EcommerceProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== E-COMMERCE PRODUCT SYSTEM =====");

        // Electronic Product
        System.out.print("\nEnter Electronic Product Name: ");
        String electronicName = sc.nextLine();

        System.out.print("Enter Electronic Product Price: ");
        double electronicPrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        Electronic e = new Electronic(
                electronicName,
                electronicPrice,
                brand
        );

        e.displayDetails();
        e.calculateDiscount();

        // Clothing Product
        System.out.print("\nEnter Clothing Product Name: ");
        String clothingName = sc.nextLine();

        System.out.print("Enter Clothing Product Price: ");
        double clothingPrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Size: ");
        String size = sc.nextLine();

        Clothing c = new Clothing(
                clothingName,
                clothingPrice,
                size
        );

        c.displayDetails();
        c.calculateDiscount();

        // Grocery Product
        System.out.print("\nEnter Grocery Product Name: ");
        String groceryName = sc.nextLine();

        System.out.print("Enter Grocery Product Price: ");
        double groceryPrice = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Expiry Date: ");
        String expiryDate = sc.nextLine();

        Grocery g = new Grocery(
                groceryName,
                groceryPrice,
                expiryDate
        );

        g.displayDetails();
        g.calculateDiscount();

        sc.close();
    }
}