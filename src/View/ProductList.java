package View;

import Model.LineProduct;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class ProductList
 * Implements Iterator Pattern.
 * Shows list of Products added
 */
public class ProductList {
    private ArrayList<LineProduct> products;
    private ArrayList<ChangeListener> listeners;

    /**
     * Constructor for the ProductList
     * Class.
     */
    public ProductList() {
        products = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    /**
     * Adds a product to the product list.
     * @param product the product to add
     */
    public void addProduct(LineProduct product) {
        products.add(product);
        // Notify all observers of the change to the product list
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(event);
    }

    /**
     * Adds a change listener to the Product list.
     * @param listener the change listener to add
     */
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    /**
     * Helper method.
     * Gets an iterator that iterates through the products.
     * @return an iterator for the products
     */
    private Iterator<LineProduct> getItems() {
        return new
                Iterator<>() {
                    public boolean hasNext() {
                        return current < products.size();
                    }
                    public LineProduct next() {
                        return products.get(current++);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    private int current = 0;
                };
    }

    /**
     * Returns a list of products
     * @return List of products
     */
    public String formatProduct() {
        String items = "";
        Iterator<LineProduct> iter = getItems();
        while (iter.hasNext())
            items += iter.next();
        return items;
    }

}
