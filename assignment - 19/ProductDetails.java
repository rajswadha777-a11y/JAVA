import java.sql.*;

public class ProductDetails {
    public static void main(String[] args) {

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            // Create statement
            Statement stmt = con.createStatement();

            // Execute SELECT query
            ResultSet rs = stmt.executeQuery(
                "SELECT product_id, product_name, quantity, price FROM product"
            );

            // Display records
            System.out.println("Product Details:");
            System.out.println("------------------------------------------");

            while (rs.next()) {
                System.out.println(
                    "Product ID: " + rs.getInt("product_id") +
                    ", Product Name: " + rs.getString("product_name") +
                    ", Quantity: " + rs.getInt("quantity") +
                    ", Price: " + rs.getDouble("price")
                );
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}