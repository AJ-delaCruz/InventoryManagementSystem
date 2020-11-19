package Model;

import java.util.ArrayList;

public class InventorySystem {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product newItem){
        products.add(newItem);
    }

    public void removeProduct(Product item){
        products.remove(item);
    }

    public boolean findProduct(Product find){
        return true;
    }
    public void addDiscount(Product invoiceNumber, double discount){
        for (Product invoice : products){
            if (invoice == invoiceNumber){
               invoice.setPrice(invoice.getPrice() * discount);
            }
        }
    }
    public void removeDiscount(Product invoiceNumber){
        for (Product invoice : products){
            if (invoice == invoiceNumber){
                invoice.setPrice(invoice.getPrice());
            }
        }
    }

    public int printStock (Product invoiceNumber) {
        int stock = 0;
        for (Product invoice : products) {
            if (invoice == invoiceNumber) {
                stock = invoice.getStock();
            }
        }
        return stock;
    }

    public String printCategories(){
        String categories = "";
        for (Product categ : products){
            categories += categ.getCategory();
        }
        return categories;
    }

    public String printDiscountedProduct(){
        String discounts = "";
        for (Product discountProduct : products){
            discounts += discountProduct.getName();
        }
        return discounts;
    }

    public String allProduct(){
        return "";
    }
}
