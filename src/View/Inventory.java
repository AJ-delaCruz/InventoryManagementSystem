package View;

import Controller.AddProductMessage;
import Controller.Message;
import Model.InventorySystem;
import Model.LineProduct;
import Model.Product;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Inventory extends JFrame {
    BlockingQueue<Message> queue;

    public Inventory(/*BlockingQueue<Message> queue*/) {
        this.queue = queue;
        ProductList inventory = new ProductList();

        JPanel panel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel fieldPanel = new JPanel();
        JPanel bottomPanel = new JPanel();


        JLabel title = new JLabel("Products");
        title.setFont(new Font("", Font.BOLD, 15));
        titlePanel.add(title);


        //field
        JTextArea textArea = new JTextArea(20, 40);
        inventory.addChangeListener(event ->
                textArea.setText(inventory.formatProduct()));


        //adding
        JTextField field1 = new JTextField("Product Name", 20);
        JTextField field2 = new JTextField("Category", 20);
        JTextField field3 = new JTextField("Price", 20);
        JTextField field4 = new JTextField("Quantity", 20);
        JTextField field5 = new JTextField("Invoice Number", 20);
        JButton complete = new JButton("Complete");
        complete.addActionListener(event -> {
            ArrayList<LineProduct> product = new ArrayList<>();
            String name = field1.getText();
            String category = field2.getText();
            double price = Double.parseDouble(field3.getText());
            int stock = Integer.parseInt(field4.getText());
            int invoiceNumber = Integer.parseInt(field5.getText());
            product.add(new Product(name, category, price, stock, invoiceNumber));
            LineProduct x = new Product(name, category, price, stock, invoiceNumber);

            inventory.addProduct(x);
            try {
                //queue.put(new AddProductMessage(name, category, price, stock, invoiceNumber));
                addProduct(product);
                JOptionPane.showMessageDialog(Inventory.this, "Successful");
            } catch (IOException e)// | InterruptedException e)
            {
                JOptionPane.showMessageDialog(Inventory.this, "Unsuccessful",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }

        });

        fieldPanel.add(field1);
        fieldPanel.add(field2);
        fieldPanel.add(field3);
        fieldPanel.add(field4);
        fieldPanel.add(field5);
        fieldPanel.add(complete);


        add(titlePanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(fieldPanel);
        add(bottomPanel, BorderLayout.SOUTH);
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setLayout(new FlowLayout());
        //setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("List of Products");
        setSize(500, 600);

        //pack();
        setVisible(true);


    }



    public void addProduct(ArrayList<LineProduct> products) throws IOException {

        FileWriter appendFile = new FileWriter("products.txt", true);
        PrintWriter outputFile = new PrintWriter(appendFile); //object to write on a file

        for (LineProduct x : products) {
            outputFile.print(x.getName() + " ");
            outputFile.print(x.getCategory() + " ");
            outputFile.print(x.getPrice() + " ");
            outputFile.print(x.getStock() + " ");
            outputFile.println(x.getInvoiceNumber());
        }
        outputFile.close();

    }

    //implement to align with blocking queue controller
    public void updateInventory() {

    }


        public static void main(String[] args) {
        //test
       // Inventory l = new Inventory();
    }




/*
 public void updateNameInView(String value) {
            this.studentNameLabel.setText(value);
        }

        public void updateListOfClassesInView(ArrayList<String> classes) {
            this.allClassesLabel.setText(classes.toString());
        }

*/


}


