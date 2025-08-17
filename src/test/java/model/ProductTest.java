package model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductTest {

    @Test
    public void itCanCreateAProductWithAName() {
        // Assemble
        String productName = "Test Product";

        // Act
        Product product = new Product(productName, 9.99);

        // Assert
        assertThat(product.productName(), is(productName));
    }

    @Test
    public void itHasAPrice() {
        // Assemble
        String productName = "Test Product";
        double price = 19.99;

        // Act
        Product product = new Product(productName, price);

        // Assert
        assertThat(product.productName(), is(productName));
        assertThat(product.price(), is(price));
    }
}
