package Controller;

public class AddProductMessage implements Message {

    String name;
    String category;
    double price;
    int stock;
    int invoiceNumber;

    public AddProductMessage(String name, String category, double price, int stock, int invoiceNumber) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.invoiceNumber = invoiceNumber;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }
}
