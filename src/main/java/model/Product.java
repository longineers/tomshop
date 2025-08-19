package model;

public class Product {
    private final String productName;
    private final double price;

    public Product(String productName, double price) throws IllegalArgumentException {
        if (productName == null || productName.isEmpty() || price <= 0) {
            throw new IllegalArgumentException("Product name cannot be null or empty and price must be greater than zero.");
        }

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
