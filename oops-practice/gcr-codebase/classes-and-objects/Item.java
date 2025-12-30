// 4. Program to Track Inventory of Items
package week2.oops.classesAndObject;

public class Item {
    
    // attributes
    String itemCode;
    double price;
    String itemName;
    
    // method to display item details
    void displayItemDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }
    
    // method to calculate total cost for given quantity
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
    
    public static void main(String[] args) {
        
        // create first item
        Item item1 = new Item();
        item1.itemCode = "01AA";
        item1.price = 500.0;
        item1.itemName = "Water bottle";
        item1.displayItemDetails();
        
        // create second item
        Item item2 = new Item();
        item2.itemCode = "01BB";
        item2.price = 700.0;
        item2.itemName = "Rice";
        item2.displayItemDetails();
        
        // create third item
        Item item3 = new Item();
        item3.itemCode = "02AA";
        item3.price = 400.0;
        item3.itemName = "blackboard";
        item3.displayItemDetails();
        
        // example: calculate total cost
        System.out.println("\nTotal cost for 5 Water bottles: " + item1.calculateTotalCost(5));
    }
}
