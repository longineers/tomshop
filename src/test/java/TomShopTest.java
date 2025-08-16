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
}
