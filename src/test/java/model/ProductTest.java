package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void itWillThrowAnIllegalArgumentExceptionWhenProductNameAndPriceAreMissing() throws IllegalArgumentException {
        // Assemble
        String productName = null;
        double price = 0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Product(productName, price);
        });
    }
}
