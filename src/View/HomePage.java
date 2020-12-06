/*package View;

import Controller.LoginMessage;
import Controller.Message;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;


public class HomePage extends JFrame {
    private BlockingQueue<Message> queue;

    public static HomePage init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new HomePage(queue);
    }

    public HomePage(BlockingQueue<Message> queue)  {
        this.queue = queue;
        // TODO:
        // you should initalize JFrame and show it,
        // JFrame should be able to add Messages to queue
        // JFrame can be in a separate class or created JFrame with all the elements in this class
        // or you can make View a subclass of JFrame by extending it

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

//      employeeLogin.addActionListener(event -> {
//            setVisible(false);
//            (new EmployeeLogin(queue)).setVisible(true);
//        });
//

        //employee message
        employeeLogin.addActionListener(event -> {
            try {
                this.queue.put(new LoginMessage()); // <--- login to the queue
                setVisible(false);
                (new EmployeeLogin(queue)).setVisible(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    public void change() {
        // TODO: do all the updates and repaint
        //Homepage.repaint();
    }

    public void dispose() {
        // TODO: clear all the resources
        // for example, Homepage.dispose();
    }



    public static void main(String[] args) {
       // JFrame frame = new HomePage();



    }
}
*/