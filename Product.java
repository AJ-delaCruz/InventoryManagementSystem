package Model;

public class Product implements LineProduct {
    private String name;
    private String category;
    private double price;
    private int stock;
    private int invoiceNumber;
    private double tax;
    private boolean sale;
    private double discount;

    /**
     * Constructor for the Product class
     * @param name the product name
     * @param category the product category
     * @param price the product's price
     * @param stock the number of the product
     * @param invoiceNumber the ID number of product
     * @param sale if it is discounted
     */
    public Product(String name, String category,
                   double price, int stock,
                   int invoiceNumber, boolean sale) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.invoiceNumber = invoiceNumber;
        this.price = (tax * price) + price;
        this.tax = price;
        this.sale = sale;
    }

    /**
     * Returns the product name
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the the products
     * category.
     * @return products category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the total inventory
     * of the item in storage.
     * @return inventory in storage
     */
    public int getStock() {
        return stock;
    }

    /**
     * Returns the invoice number
     * of the product.
     * @return invoiceNumber
     */
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Returns the tax of the
     * product.
     * @return tax of product
     */
    public double getTax() {
        return tax;
    }

    /**
     * Returns the price of
     * the item.
     * @return price of item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns if the product is
     * on sale or not.
     * @return if the product is
     * on sale or not.
     */
    public boolean getSale(){
        return sale;
    }

    /**
     * Sets the amount of stock of
     * an item
     * @param stock the new stock
     * amount
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Sets a new invoice number
     * @param invoiceNumber the new invoice number
     */
    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Sets the the product to
     * be on sale or not
     * @param sale change in sale
     */
    public void setSale(boolean sale){
        this.sale = sale;
    }

    /**
     * Returns the name, price,
     * and tax of the product
     * @return info about product
     */
    @Override
    public String toString(){
        return "Name: " + getName() + "\n"
                + "Price: $" + getPrice() + "\n"
                +  "Tax: $" + getTax();
    }
}

