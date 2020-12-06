package Model;

/**
 *  Class Product
 *  Represents a product
 */
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
     * Default Constructor
     */
    public Product() {
        this.name = null;
        this.category = null;
        this.price = 0;
        this.stock = 0;
        this.invoiceNumber = 0;
        this.tax = 0;
        this.sale = false;
        this.discount = 0;
    }

    /**
     * 2nd Constructor for the Product Class
     * @param name the product name
     * @param category the product category
     * @param price the product's price
     * @param stock the number of the product
     * @param invoiceNumber the ID number of product
     */
    public Product(String name, String category, double price, int stock, int invoiceNumber) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.invoiceNumber = invoiceNumber;
        this.tax = 0;
        this.sale = false;
        this.discount = 0;
    }

    /**
     * 3rd Constructor for the Product class
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
     * Sets the name of a product
     * @param name products new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets products category
     * @param category products new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the products price
     * @param price products new price
     */
    public void setPrice(double price) {
        this.price = price;
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
     * Returns product's discount
     * @return products discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets products discount
     * @param discount new discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Returns the name, price,
     * and tax of the product
     * @return info about product
     */
    @Override
    public String toString(){
        String productFormat = "Name              Category              Price            " +
                "Stock            Invoice number";
        return productFormat +"\n" +
                getName() + "               " +
                getCategory() +"                " + "$"+getPrice() + "             "+
                getStock() + "                 " + getInvoiceNumber()+"\n";
    }
}
