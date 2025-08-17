package model;

public class Product {
    private final String productName;
    private final double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String productName() {
        return this.productName;
    }

    public double price() {
        return this.price;
    }
}
