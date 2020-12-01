package Model;
import java.util.ArrayList;

public class Order {
    ArrayList<Product> shoppingList;

    /**
     * The constructor for the Order class
     */
    public Order(){
        shoppingList = new ArrayList<>();
    }

    /**
     * Adds a product to the current
     * order.
     * @param item
     * @postcondition shoppingList.size() > 0
     */
    public void addProduct(Product item){
        shoppingList.add(item);
    }

    /**
     * Removes a current item in the
     * current order.
     * @param item
     * @precondition item must be on the order.
     * @return if the item has been removed.
     */
    public boolean removeProduct(Product item){
        if(shoppingList.contains(item)){
            return shoppingList.remove(item);
        }
        else{
            return false;
        }
    }

    /**
     * Returns the total price of
     * the order without tax.
     * @return total price without tax.
     */
    public double getTotalNoTax(){
        double total = 0;
        for (Product cost : shoppingList){
            total += cost.getPrice();
        }
        return total;
    }

    /**
     * Returns the total tax of
     * the order.
     * @return total tax of order
     */
    public double getTotalTax(){
        double totalTax = 0;
        for (Product cost : shoppingList){
            totalTax += cost.getTax();
        }
        return totalTax;
    }

    /**
     * Returns the total amount of
     * the order
     * @return total price of order
     */
    public double getTotal(){
        return getTotalNoTax() + getTotalTax();
    }

    /**
     * Returns each of the items
     * pricing in the list, total
     * price without tax, total tax,
     * and total price.
     * @return string of the order
     */
    @Override
    public String toString(){
        String orders = "";
        for (LineProduct item : shoppingList){
            orders += item.toString();
        }
        orders += "Total without tax: $" + getTotalNoTax() + "\n"
                + "Tax: $" + getTotalTax() + "\n"
                + "Total: $" + getTotal() + "\n";
        return orders;
    }
}

