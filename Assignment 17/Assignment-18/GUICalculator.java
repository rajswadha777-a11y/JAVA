import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICalculator extends JFrame implements ActionListener {

    JLabel num1Label, num2Label, resultLabel;
    JTextField num1Field, num2Field, resultField;
    JButton addButton, subtractButton, clearButton;

    GUICalculator() {

        setTitle("GUI Calculator");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("SIMPLE GUI CALCULATOR");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(120, 30, 300, 30);
        add(titleLabel);

        // First number
        num1Label = new JLabel("Enter First Number:");
        num1Label.setBounds(50, 90, 150, 30);
        add(num1Label);

        num1Field = new JTextField();
        num1Field.setBounds(210, 90, 200, 30);
        add(num1Field);

        // Second number
        num2Label = new JLabel("Enter Second Number:");
        num2Label.setBounds(50, 140, 150, 30);
        add(num2Label);

        num2Field = new JTextField();
        num2Field.setBounds(210, 140, 200, 30);
        add(num2Field);

        // Result
        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 190, 150, 30);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(210, 190, 200, 30);
        resultField.setEditable(false);
        add(resultField);

        // Addition button
        addButton = new JButton("Addition");
        addButton.setBounds(80, 260, 110, 35);
        addButton.addActionListener(this);
        add(addButton);

        // Subtraction button
        subtractButton = new JButton("Subtraction");
        subtractButton.setBounds(200, 260, 120, 35);
        subtractButton.addActionListener(this);
        add(subtractButton);

        // Clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(330, 260, 90, 35);
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == addButton) {

                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());

                double result = num1 + num2;

                resultField.setText(String.valueOf(result));

            }

            else if (e.getSource() == subtractButton) {

                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());

                double result = num1 - num2;

                resultField.setText(String.valueOf(result));

            }

            else if (e.getSource() == clearButton) {

                num1Field.setText("");
                num2Field.setText("");
                resultField.setText("");
            }

        }

        catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        new GUICalculator();
    }
}