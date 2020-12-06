import Controller.*;
import View.*;
import Model.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class Inventory Management
 * Class that starts the program
 */
public class InventoryManagement {
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
    private static Inventory view;
    private static Product model;

    public static void main(String[] args) {
        view = new Inventory(queue);
        model = new Product();
        Controller controller = new Controller(view, model, queue);
        controller.mainLoop();
        view.dispose();
        queue.clear();
    }

}
