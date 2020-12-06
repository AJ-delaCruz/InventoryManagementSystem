package Model;

/**
 * LineProduct Interface
 * Defines a product
 */
public interface LineProduct {
    /**
     * Return the price of a product
     * @return product price
     */
    double getPrice();

    /**
     *  Return products name
     * @return products name
     */
    String getName();

    /**
     * Return products stock
     * @return products stock
     */
    int getStock();

    /**
     * Returns products category
     * @return products category
     */
    String getCategory();

    /**
     * Return products invoice number
     * @return products invoice number
     */
    int getInvoiceNumber();
}

