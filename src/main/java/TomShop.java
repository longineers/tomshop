import model.Product;

import java.util.LinkedList;
import java.util.List;

public class TomShop {
    List<Product> products = new LinkedList<Product>();

    public List<Product> find(String productName) {
        if (productName == null || productName.isEmpty()) {
            return this.products;
        }

        List<Product> matchedProducts = new LinkedList<Product>();

        this.products.forEach((product -> {
            if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                matchedProducts.add(product);
            }
        }));

        return matchedProducts;
    }

    public void add(Product product) {
        this.products.add(product);
    }
}
