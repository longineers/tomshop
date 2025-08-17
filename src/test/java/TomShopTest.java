import model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TomShopTest {
    private TomShop tomShop;
    private Product rabbitTreat;
    private Product dogTreat;
    private Product catTreat;
    private Product catFood;

    @Before
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
        assertThat(products.size(), is(0));
    }

    @Test
    public void itCanAddAProduct() {
        // Assemble

        // Act
        tomShop.add(new Product("A jolly product", 9));

        // Assert
        assertThat(tomShop.find("A jolly product").size(), is(1));
    }

    @Test
    public void itCanFindAnExistingProductAmongManyProducts() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("Dog Treat");

        // Assert
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.getFirst(), is(dogTreat));
    }

    @Test
    public void itCanFindProductsWithPartialProductNameMatches() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("Treat");

        // Assert
        assertThat(searchResults.size(), is(3));
        assertThat(searchResults.get(0), is(rabbitTreat));
        assertThat(searchResults.get(1), is(dogTreat));
        assertThat(searchResults.get(2), is(catTreat));
    }

    @Test
    public void itCanFindProductsWithEmptySearchString() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("");

        // Assert
        assertThat(searchResults.size(), is(4));
        assertThat(searchResults.get(0), is(rabbitTreat));
        assertThat(searchResults.get(1), is(dogTreat));
        assertThat(searchResults.get(2), is(catTreat));
        assertThat(searchResults.get(3), is(catFood));
    }

    @Test
    public void itCanFindProductsWithNullSearchString() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find(null);

        // Assert
        assertThat(searchResults.size(), is(4));
        assertThat(searchResults.get(0), is(rabbitTreat));
        assertThat(searchResults.get(1), is(dogTreat));
        assertThat(searchResults.get(2), is(catTreat));
        assertThat(searchResults.get(3), is(catFood));
    }

    @Test
    public void itCanFindProductsRegardlessOfCase() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find("dog treat");

        // Assert
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.getFirst(), is(dogTreat));
    }

    @Test
    public void itCanFindByPrice() {
        // Assemble

        // Act
        List<Product> searchResults = tomShop.find(3.49);

        // Assert
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.getFirst(), is(catTreat));
    }

    @Test
    public void itCanFindByPriceWithInARange() {
        // Assemble
        double minPrice = 1.00;
        double maxPrice = 11.00;

        // Act
        List<Product> searchResults = tomShop.find(minPrice, maxPrice);

        // Assert
        assertThat(searchResults.size(), is(3));
        assertThat(searchResults.getFirst(), is(rabbitTreat));
    }
}
