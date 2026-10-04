import java.sql.*;
import java.util.Scanner;

public class HospitalLogin {
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
            System.out.println("       HOSPITAL STAFF LOGIN");
            System.out.println("====================================");

            System.out.print("Enter Login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            System.out.println("\nVerifying login details...");

            PreparedStatement ps = con.prepareStatement(
                "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?"
            );

            ps.setString(1, loginId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                System.out.println("Login Successful!");
                System.out.println("Welcome, " + role + "!");

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Doctor access granted.");
                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Nurse access granted.");
                }
            } else {
                System.out.println("Login Failed!");
                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access denied.");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}