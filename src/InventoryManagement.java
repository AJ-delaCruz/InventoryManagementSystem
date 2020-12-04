import Controller.*;
import View.*;
import Model.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


//main
public class InventoryManagement {

        private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        private static HomePage view;
        private static ArrayList<Product> model;

        public static void main(String[] args) {
            view = HomePage.init(queue);
            model = new ArrayList<Product>();
            Controller controller = new Controller(view, model, queue);

            controller.mainLoop();
            view.dispose();
            queue.clear();
        }

}
