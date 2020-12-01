package Model;

import java.util.ArrayList;

public class InventorySystem {
    ArrayList<LineProduct> products;

    /**
     * Constructor for the InventorySystem
     * class.
     */
    public InventorySystem(){
        products = new ArrayList<>();
    }

    /**
     * Adds a product to the products
     * ArrayList.
     * @param newItem new product
     */
    public void addProduct(Product newItem){
        products.add(newItem);
    }

    /**
     * Removes a product from
     * the products ArrayList
     * @param item to be removed
     * @precondition item must be on ArrayList
     * @return
     */
    public boolean removeProduct(Product item){
        if(products.contains(item)){
            return products.remove(item);
        }
        else{
            return false;
        }
    }

    /**
     * Converts the Product to
     * DiscountedItem.
     * @param invoiceNumber
     * @param discount product discount
     */
    public void addDiscount(Product invoiceNumber, double discount){
        for (LineProduct invoice : products){
            if (invoice == invoiceNumber){
                DiscountProduct discounted = new DiscountProduct(invoice, discount);
            }
        }
    }

    /**
     * Converts the DiscountedItem to
     * Product.
     * @param invoiceNumber
     */
    public void removeDiscount(LineProduct invoiceNumber){
        for (LineProduct invoice : products){
            if (invoice == invoiceNumber){
                Product revised = (Product) invoice;
            }
        }
    }

    /**
     * Prints the stock of a
     * product.
     * @param invoiceNumber
     * @return stock of product
     */
    public int printStock (Product invoiceNumber) {
        int stock = 0;
        for (LineProduct invoice : products) {
            if (invoice == invoiceNumber) {
                stock = invoice.getStock();
            }
        }
        return stock;
    }

    /**
     * Prints all the categories
     * to shop.
     * @return list of categories
     */
    public String printCategories(){
        String categories = "";
        for (LineProduct type : products){
            categories += type.getCategory();
        }
        return categories;
    }

    /**
     * Prints all the discounted items
     * to shop
     * @return discounted items
     */
    public String printDiscountedProduct(){
        String discounts = "";
        for (LineProduct discountProduct : products){
            if(discountProduct instanceof DiscountProduct){
                discounts += discountProduct.getName();
            }
        }
        return discounts;
    }

    /**
     * Returns all items in inventory
     * @return
     */
    public String allProduct(){
        String list = "";
        for (LineProduct items : products){
            list += items.getName();
        }
        return list;
    }
}
