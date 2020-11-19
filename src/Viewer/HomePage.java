package Viewer;

import javax.swing.*;
import java.awt.*;


public class HomePage extends JFrame {

    public HomePage()  {


        JPanel panel = new JPanel();
        JPanel logInPanel = new JPanel();
        JPanel signUpPanel = new JPanel();
        JLabel title = new JLabel("Inventory Management System");
        title.setFont(new Font("", Font.BOLD, 15));

        JLabel logInTitle = new JLabel("Log in as:");
        JButton customerLogin = new JButton("Customer");
        customerLogin.addActionListener(event -> {
            setVisible(false);
            (new CustomerLogin()).setVisible(true);
        });

        JButton employeeLogin = new JButton("Employee");
        employeeLogin.addActionListener(event -> {
            setVisible(false);
            (new EmployeeLogin()).setVisible(true);
        });
        //logInPanel.add(logInTitle);
        logInPanel.add(customerLogin);
        logInPanel.add(employeeLogin);


        JLabel signUpTitle = new JLabel("Sign up as:");
        JButton customerSignUp = new JButton("Customer");
        JButton employeeSignUp = new JButton("Employee");
        //signUpPanel.add(signUpTitle);
        signUpPanel.add(customerSignUp);
        signUpPanel.add(employeeSignUp);

        panel.add(title);
        panel.add(logInTitle);
        panel.add(logInPanel);
        panel.add(signUpTitle);
        panel.add(signUpPanel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        setLayout(new FlowLayout());

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home Page");
        setSize(500, 500);

        //pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        JFrame frame = new HomePage();



    }
}
