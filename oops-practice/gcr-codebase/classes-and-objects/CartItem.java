// 5. Program to Simulate a Shopping Cart
package week2.oops.classesAndObject;

public class CartItem {
    
    // attributes
    String itemName;
    double price;
    int quantity;
    
    // constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    // method to add item to cart (increase quantity)
    void addItem(int count) {
        quantity += count;
        System.out.println("Added " + count + " of " + itemName + " to the cart.");
    }
    
    // method to remove item from cart (decrease quantity)
    void removeItem(int count) {
        if (count <= quantity) {
            quantity -= count;
            System.out.println("Removed " + count + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove. Only " + quantity + " items available.");
        }
    }
    
    // method to display total cost
    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Total cost: $" + total);
    }
    
    // method to display cart item details
    void displayCartItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
    
    public static void main(String[] args) {
        
        // create cart item
        CartItem item = new CartItem("Laptop", 999.99, 1);
        item.displayCartItem();
        
        // add items
        item.addItem(2);
        
        // remove items
        item.removeItem(1);
        
        // display total cost
        item.displayTotalCost();
    }
}
