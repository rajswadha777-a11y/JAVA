import java.sql.*;

public class EmployeeRecords {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

            Statement stmt = con.createStatement();

            // INSERT
            String insertQuery =
                "INSERT INTO employee VALUES (101, 'Swadha', 'CSE', 50000)";
            stmt.executeUpdate(insertQuery);

            System.out.println("Employee record inserted successfully.");

            // UPDATE
            String updateQuery =
                "UPDATE employee SET salary = 55000 WHERE emp_id = 101";
            stmt.executeUpdate(updateQuery);

            System.out.println("Employee record updated successfully.");

            // DELETE
            String deleteQuery =
                "DELETE FROM employee WHERE emp_id = 101";
            stmt.executeUpdate(deleteQuery);

            System.out.println("Employee record deleted successfully.");

            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}