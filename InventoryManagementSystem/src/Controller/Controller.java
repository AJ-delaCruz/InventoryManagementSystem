package Controller;

import Model.Product;
import View.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    private BlockingQueue<Message> queue;
    //  private HomePage view; // first page
    private Product productModel; // Direct reference to model
    private Inventory inventoryView; //to test inventory
    private List<Valve> valves = new LinkedList<Valve>();


    public Controller(Inventory inventoryView, Product productModel, BlockingQueue<Message> queue) {
        this.inventoryView = inventoryView;
        this.productModel = productModel;
        this.queue = queue;
        valves.add(new LoginValve());
        valves.add(new AddProductValve());
        valves.add(new ModifyStockValve());
    }

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



    //valves
    //need valves for each message
    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        ValveResponse execute(Message message);
    }


    private class AddProductValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != AddProductMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise it means that it is a AddProductMessage message
            //implement
            // actions in Model
            // actions in View
            AddProductMessage productMessage = (AddProductMessage) message;
          /*  productModel.add(new Product(productMessage.getName(), productMessage.getCategory(),
                    productMessage.getPrice(), productMessage.getStock(),productMessage.getInvoiceNumber()));
*/
            productModel.setName(productMessage.getName());
            productModel.setCategory(productMessage.getCategory());
            productModel.setPrice(productMessage.getPrice());
            productModel.setStock(productMessage.getStock());
            productModel.setInvoiceNumber(productMessage.getInvoiceNumber());


            // update inventory
            inventoryView.updateInventory(productModel.getName(), productModel.getCategory(), productModel.getPrice(),
                    productModel.getStock(), productModel.getInvoiceNumber());

            return ValveResponse.EXECUTED;
        }
    }

    //maybe delete if don't have time
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

    //employee login
    private class LoginValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != LoginMessage.class) {
                return ValveResponse.MISS;
            }

            inventoryView.setVisible(true);

            return ValveResponse.EXECUTED;
        }
    }
}

