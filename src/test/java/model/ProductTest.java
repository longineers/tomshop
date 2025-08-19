package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void itCanCreateAProductWithAName() {
        // Assemble
        String productName = "Test Product";

        // Act
        Product product = new Product(productName, 9.99);

        // Assert
        assertEquals(productName, product.productName());
    }

    @Test
    public void itHasAPrice() {
        // Assemble
        String productName = "Test Product";
        double price = 19.99;

        // Act
        Product product = new Product(productName, price);

        // Assert
        assertEquals(productName, product.productName());
        assertEquals(price, product.price());
    }
}
