package Viewer;

import Model.Product;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class AddProduct extends JFrame {
    public AddProduct() {

        JPanel panel = new JPanel();
        JPanel fieldPanel = new JPanel();


        JLabel title = new JLabel("Add New Product");
        title.setFont(new Font("", Font.BOLD, 15));
        panel.add(title);

        JTextField field1 = new JTextField("Product Name", 20);
        JTextField field2 = new JTextField("Category", 20);
        JTextField field3 = new JTextField("Price", 20);
        JTextField field4 = new JTextField("Quantity", 20);
        JTextField field5 = new JTextField("Invoice Number", 20);
        JButton complete = new JButton("Complete");
        complete.addActionListener(event -> {
            ArrayList<Product> product = new ArrayList<>();
            String name = field1.getText();
            String category = field2.getText();
            double price = Double.parseDouble(field3.getText());
            int stock = Integer.parseInt(field4.getText());
            int invoiceNumber = Integer.parseInt(field5.getText());
            product.add(new Product(name, category, price, stock, invoiceNumber));
            try {
                addProduct(product);
                JOptionPane.showMessageDialog(AddProduct.this, "Successful");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(AddProduct.this, "Unsuccessful",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }

        });

        fieldPanel.add(field1);
        fieldPanel.add(field2);
        fieldPanel.add(field3);
        fieldPanel.add(field4);
        fieldPanel.add(field5);
        fieldPanel.add(complete);


        panel.add(fieldPanel);
        add(panel);
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setLayout(new FlowLayout());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add Product");
        setSize(500, 500);

        //pack();
        setVisible(true);

    }


    public void addProduct(ArrayList<Product> products) throws IOException {

        FileWriter appendFile = new FileWriter("products.txt", true);
        PrintWriter outputFile = new PrintWriter(appendFile); //object to write on a file

        for (Product x : products) {
            outputFile.print(x.getName() + " ");
            outputFile.print(x.getCategory() + " ");
            outputFile.print(x.getPrice() + " ");
            outputFile.print(x.getStock() + " ");
            outputFile.println(x.getInvoiceNumber());
        }
        outputFile.close();

    }

    public static void main(String[] args) {
        JFrame frame = new AddProduct();


    }
}
