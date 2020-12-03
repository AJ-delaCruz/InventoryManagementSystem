package View;

import Model.Customer;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerLogin extends JFrame {


    public CustomerLogin() {

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel title = new JLabel("Customer Log in");
        title.setFont(new Font("", Font.BOLD, 15));
        JLabel acc = new JLabel("Username");
        JLabel pwd = new JLabel("Password");
        JTextField accField = new JTextField(10);
        JTextField pwdField = new JTextField(10);
        JButton login = new JButton("Login");

        //login button
        login.addActionListener(event -> {
            int name = Integer.parseInt(accField.getText());
            String password = pwdField.getText();
            ArrayList<Customer> customers = load();

            for (Customer x : customers) {
                if (x.getAccount().equals(name) && x.getPassword().equals(password)) {
                    setVisible(false);
                    (new WelcomeFrame()).setVisible(true);

                } else JOptionPane.showMessageDialog(CustomerLogin.this, "Wrong username or password",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                break;
            }

        });


        panel1.add(acc);
        panel1.add(accField);
        panel2.add(pwd);
        panel2.add(pwdField);
        panel.add(title);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(login);
        // panel.setLayout(new GridLayout(2,2));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);
        setLayout(new FlowLayout());

        setVisible(true);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Customer");

    }

    public ArrayList<Customer> load() {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            File myFile = new File("employees.txt"); //reads file
            Scanner inputFile = new Scanner(myFile);

            /*int nameID;
            String pwd;*/
            while (inputFile.hasNextLine()) {

                String line = inputFile.nextLine();
                String[] splitLine = line.split(" ");

                String nameID;
                String pwd;
                nameID = splitLine[0];
                pwd = splitLine[1];
                customers.add(new Customer(nameID, pwd));

            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(CustomerLogin.this, "No file found",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        return customers;
    }

    public static void main(String[] args) {
        JFrame frame = new EmployeeLogin();


    }


}


//test for customer login. need a frame after logging in as a customer
class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        JLabel welcome = new JLabel("Welcome");
        add(welcome);
        setVisible(true);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome");
    }


}





