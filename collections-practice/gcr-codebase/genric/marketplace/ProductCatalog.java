package week4collections.javagenerics.marketplace;

import java.util.ArrayList;
import java.util.List;

/**
 * Product catalog that ensures type safety while allowing multiple product categories
 */
public class ProductCatalog {
    private List<Product<?>> products;
    private String catalogName;

    public ProductCatalog(String catalogName) {
        this.catalogName = catalogName;
        this.products = new ArrayList<>();
    }

    public <T> void addProduct(Product<T> product) {
        products.add(product);
        System.out.println("Added product: " + product.getName() + " to catalog");
    }

    public List<Product<?>> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void displayCatalog() {
        System.out.println("\n=== " + catalogName + " ===");
        System.out.println("Total products: " + products.size());
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }

    public int getProductCount() {
        return products.size();
    }
}
