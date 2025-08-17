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
            if (product.productName().toLowerCase().contains(productName.toLowerCase())) {
                matchedProducts.add(product);
            }
        }));

        return matchedProducts;
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> find(double price) {
        List<Product> matchedProducts = new LinkedList<Product>();

        this.products.forEach((product -> {
            if (price == product.price()) {
                matchedProducts.add(product);
            }
        }));

        return matchedProducts;
    }

    public List<Product> find(double minPrice, double maxPrice) {
        List<Product> matchedProducts = new LinkedList<Product>();

        this.products.forEach((product -> {
            if (product.price() >= minPrice && product.price() <= maxPrice) {
                matchedProducts.add(product);
            }
        }));

        return matchedProducts;
    }
}
