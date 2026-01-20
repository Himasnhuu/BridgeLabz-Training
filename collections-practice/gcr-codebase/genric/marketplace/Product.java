package week4collections.javagenerics.marketplace;

/**
 * Generic product class where T is restricted to a category
 */
public class Product<T> {
    private String productId;
    private String name;
    private double basePrice;
    private T category;

    public Product(String productId, String name, double basePrice, T category) {
        this.productId = productId;
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public T getCategory() {
        return category;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Generic method to apply discounts dynamically
     */
    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid discount percentage");
            return;
        }
        double discountAmount = product.getBasePrice() * (percentage / 100);
        double newPrice = product.getBasePrice() - discountAmount;
        product.setBasePrice(newPrice);
        System.out.println("Discount of " + percentage + "% applied to " + product.getName() + 
                         ". New price: $" + String.format("%.2f", newPrice));
    }

    @Override
    public String toString() {
        return "Product [ID: " + productId + ", Name: " + name + 
               ", Price: $" + String.format("%.2f", basePrice) + 
               ", Category: " + category + "]";
    }
}
