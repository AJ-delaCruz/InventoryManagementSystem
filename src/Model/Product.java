package Model;

public class Product {
    private String name;
    private String category;
    private double price;
    private int stock;
    private int invoiceNumber;
    private double tax;
    private boolean sale;
    private double discount;

    public Product(String name, String category, double price, int stock, int invoiceNumber) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.invoiceNumber = invoiceNumber;
        this.price = (tax * price) + price;
        this.tax = price;
        this.sale = sale;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getTax() {
        return tax;
    }

    public boolean isSale() {
        return sale;
    }

    public double getPrice() {
        return price;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
