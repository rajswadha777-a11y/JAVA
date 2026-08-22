import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeRegistrationForm extends JFrame implements ActionListener {

    JLabel titleLabel, idLabel, nameLabel, departmentLabel, salaryLabel;
    JTextField idField, nameField, salaryField;
    JComboBox<String> departmentBox;
    JButton submitButton, clearButton;

    EmployeeRegistrationForm() {

        setTitle("Employee Registration Form");
        setSize(500, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        titleLabel = new JLabel("EMPLOYEE REGISTRATION FORM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(90, 30, 350, 30);
        add(titleLabel);

        idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(50, 90, 130, 30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(190, 90, 220, 30);
        add(idField);

        nameLabel = new JLabel("Employee Name:");
        nameLabel.setBounds(50, 140, 130, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(190, 140, 220, 30);
        add(nameField);

        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(50, 190, 130, 30);
        add(departmentLabel);

        String[] departments = {
            "Select Department",
            "Human Resources",
            "Finance",
            "IT",
            "Marketing",
            "Sales"
        };

        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(190, 190, 220, 30);
        add(departmentBox);

        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(50, 240, 130, 30);
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(190, 240, 220, 30);
        add(salaryField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(130, 320, 100, 35);
        submitButton.addActionListener(this);
        add(submitButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(260, 320, 100, 35);
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            String id = idField.getText();
            String name = nameField.getText();
            String department = (String) departmentBox.getSelectedItem();
            String salary = salaryField.getText();

            if (id.isEmpty() || name.isEmpty() ||
                salary.isEmpty() ||
                department.equals("Select Department")) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter all employee details.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Employee Registered Successfully!\n\n" +
                    "Employee ID: " + id + "\n" +
                    "Employee Name: " + name + "\n" +
                    "Department: " + department + "\n" +
                    "Salary: Rs." + salary,
                    "Employee Details",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else if (e.getSource() == clearButton) {

            idField.setText("");
            nameField.setText("");
            salaryField.setText("");
            departmentBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {

        new EmployeeRegistrationForm();
    }
}