class Student {
    int rollNo;
    String name;

    // Default Constructor
    Student() {
        rollNo = 0;
        name = "Not Assigned";
    }

    // Parameterized Constructor
    Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    // Copy Constructor
    Student(Student s) {
        rollNo = s.rollNo;
        name = s.name;
    }

    // Method to display details
    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
    }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        // Default Constructor
        Student s1 = new Student();
       
        // Parameterized Constructor
        Student s2 = new Student(101, "Swadha");
       
        // Copy Constructor
        Student s3 = new Student(s2);
       
        System.out.println("Default Constructor");
        s1.display();
       
        System.out.println("\nParameterized Constructor");
        s2.display();
       
        System.out.println("\nCopy Constructor");
        s3.display();
    }
}