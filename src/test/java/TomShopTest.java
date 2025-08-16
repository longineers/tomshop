import model.Product;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TomShopTest {
    @Test
    public void returnsNoResultsWhenNoProductNameMatchSearch() throws Exception {
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
    public void itCanFindAnExistingAmongManyProducts() {
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
}
