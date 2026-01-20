package week4collections.javagenerics.marketplace;

/**
 * Demo class for Dynamic Online Marketplace
 */
public class MarketplaceDemo {
    public static void main(String[] args) {
        // Create product catalog
        ProductCatalog catalog = new ProductCatalog("Online Marketplace");

        // Create different categories
        BookCategory fictionBooks = new BookCategory("Fiction", 10.0, 30.0);
        BookCategory techBooks = new BookCategory("Technology", 25.0, 80.0);
        ClothingCategory tshirts = new ClothingCategory("T-Shirt", "M", 15.0, 40.0);
        ClothingCategory jeans = new ClothingCategory("Jeans", "L", 30.0, 100.0);
        GadgetCategory smartphones = new GadgetCategory("Smartphone", 12, 300.0, 1500.0);
        GadgetCategory laptops = new GadgetCategory("Laptop", 24, 500.0, 3000.0);

        // Create products with different categories
        Product<BookCategory> book1 = new Product<>("B001", "The Great Adventure", 24.99, fictionBooks);
        Product<BookCategory> book2 = new Product<>("B002", "Java Programming", 49.99, techBooks);
        Product<ClothingCategory> clothing1 = new Product<>("C001", "Cotton T-Shirt", 19.99, tshirts);
        Product<ClothingCategory> clothing2 = new Product<>("C002", "Blue Jeans", 59.99, jeans);
        Product<GadgetCategory> gadget1 = new Product<>("G001", "SmartPhone X", 799.99, smartphones);
        Product<GadgetCategory> gadget2 = new Product<>("G002", "Laptop Pro", 1299.99, laptops);

        // Add products to catalog (type safety ensured)
        catalog.addProduct(book1);
        catalog.addProduct(book2);
        catalog.addProduct(clothing1);
        catalog.addProduct(clothing2);
        catalog.addProduct(gadget1);
        catalog.addProduct(gadget2);

        // Display catalog
        catalog.displayCatalog();

        // Apply discounts using generic method
        System.out.println("\n--- Applying Discounts ---");
        book1.applyDiscount(book1, 15.0);
        clothing1.applyDiscount(clothing1, 20.0);
        gadget1.applyDiscount(gadget1, 10.0);

        // Display updated catalog
        catalog.displayCatalog();
    }
}
