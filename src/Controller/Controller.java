package Controller;

import Model.Product;
import View.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Controller Class
 * Controls the messages and valves
 */
public class Controller {
    private BlockingQueue<Message> queue;
    private Product productModel; // Direct reference to model
    private Inventory inventoryView; //to test inventory
    private List<Valve> valves = new LinkedList<Valve>();

    /**
     * Constructor for the Controller class
     * @param inventoryView link to the Inventory
     * @param productModel link to the Product Model
     * @param queue a queue for adding in Messages
     */
    public Controller(Inventory inventoryView, Product productModel, BlockingQueue<Message> queue) {
        this.inventoryView = inventoryView;
        this.productModel = productModel;
        this.queue = queue;
        valves.add(new LoginValve());
        valves.add(new AddProductValve());
        valves.add(new ModifyStockValve());
    }

    /**
     * Takes a message from queue
     * and looks for a valve
     * that can process a message
     */
    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        Message message = null;
        while (response != ValveResponse.FINISH) {
            try {
                message = queue.take(); // <--- take next message from the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Look for a Valve that can process a message
            for (Valve valve : valves) {
                response = valve.execute(message);
                // if successfully processed,leave the loop
                if (response != ValveResponse.MISS) {
                    break;
                }
            }
        }
    }

    /**
     * Valve Interface
     * Valves for each message
     */
    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        ValveResponse execute(Message message);
    }

    /**
     * AddProductValve Class
     * Notifies if message is executed or not
     * if product is added
     */
    private class AddProductValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != AddProductMessage.class) {
                return ValveResponse.MISS;
            }
            AddProductMessage productMessage = (AddProductMessage) message;

            productModel.setName(productMessage.getName());
            productModel.setCategory(productMessage.getCategory());
            productModel.setPrice(productMessage.getPrice());
            productModel.setStock(productMessage.getStock());
            productModel.setInvoiceNumber(productMessage.getInvoiceNumber());

            inventoryView.updateInventory(productModel.getName(), productModel.getCategory(), productModel.getPrice(),
                    productModel.getStock(), productModel.getInvoiceNumber());

            return ValveResponse.EXECUTED;
        }
    }


    /**
     * ModifyStockValve class
     * Notifies if message is executed or not
     * when stock is modified
     */
    private class ModifyStockValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != ModifyStockMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of ModifyStockMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * LoginValve class
     * Notifies if message is executed or not
     * if logged in or not
     */
    private class LoginValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != LoginMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of LoginMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }
}

