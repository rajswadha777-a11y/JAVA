import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel titleLabel, nameLabel, rollLabel, courseLabel, genderLabel, emailLabel;
    JTextField nameField, rollField, emailField;
    JComboBox<String> courseBox;
    JRadioButton maleButton, femaleButton, otherButton;
    JButton registerButton, clearButton;
    ButtonGroup genderGroup;

    StudentRegistrationForm() {

        setTitle("Student Registration Form");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        titleLabel = new JLabel("STUDENT REGISTRATION FORM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(100, 30, 320, 30);
        add(titleLabel);

        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(50, 90, 120, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 90, 220, 30);
        add(nameField);

        rollLabel = new JLabel("Roll Number:");
        rollLabel.setBounds(50, 140, 120, 30);
        add(rollLabel);

        rollField = new JTextField();
        rollField.setBounds(180, 140, 220, 30);
        add(rollField);

        courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 190, 120, 30);
        add(courseLabel);

        String[] courses = {
            "Select Course",
            "Computer Science",
            "Information Technology",
            "Electronics",
            "Mechanical",
            "Civil"
        };

        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(180, 190, 220, 30);
        add(courseBox);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 240, 120, 30);
        add(genderLabel);

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(180, 240, 70, 30);

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(250, 240, 80, 30);

        otherButton = new JRadioButton("Other");
        otherButton.setBounds(330, 240, 70, 30);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        add(maleButton);
        add(femaleButton);
        add(otherButton);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 290, 120, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(180, 290, 220, 30);
        add(emailField);

        registerButton = new JButton("Register");
        registerButton.setBounds(130, 360, 100, 35);
        registerButton.addActionListener(this);
        add(registerButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(260, 360, 100, 35);
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerButton) {

            String name = nameField.getText();
            String roll = rollField.getText();
            String course = (String) courseBox.getSelectedItem();
            String email = emailField.getText();

            String gender = "";

            if (maleButton.isSelected()) {
                gender = "Male";
            } else if (femaleButton.isSelected()) {
                gender = "Female";
            } else if (otherButton.isSelected()) {
                gender = "Other";
            }

            if (name.isEmpty() || roll.isEmpty() ||
                email.isEmpty() || course.equals("Select Course") ||
                gender.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please fill all the details.",
                    "Registration Error",
                    JOptionPane.ERROR_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Student Registered Successfully!\n\n" +
                    "Name: " + name + "\n" +
                    "Roll Number: " + roll + "\n" +
                    "Course: " + course + "\n" +
                    "Gender: " + gender + "\n" +
                    "Email: " + email,
                    "Registration Details",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }

        } else if (e.getSource() == clearButton) {

            nameField.setText("");
            rollField.setText("");
            emailField.setText("");
            courseBox.setSelectedIndex(0);
            genderGroup.clearSelection();
        }
    }

    public static void main(String[] args) {

        new StudentRegistrationForm();
    }
}