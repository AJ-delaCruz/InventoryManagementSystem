package View;

import Controller.Message;
import Model.Employee;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class EmployeeLogin extends JFrame {
    private BlockingQueue<Message> queue;
    public static EmployeeLogin init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new EmployeeLogin(queue);
    }
    public EmployeeLogin(BlockingQueue<Message> queue) {
        this.queue = queue;
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel title = new JLabel("Employee Log in");
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
            ArrayList<Employee> employees = load();

            for (Employee x : employees) {
                if (x.getAccountNumber() == name && x.getPassword().equals(password)) {
                    setVisible(false);
                    (new Inventory(queue)).setVisible(true);

                } else JOptionPane.showMessageDialog(EmployeeLogin.this, "Wrong username or password",
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
        setTitle("Employee");
    }

    public ArrayList<Employee> load() {
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            File myFile = new File("employees.txt"); //reads file
            Scanner inputFile = new Scanner(myFile);

            /*int nameID;
            String pwd;*/
            while (inputFile.hasNextLine()) {

                String line = inputFile.nextLine();
                String[] splitLine = line.split(" ");

                int nameID;
                String pwd;
                nameID = Integer.parseInt(splitLine[0]);
                pwd = splitLine[1];
                employees.add(new Employee(nameID, pwd));

            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(EmployeeLogin.this, "No file found",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        //System.out.println(employees);
        return employees;
    }


    //test
    public static void main(String[] args) {
        //  JFrame frame = new EmployeeLogin();

    }


}

