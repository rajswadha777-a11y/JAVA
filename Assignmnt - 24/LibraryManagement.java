import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LibraryManagement extends JFrame {

    JTextField bookId, bookName, author, quantity;
    JTextArea output;

    Connection con;

    LibraryManagement() {

        setTitle("Library Management System");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Book ID:");
        bookId = new JTextField(20);

        JLabel l2 = new JLabel("Book Name:");
        bookName = new JTextField(20);

        JLabel l3 = new JLabel("Author:");
        author = new JTextField(20);

        JLabel l4 = new JLabel("Quantity:");
        quantity = new JTextField(20);

        JButton add = new JButton("Add Book");
        JButton display = new JButton("Display Books");

        output = new JTextArea(15, 40);

        add(l1);
        add(bookId);
        add(l2);
        add(bookName);
        add(l3);
        add(author);
        add(l4);
        add(quantity);
        add(add);
        add(display);
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

        add.addActionListener(e -> {

            try {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO library VALUES (?, ?, ?, ?)"
                );

                ps.setInt(1, Integer.parseInt(bookId.getText()));
                ps.setString(2, bookName.getText());
                ps.setString(3, author.getText());
                ps.setInt(4, Integer.parseInt(quantity.getText()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,
                    "Book added successfully!");

                bookId.setText("");
                bookName.setText("");
                author.setText("");
                quantity.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage());
            }
        });

        display.addActionListener(e -> {

            try {
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM library"
                );

                output.setText("===== LIBRARY RECORDS =====\n\n");

                while (rs.next()) {
                    output.append(
                        "Book ID: " + rs.getInt("book_id") +
                        "\nBook Name: " + rs.getString("book_name") +
                        "\nAuthor: " + rs.getString("author") +
                        "\nQuantity: " + rs.getInt("quantity") +
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
        new LibraryManagement();
    }
}