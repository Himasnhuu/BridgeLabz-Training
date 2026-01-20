package week4collections.javagenerics.marketplace;

/**
 * Gadget category with specific price range and warranty
 */
public class GadgetCategory {
    private String type;
    private int warrantyMonths;
    private double minPrice;
    private double maxPrice;

    public GadgetCategory(String type, int warrantyMonths, double minPrice, double maxPrice) {
        this.type = type;
        this.warrantyMonths = warrantyMonths;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getType() {
        return type;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    @Override
    public String toString() {
        return "Gadget (" + type + ", Warranty: " + warrantyMonths + " months, $" + 
               minPrice + "-$" + maxPrice + ")";
    }
}
