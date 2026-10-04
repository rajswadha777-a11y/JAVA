import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {

    JTextField bookId, studentName, issueDate, returnDate;
    JTextArea output;
    Connection con;

    BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bookId = new JTextField(20);
        studentName = new JTextField(20);
        issueDate = new JTextField(20);
        returnDate = new JTextField(20);

        add(new JLabel("Book ID:"));
        add(bookId);

        add(new JLabel("Student Name:"));
        add(studentName);

        add(new JLabel("Issue Date (YYYY-MM-DD):"));
        add(issueDate);

        add(new JLabel("Return Date (YYYY-MM-DD):"));
        add(returnDate);

        JButton addRecord = new JButton("Add Record");
        JButton display = new JButton("Display Records");

        add(addRecord);
        add(display);

        output = new JTextArea(15, 40);
        add(new JScrollPane(output));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "root123"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Database Error: " + e.getMessage());
        }

        addRecord.addActionListener(e -> {

            try {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO book_issue VALUES (?, ?, ?, ?)"
                );

                ps.setInt(1, Integer.parseInt(bookId.getText()));
                ps.setString(2, studentName.getText());
                ps.setDate(3, Date.valueOf(issueDate.getText()));
                ps.setDate(4, Date.valueOf(returnDate.getText()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,
                    "Book issue record added successfully!");

                bookId.setText("");
                studentName.setText("");
                issueDate.setText("");
                returnDate.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
            }
        });

        display.addActionListener(e -> {

            try {
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM book_issue"
                );

                output.setText("===== BOOK ISSUE RECORDS =====\n\n");

                while (rs.next()) {
                    output.append(
                        "Book ID: " + rs.getInt("book_id") +
                        "\nStudent: " + rs.getString("student_name") +
                        "\nIssue Date: " + rs.getDate("issue_date") +
                        "\nReturn Date: " + rs.getDate("return_date") +
                        "\n-----------------------------\n"
                    );
                }

            } catch (Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookIssueTracking();
    }
}