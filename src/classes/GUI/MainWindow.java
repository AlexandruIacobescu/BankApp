package classes.GUI;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JButton viewAccountsButton;
    private JButton makeDepositButton;
    private JButton makeWithdrawalButton;
    private JButton closeAccountButton;

    public MainWindow() {
        setTitle("Bank Application - Client View");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        viewAccountsButton = new JButton("View Accounts");
        makeDepositButton = new JButton("Make Deposit");
        makeWithdrawalButton = new JButton("Make Withdrawal");
        closeAccountButton = new JButton("Close Account");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2));
        mainPanel.add(viewAccountsButton);
        mainPanel.add(makeDepositButton);
        mainPanel.add(makeWithdrawalButton);
        mainPanel.add(closeAccountButton);

        add(mainPanel);
    }
}