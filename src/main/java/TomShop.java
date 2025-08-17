import model.Product;
import service.CompareInterface;

import java.util.LinkedList;
import java.util.List;

public class TomShop {
    List<Product> products = new LinkedList<Product>();

    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> find(final String productName) {
        if (productName == null || productName.isEmpty()) {
            return this.products;
        }

        CompareInterface compare = product -> {
            return product.productName().toLowerCase().contains(productName.toLowerCase());
        };

        return getProducts(compare);
    }

    public List<Product> find(double price) {
        List<Product> matchedProducts = new LinkedList<Product>();
        CompareInterface compare = product -> {
            return product.price() == price;
        };

        return getProducts(compare);
    }

    public List<Product> find(double minPrice, double maxPrice) {
        List<Product> matchedProducts = new LinkedList<Product>();
        CompareInterface compare = product -> {
            return product.price() >= minPrice && product.price() <= maxPrice;
        };

        return getProducts(compare);
    }

    private List<Product> getProducts(CompareInterface compare) {
        List<Product> matchedProducts = new LinkedList<Product>();

        this.products.forEach((product -> {
            if (compare.test(product)) {
                matchedProducts.add(product);
            }
        }));

        return matchedProducts;
    }
}
