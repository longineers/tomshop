import model.Product;

import java.util.LinkedList;
import java.util.List;

public class TomShop {
    LinkedList<Product> products = new LinkedList<Product>();

    public List<Product> find(String productName) {
        LinkedList<Product> matchedProducts = new LinkedList<Product>();

        this.products.forEach((product -> {
            if (product.getProductName().equals(productName)) {
                matchedProducts.add(product);
            }
        }));

        return matchedProducts;
    }

    public void add(Product product) {
        this.products.add(product);
    }
}
