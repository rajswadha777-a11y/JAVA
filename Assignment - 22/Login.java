import java.sql.*;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            Scanner sc = new Scanner(System.in);

            System.out.println("====================================");
            System.out.println("          LOGIN SYSTEM");
            System.out.println("====================================");

            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            System.out.println("\nVerifying login details...");

            PreparedStatement ps = con.prepareStatement(
                "SELECT username, password FROM login WHERE username = ? AND password = ?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                System.out.println("Welcome " + username + "!");
            } else {
                System.out.println("Login Failed!");
                System.out.println("Invalid username or password.");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}