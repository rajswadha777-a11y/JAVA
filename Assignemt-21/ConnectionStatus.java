import java.sql.*;

public class ConnectionStatus {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            System.out.println("Database connected successfully!");
            System.out.println("Connection is active.");

            con.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}