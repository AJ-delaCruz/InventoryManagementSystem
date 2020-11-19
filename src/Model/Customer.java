package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private String account;
    private String password;
    ArrayList<Order> pastOrder = new ArrayList<>();

    public Customer(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void addOrder(Order item){
        pastOrder.add(item);
    }
    public String printPastOrders(){
        String pastOrders = "";
        for (Order orders : pastOrder){
            pastOrders += orders.printOrder();
        }
        return pastOrders;
    }

    public void updateOrder(Order paid){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(account, customer.account) &&
                Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, password);
    }
}
