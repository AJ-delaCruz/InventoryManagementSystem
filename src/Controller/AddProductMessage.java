package Controller;

/**
 * Class AddProductMessage
 * Message of adding product
 */
public class AddProductMessage implements Message {
    private String name;
    private String category;
    private double price;
    private int stock;
    private int invoiceNumber;

    /**
     * Constructor for the AddProductMessage
     * @param name product name
     * @param category product category
     * @param price product price
     * @param stock product stock number
     * @param invoiceNumber product invoice number
     */
    public AddProductMessage(String name, String category,
                             double price, int stock, int invoiceNumber) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Return the name of the
     * product.
     * @return name of product
     */
    public String getName() {
        return name;
    }

    /**
     * Return the product category
     * @return product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the product price
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the products stock
     * number.
     * @return the product stock number
     */
    public int getStock() {
        return stock;
    }

    /**
     * Returns the product invoice
     * number.
     * @return product invoice number
     */
    public int getInvoiceNumber() {
        return invoiceNumber;
    }
}
