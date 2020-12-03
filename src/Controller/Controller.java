package Controller;

import Model.Product;
import View.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    private BlockingQueue<Message> queue;
    private HomePage view; // Direct reference to view
    private Product model; // Direct reference to model
    private EmployeeInfo employeeInfo; // Direct reference to the state of employee page

    private List<Valve> valves = new LinkedList<Valve>();

    public Controller(HomePage view, Product model, BlockingQueue<Message> queue) {
        this.view = view;
        this.model = model;
        this.queue = queue;
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

    private void updateEmployeeInfo() {

    }



    //valves
    //need valves for each message
    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        public ValveResponse execute(Message message);
    }

    private class AddProductValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != AddProductMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise it means that it is a AddProductMessage message
            // actions in Model
            // actions in View
            return ValveResponse.EXECUTED;
        }
    }

    private class ModifyStockValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != ModifyStockMessage.class) {
                return ValveResponse.MISS;
            }
            // otherwise message is of HitMessage type
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
            // otherwise message is of HitMessage type
            // actions in Model and View
            return ValveResponse.EXECUTED;
        }
    }
}
