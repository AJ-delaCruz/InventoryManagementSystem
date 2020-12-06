package View;

import Controller.Controller;
import Controller.Message;
import Model.Product;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;


public class HomePage extends JFrame {
    private BlockingQueue<Message> queue;

    public static HomePage init(BlockingQueue<Message> queue) {
        // Create object of type view
        return new HomePage(queue);
    }

    public HomePage(BlockingQueue<Message> queue)  {
        this.queue = queue;
        new EmployeeLogin(queue).setVisible(true);
    }

    public void change() {
        this.repaint();
    }

    public void dispose() {
        this.dispose();
    }
}
