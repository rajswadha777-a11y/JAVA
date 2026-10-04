import java.sql.*;

public class StudentDatabaseConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            System.out.println("Database connected successfully!");

            Statement stmt = con.createStatement();

            System.out.println("Statement object created successfully.");
            System.out.println("JDBC connection is ready for SQL operations.");

            con.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}