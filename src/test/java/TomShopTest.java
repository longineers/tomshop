import model.Product;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TomShopTest {
    @Test
    public void returnsNoResultsWhenNoProductNameMatchesSearch() throws Exception {
        // Assemble
        TomShop tomShop = new TomShop();

        // Act
        List<Product> products = tomShop.find("non-existence-product-name");

        // Assert
        assertThat(products.size(), is(0));
    }

    @Test
    public void itCanAddAProduct() {
        // Assemble
        TomShop tomShop = new TomShop();

        // Act
        tomShop.add(new Product("A jolly product"));

        // Assert
        assertThat(tomShop.find("A jolly product").size(), is(1));
    }

    @Test
    public void itCanFindAnExistingProductAmongManyProducts() {
        // Assemble
        TomShop tomShop = new TomShop();
        tomShop.add(new Product("Rabbit Treat"));
        tomShop.add(new Product("Dog Treat"));
        tomShop.add(new Product("Cat Treat"));

        // Act
        List<Product> searchResults = tomShop.find("Dog Treat");

        // Assert
        assertThat(searchResults.size(), is(1));
        String productName = searchResults.getFirst().getProductName();
        assertThat(productName, is("Dog Treat"));
    }

    @Test
    public void itCanFindProductsWithPartialProductNameMatches() {
        // Assemble
        TomShop tomShop = new TomShop();
        tomShop.add(new Product("Rabbit Treat"));
        tomShop.add(new Product("Dog Treat"));
        tomShop.add(new Product("Cat Treat"));
        tomShop.add(new Product("Cat Food"));

        // Act
        List<Product> searchResults = tomShop.find("Treat");

        // Assert
        assertThat(searchResults.size(), is(3));
        assertThat(searchResults.get(0).getProductName(), is("Rabbit Treat"));
        assertThat(searchResults.get(1).getProductName(), is("Dog Treat"));
        assertThat(searchResults.get(2).getProductName(), is("Cat Treat"));
    }

    @Test
    public void itCanFindProductsWithEmptySearchString() {
        // Assemble
        TomShop tomShop = new TomShop();
        tomShop.add(new Product("Rabbit Treat"));
        tomShop.add(new Product("Dog Treat"));
        tomShop.add(new Product("Cat Treat"));
        tomShop.add(new Product("Cat Food"));

        // Act
        List<Product> searchResults = tomShop.find("");

        // Assert
        assertThat(searchResults.size(), is(4));
        assertThat(searchResults.get(0).getProductName(), is("Rabbit Treat"));
        assertThat(searchResults.get(1).getProductName(), is("Dog Treat"));
        assertThat(searchResults.get(2).getProductName(), is("Cat Treat"));
        assertThat(searchResults.get(3).getProductName(), is("Cat Food"));
    }

    @Test
    public void itCanFindProductsWithNullSearchString() {
        // Assemble
        TomShop tomShop = new TomShop();
        tomShop.add(new Product("Rabbit Treat"));
        tomShop.add(new Product("Dog Treat"));
        tomShop.add(new Product("Cat Treat"));
        tomShop.add(new Product("Cat Food"));

        // Act
        List<Product> searchResults = tomShop.find(null);

        // Assert
        assertThat(searchResults.size(), is(4));
        assertThat(searchResults.get(0).getProductName(), is("Rabbit Treat"));
        assertThat(searchResults.get(1).getProductName(), is("Dog Treat"));
        assertThat(searchResults.get(2).getProductName(), is("Cat Treat"));
        assertThat(searchResults.get(3).getProductName(), is("Cat Food"));
    }

    @Test
    public void itCanFindProductsRegardlessOfCase() {
        // Assemble
        TomShop tomShop = new TomShop();
        tomShop.add(new Product("Rabbit Treat"));
        tomShop.add(new Product("Dog Treat"));
        tomShop.add(new Product("Cat Treat"));
        tomShop.add(new Product("Cat Food"));

        // Act
        List<Product> searchResults = tomShop.find("dog treat");

        // Assert
        assertThat(searchResults.size(), is(1));
        assertThat(searchResults.getFirst().getProductName(), is("Dog Treat"));
    }
}
