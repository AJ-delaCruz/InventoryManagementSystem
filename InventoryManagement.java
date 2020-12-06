import Controller.*;
import View.*;
import Model.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


//main
public class InventoryManagement {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        Inventory view = new Inventory(queue);
        view.setVisible(false);
        Product model = new Product();

        new EmployeeLogin(queue).setVisible(true);

        Controller controller = new Controller(view, model, queue);
        controller.mainLoop();

        // When everything is done, dispose of everything
        view.dispose();
        queue.clear();
    }
}
