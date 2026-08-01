public class Mobile {
    String brand;
    int price;

    // Default Constructor
    Mobile() {
        brand = "Samsung";
        price = 15000;
    }

    // Parameterized Constructor
    Mobile(String b, int p) {
        brand = b;
        price = p;
    }

    // Copy Constructor
    Mobile(Mobile m) {
        brand = m.brand;
        price = m.price;
    }

    // Display Method
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        // Default Constructor
        Mobile m1 = new Mobile();

        // Parameterized Constructor
        Mobile m2 = new Mobile("Apple", 85000);

        // Copy Constructor
        Mobile m3 = new Mobile(m2);

        System.out.println("Default Constructor");
        m1.display();

        System.out.println();

        System.out.println("Parameterized Constructor");
        m2.display();

        System.out.println();

        System.out.println("Copy Constructor");
        m3.display();
    }
}