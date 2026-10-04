import java.sql.*;

public class EmployeeResultSet {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT emp_id, emp_name, department, salary FROM employee"
            );

            System.out.println("===== EMPLOYEE RECORDS =====");

            while (rs.next()) {
                System.out.println(
                    "Employee ID: " + rs.getInt("emp_id") +
                    " | Name: " + rs.getString("emp_name") +
                    " | Department: " + rs.getString("department") +
                    " | Salary: " + rs.getDouble("salary")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}