package Model;

public class DiscountProduct implements LineProduct{
    private LineProduct product;
    private double discount;

    /**
     * Constructor for the DiscountItem class
     * @param product to be discounted
     * @param discount the discount
     */
    public DiscountProduct(LineProduct product, double discount){
        this.product = product;
        this.discount = discount;
    }

    /**
     * Returns the new price of the
     * product with the discount
     * @return new price of product
     */
    @Override
    public double getPrice() {
        return product.getPrice() * (1 - discount/100);
    }

    /**
     * Return the discounted
     * product name.
     * @return product name
     */
    @Override
    public String getName() {
        return product.getName();
    }

    /**
     * Return the total inventory
     * of stock.
     * @return total stock
     */
    @Override
    public int getStock() {
        return product.getStock();
    }

    /**
     * Returns the category of
     * the product
     * @return
     */
    @Override
    public String getCategory() {
        return product.getCategory();
    }

    @Override
    public int getInvoiceNumber() {
        return 0;
    }

    /**
     * Returns the money saved
     * from the discount
     * @return money saved
     */
    public double moneySaved(){
        return product.getPrice() - getPrice();
    }

    /**
     * Returns the product info and
     * discount price.
     * @return product info and discount
     */
    @Override
    public String toString(){
        return product.toString() + " (Discount: " + discount + "%)";
    }
}

