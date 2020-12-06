package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Customer{
    private String account;
    private String password;
    ArrayList<Order> pastOrder;

    /**
     * Constructor for the Customer
     * class
     * @param account users account name
     * @param password users password
     */
    public Customer(String account, String password) {
        this.account = account;
        this.password = password;
        pastOrder = new ArrayList<>();
    }

    /**
     * Returns the Customer login
     * name.
     * @return Customer account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Returns the Customer's login
     * password.
     * @return Customer login name.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Adds a paid order to the list
     * of customer's past orders.
     * @param paid
     * @postcondition pastOrder.size() > 0
     */
    public void updatePastOrders(Order paid){
        pastOrder.add(paid);
    }

    /**
     * Returns a string of past orders
     * that the customer has made.
     * @return list of past orders.
     */
    public String printPastOrders(){
        String pastOrders = "";
        for (Order orders : pastOrder){
            pastOrders += orders.toString();
        }
        return pastOrders;
    }

    /**
     * Compares an object with a Customer
     * object to see if they are the same.
     * @param o object being compared with.
     * @return if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(account, customer.account) &&
                Objects.equals(password, customer.password);
    }

    /**
     * Determines the priority of the Customer
     * by account and password.
     * @return the priority
     */
    @Override
    public int hashCode() {
        return Objects.hash(account, password);
    }


}

