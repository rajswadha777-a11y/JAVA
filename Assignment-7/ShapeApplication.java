import java.util.Scanner;

class Shape {

    String shapeName;

    Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    void displayShape() {
        System.out.println("Shape: " + shapeName);
    }
}

// Circle inherits Shape
class Circle extends Shape {

    double radius;

    Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Radius: " + radius);
        System.out.println("Area of Circle: " + area);
    }
}

// Rectangle inherits Shape
class Rectangle extends Shape {

    double length;
    double breadth;

    Rectangle(double length, double breadth) {
        super("Rectangle");
        this.length = length;
        this.breadth = breadth;
    }

    void calculateArea() {
        double area = length * breadth;
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Area of Rectangle: " + area);
    }
}

public class ShapeApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----- SHAPE APPLICATION -----");

        System.out.print("Enter radius of Circle: ");
        double radius = sc.nextDouble();

        Circle c = new Circle(radius);

        System.out.println("\nCircle Details");
        c.displayShape();
        c.calculateArea();

        System.out.print("\nEnter length of Rectangle: ");
        double length = sc.nextDouble();

        System.out.print("Enter breadth of Rectangle: ");
        double breadth = sc.nextDouble();

        Rectangle r = new Rectangle(length, breadth);

        System.out.println("\nRectangle Details");
        r.displayShape();
        r.calculateArea();

        sc.close();
    }
}