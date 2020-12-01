package Model;

public interface LineProduct {
    /**
     * Return the price of a product
     * @return product price
     */
    double getPrice();

    String getName();

    int getStock();

    String getCategory();
}

