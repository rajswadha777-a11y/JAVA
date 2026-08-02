public class Calculator {
     // Static variable to count calculations
    static int count = 0;

    // Method to add two integers
    int add(int a, int b) {
        count++;
        return a + b;
    }

    // Overloaded method to add two decimal numbers
    double add(double a, double b) {
        count++;
        return a + b;
    }

    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println("Addition of Integers: " + c.add(10, 20));

        System.out.println("Addition of Decimals: " + c.add(10.5, 20.7));

        System.out.println("Total Calculations: " + count);
    }
}