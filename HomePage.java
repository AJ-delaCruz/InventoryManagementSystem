package View;

import Controller.LoginMessage;
import Controller.Message;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

/**
 * HomePage Class
 * The starting page
 * before logging in
 * to Customer or Employee.
 */
public class HomePage extends JFrame {
    private BlockingQueue<Message> queue;

    /**
     * Constructor for the HomePage
     * @param queue a queue for adding in Messages
     */
    public HomePage(BlockingQueue<Message> queue)  {
        this.queue = queue;

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
            try {
                this.queue.put(new LoginMessage()); // <--- login to the queue
                setVisible(false);
                (new EmployeeLogin(queue)).setVisible(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        logInPanel.add(customerLogin);
        logInPanel.add(employeeLogin);

        JLabel signUpTitle = new JLabel("Sign up as:");
        JButton customerSignUp = new JButton("Customer");
        JButton employeeSignUp = new JButton("Employee");

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
        setVisible(true);
    }

    /**
     * Returns a new HomePage
     * @param queue queue list
     * @return new HomePage object
     */
    public static HomePage init(BlockingQueue<Message> queue) {
        return new HomePage(queue);
    }
}
