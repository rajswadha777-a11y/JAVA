import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n===== STUDENT MANAGEMENT =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    // CREATE
                    case 1:
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        PreparedStatement insert = con.prepareStatement(
                            "INSERT INTO student_crud VALUES (?, ?, ?, ?)"
                        );

                        insert.setInt(1, roll);
                        insert.setString(2, name);
                        insert.setString(3, course);
                        insert.setDouble(4, marks);

                        insert.executeUpdate();

                        System.out.println("Student inserted successfully.");
                        break;

                    // READ
                    case 2:
                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery(
                            "SELECT * FROM student_crud"
                        );

                        System.out.println("\n===== STUDENT RECORDS =====");

                        while (rs.next()) {
                            System.out.println(
                                "Roll No: " + rs.getInt("roll_no") +
                                " | Name: " + rs.getString("name") +
                                " | Course: " + rs.getString("course") +
                                " | Marks: " + rs.getDouble("marks")
                            );
                        }

                        break;

                    // UPDATE
                    case 3:
                        System.out.print("Enter Roll No to update: ");
                        int updateRoll = sc.nextInt();

                        System.out.print("Enter new marks: ");
                        double newMarks = sc.nextDouble();

                        PreparedStatement update = con.prepareStatement(
                            "UPDATE student_crud SET marks = ? WHERE roll_no = ?"
                        );

                        update.setDouble(1, newMarks);
                        update.setInt(2, updateRoll);

                        int updated = update.executeUpdate();

                        if (updated > 0)
                            System.out.println("Student updated successfully.");
                        else
                            System.out.println("Student not found.");

                        break;

                    // DELETE
                    case 4:
                        System.out.print("Enter Roll No to delete: ");
                        int deleteRoll = sc.nextInt();

                        PreparedStatement delete = con.prepareStatement(
                            "DELETE FROM student_crud WHERE roll_no = ?"
                        );

                        delete.setInt(1, deleteRoll);

                        int deleted = delete.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Student deleted successfully.");
                        else
                            System.out.println("Student not found.");

                        break;

                    // EXIT
                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Program ended.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}