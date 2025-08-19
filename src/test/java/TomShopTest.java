import model.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TomShopTest {
    private TomShop tomShop;
    private Product rabbitTreat;
    private Product dogTreat;
    private Product catTreat;
    private Product catFood;

    @BeforeEach
    public void setUp() {
        // Assemble
        this.tomShop = new TomShop();
        rabbitTreat = new Product("Rabbit Treat", 10.80);
        this.tomShop.add(rabbitTreat);
        dogTreat = new Product("Dog Treat", 5.99);
        this.tomShop.add(dogTreat);
        catTreat = new Product("Cat Treat", 3.49);
        this.tomShop.add(catTreat);
        catFood = new Product("Cat Food", 12.99);
        this.tomShop.add(catFood);
    }


    @Test
    public void returnsNoResultsWhenNoProductNameMatchesSearch() {
        // Assemble

        // Act
        List<Product> products = tomShop.find("non-existence-product-name");

        // Assert
        assertEquals(0, products.size());
    }

    @Test
    public void itCanAddAProduct() {
        // Assemble

        // Act
        tomShop.add(new Product("A jolly product", 9));

        // Assert
        assertEquals(1, tomShop.find("A jolly product").size());
    }

    @Test
    public void itCanFindAnExistingProductAmongManyProducts() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("Dog Treat");

        // Assert
        assertEquals(1, searchResults.size(), 1);
        assertSame(searchResults.getFirst(), dogTreat);
    }

    @Test
    public void itCanFindProductsWithPartialProductNameMatches() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("Treat");

        // Assert
        assertEquals(3, searchResults.size());
        assertSame(rabbitTreat, searchResults.get(0));
        assertSame(dogTreat, searchResults.get(1));
        assertSame(catTreat, searchResults.get(2));
    }

    @Test
    public void itCanFindProductsWithEmptySearchString() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("");

        // Assert
        assertEquals(4, searchResults.size());
        assertSame(rabbitTreat, searchResults.get(0));
        assertSame(dogTreat, searchResults.get(1));
        assertSame(catTreat, searchResults.get(2));
        assertSame(catFood, searchResults.get(3));
    }

    @Test
    public void itCanFindProductsWithNullSearchString() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find(null);

        // Assert
        assertEquals(4, searchResults.size());
        assertSame(rabbitTreat, searchResults.get(0));
        assertSame(dogTreat, searchResults.get(1));
        assertSame(catTreat, searchResults.get(2));
        assertSame(catFood, searchResults.get(3));
    }

    @Test
    public void itCanFindProductsRegardlessOfCase() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("dog treat");

        // Assert
        assertEquals(1, searchResults.size());
        assertSame(dogTreat, searchResults.getFirst());
    }

    @Test
    public void itCanFindByPrice() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find(3.49);

        // Assert
        assertEquals(1, searchResults.size());
        assertSame(catTreat, searchResults.getFirst());
    }

    @Test
    public void itCanFindByPriceWithInARange() {
        // Assemble
        double minPrice = 1.00;
        double maxPrice = 11.00;

        // Act
        List<Product> searchResults = tomShop.find(minPrice, maxPrice);

        // Assert
        assertEquals(3, searchResults.size());
        assertSame(rabbitTreat, searchResults.getFirst());
    }
}
