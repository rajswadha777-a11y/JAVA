import java.sql.*;

public class StudentRecords {
    public static void main(String[] args) {
        try {
            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            // Create statement
            Statement stmt = con.createStatement();

            // Execute SELECT query
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // Display records
            System.out.println("Student Records:");
            System.out.println("-------------------------------");

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Age: " + rs.getInt("age") +
                    ", Course: " + rs.getString("course")
                );
            }

            // Close connection
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}