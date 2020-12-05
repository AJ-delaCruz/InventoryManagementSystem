package View;

import Controller.AddProductMessage;
import Controller.Message;
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
    JTextField field1;
    JTextField field2;
    JTextField field3;
    JTextField field4;
    JTextField field5;
    JButton complete;
    JTextArea textArea;
    ProductList inventory;
    LineProduct x;

 /*   public static Inventory init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new Inventory(queue);
    }
*/
    public Inventory(BlockingQueue<Message> queue) {
        this.queue = queue;
        inventory = new ProductList();

        JPanel panel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel fieldPanel = new JPanel();
        JPanel bottomPanel = new JPanel();


        JLabel title = new JLabel("Products");
        title.setFont(new Font("", Font.BOLD, 15));
        titlePanel.add(title);


        //field
        textArea = new JTextArea(20, 40);
        inventory.addChangeListener(event ->
                textArea.setText(inventory.formatProduct()));
       // inventory.addProduct(x);

       /* LineProduct x = new Product("das", "category", 1, 21, 12314);
        inventory.addProduct(x);*/

        //adding
        field1 = new JTextField("Product Name", 20);
        field2 = new JTextField("Category", 20);
        field3 = new JTextField("Price", 20);
        field4 = new JTextField("Stock", 20);
        field5 = new JTextField("InvoiceNumber", 20);
        complete = new JButton("Complete");

        //TODO make queue work with inventory
        complete.addActionListener(event -> {
            ArrayList<LineProduct> product = new ArrayList<>();
            String name = field1.getText();
            String category = field2.getText();
            double price = Double.parseDouble(field3.getText());
            int stock = Integer.parseInt(field4.getText());
            int invoiceNumber = Integer.parseInt(field5.getText());

            product.add(new Product(name, category, price, stock, invoiceNumber)); //for the text file
            LineProduct x = new Product(name, category, price, stock, invoiceNumber); //for the JtextArea

            inventory.addProduct(x);
            try {
               // queue.put(new AddProductMessage(name, category, price, stock, invoiceNumber));
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
 /*   public void updateInventory(String name, String category, double price, int stock, int invoiceNumber) {

        x = new Product(name, category, price, stock, invoiceNumber); //for the JtextArea
        inventory.addProduct(x);


    }*/


        public static void main(String[] args) {
        //test
     //  Inventory l = new Inventory();
    }




}


