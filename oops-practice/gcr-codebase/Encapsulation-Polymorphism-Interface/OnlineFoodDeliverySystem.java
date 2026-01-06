package week2.oops.encapsulation;

/*6. Online Food Delivery System
Description: Create an online food delivery system:
Define an abstract class FoodItem with fields like itemName, price, and quantity.
Add abstract methods calculateTotalPrice() and concrete methods like getItemDetails().
Extend it into classes VegItem and NonVegItem, overriding calculateTotalPrice() to include additional charges (e.g., for non-veg items).
Use an interface Discountable with methods applyDiscount() and getDiscountDetails().
Demonstrate encapsulation to restrict modifications to order details and use polymorphism to handle different types of food items in a single order-processing method.*/

// Interface Discountable
interface Discountable {
    void applyDiscount(double discountPercent);
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    private double discountAmount;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.discountAmount = 0;
    }
    
    public abstract double calculateTotalPrice();
    
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
    
    // Getters and Setters
    public String getItemName() {
        return itemName;
    }
    
    protected void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    protected void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getDiscountAmount() {
        return discountAmount;
    }
    
    protected void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - getDiscountAmount();
    }
    
    @Override
    public void applyDiscount(double discountPercent) {
        double total = getPrice() * getQuantity();
        setDiscountAmount(total * discountPercent / 100);
    }
    
    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: $" + getDiscountAmount();
    }
    
    @Override
    public void getItemDetails() {
        System.out.println("\n--- Veg Item ---");
        super.getItemDetails();
        System.out.println("Category: Vegetarian");
        if (getDiscountAmount() > 0) {
            System.out.println("Discount Applied: $" + getDiscountAmount());
        }
        System.out.println("Total: $" + calculateTotalPrice());
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_CHARGE = 2.0;
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() + NON_VEG_CHARGE) * getQuantity();
        return total - getDiscountAmount();
    }
    
    @Override
    public void applyDiscount(double discountPercent) {
        double total = (getPrice() + NON_VEG_CHARGE) * getQuantity();
        setDiscountAmount(total * discountPercent / 100);
    }
    
    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: $" + getDiscountAmount();
    }
    
    @Override
    public void getItemDetails() {
        System.out.println("\n--- Non-Veg Item ---");
        super.getItemDetails();
        System.out.println("Category: Non-Vegetarian");
        System.out.println("Additional Charge: $" + NON_VEG_CHARGE);
        if (getDiscountAmount() > 0) {
            System.out.println("Discount Applied: $" + getDiscountAmount());
        }
        System.out.println("Total: $" + calculateTotalPrice());
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    
    // Polymorphic method to process orders
    public static void processOrder(FoodItem[] items) {
        double orderTotal = 0;
        System.out.println("\n========== ORDER PROCESSING ==========");
        
        for (FoodItem item : items) {
            item.getItemDetails();
            orderTotal += item.calculateTotalPrice();
        }
        
        System.out.println("\n========== ORDER SUMMARY ==========");
        System.out.println("Order Total: $" + orderTotal);
        System.out.println("Delivery Fee: $5.0");
        System.out.println("Grand Total: $" + (orderTotal + 5.0));
    }
    
    public static void main(String[] args) {
        System.out.println("========== ONLINE FOOD DELIVERY SYSTEM ==========");
        
        // Create food items
        VegItem vegItem1 = new VegItem("Paneer Tikka", 12.99, 2);
        VegItem vegItem2 = new VegItem("Veg Biryani", 10.99, 1);
        NonVegItem nonVegItem1 = new NonVegItem("Chicken Curry", 15.99, 2);
        NonVegItem nonVegItem2 = new NonVegItem("Fish Fry", 18.99, 1);
        
        // Apply discounts
        vegItem1.applyDiscount(10);
        nonVegItem1.applyDiscount(5);
        
        // Create order array (Polymorphism)
        FoodItem[] order = {vegItem1, vegItem2, nonVegItem1, nonVegItem2};
        
        // Process order
        processOrder(order);
    }
}
