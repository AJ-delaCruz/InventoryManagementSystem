package Model;

import java.util.ArrayList;

public class Order {
    ArrayList<Product> shoppingList = new ArrayList<>();

    public void addProduct(Product item){
        shoppingList.add(item);
    }

    public void removeProduct(Product item){
        shoppingList.remove(item);
    }

    public double getTotal(){
        double total = 0;
        for (Product cost : shoppingList){
            total += cost.getPrice();

        }
        return total;
    }

    public double getTotalTax(){
        double totalTax = 0;
        for (Product cost : shoppingList){
            totalTax += cost.getTax();
        }
        return totalTax;
    }



   public String printOrder(){
        String orders = "";
        for (Product order : shoppingList){
            //System.out.println("Name: "+ order.name + " price: $" + order.price);
           orders += "Name: "+ order.getName() + " price: $" + order.getPrice()+"\n";
        }
        return orders;
    }
}
