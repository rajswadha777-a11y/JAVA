import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceCalculator extends JFrame implements ActionListener {

    JLabel balanceLabel, amountLabel, resultLabel;
    JTextField balanceField, amountField, resultField;
    JButton depositButton, withdrawButton, clearButton;

    BankBalanceCalculator() {

        setTitle("Bank Balance Calculator");
        setSize(550, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel titleLabel = new JLabel("BANK BALANCE CALCULATOR");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(120, 30, 350, 30);
        add(titleLabel);

        // Initial balance
        balanceLabel = new JLabel("Initial Balance:");
        balanceLabel.setBounds(60, 100, 150, 30);
        add(balanceLabel);

        balanceField = new JTextField();
        balanceField.setBounds(220, 100, 220, 30);
        add(balanceField);

        // Transaction amount
        amountLabel = new JLabel("Transaction Amount:");
        amountLabel.setBounds(60, 150, 150, 30);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(220, 150, 220, 30);
        add(amountField);

        // Updated balance
        resultLabel = new JLabel("Updated Balance:");
        resultLabel.setBounds(60, 200, 150, 30);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(220, 200, 220, 30);
        resultField.setEditable(false);
        add(resultField);

        // Deposit button
        depositButton = new JButton("Deposit");
        depositButton.setBounds(80, 280, 110, 40);
        depositButton.addActionListener(this);
        add(depositButton);

        // Withdrawal button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(210, 280, 110, 40);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        // Clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(340, 280, 100, 40);
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            double balance = Double.parseDouble(balanceField.getText());
            double amount = Double.parseDouble(amountField.getText());

            if (amount < 0) {

                JOptionPane.showMessageDialog(
                    this,
                    "Transaction amount cannot be negative.",
                    "Invalid Amount",
                    JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (e.getSource() == depositButton) {

                double updatedBalance = balance + amount;

                resultField.setText(String.valueOf(updatedBalance));

                JOptionPane.showMessageDialog(
                    this,
                    "Amount deposited successfully!\n" +
                    "Updated Balance: Rs." + updatedBalance,
                    "Deposit",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }

            else if (e.getSource() == withdrawButton) {

                if (amount > balance) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Insufficient balance!",
                        "Withdrawal Failed",
                        JOptionPane.ERROR_MESSAGE
                    );

                } else {

                    double updatedBalance = balance - amount;

                    resultField.setText(String.valueOf(updatedBalance));

                    JOptionPane.showMessageDialog(
                        this,
                        "Amount withdrawn successfully!\n" +
                        "Updated Balance: Rs." + updatedBalance,
                        "Withdrawal",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }

            else if (e.getSource() == clearButton) {

                balanceField.setText("");
                amountField.setText("");
                resultField.setText("");
            }

        }

        catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numeric values.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        new BankBalanceCalculator();
    }
}