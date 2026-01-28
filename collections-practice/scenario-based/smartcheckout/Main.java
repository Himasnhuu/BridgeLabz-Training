package smartcheckout;

public class Main {
    public static void main(String[] args) {
        SmartCheckout checkout = new SmartCheckout();

        // Add items to inventory
        checkout.addItemToInventory("Milk", 3.50, 10);
        checkout.addItemToInventory("Bread", 2.00, 15);
        checkout.addItemToInventory("Eggs", 4.00, 8);
        checkout.addItemToInventory("Butter", 5.50, 5);

        // Create customers with their items
        Customer customer1 = new Customer("John");
        customer1.addItem("Milk");
        customer1.addItem("Bread");

        Customer customer2 = new Customer("Mary");
        customer2.addItem("Eggs");
        customer2.addItem("Butter");
        customer2.addItem("Milk");

        Customer customer3 = new Customer("Peter");
        customer3.addItem("Bread");
        customer3.addItem("Eggs");

        // Add customers to queue
        checkout.addCustomer(customer1);
        checkout.addCustomer(customer2);
        checkout.addCustomer(customer3);

        // Show queue
        checkout.showQueue();

        // Process customers
        checkout.processNextCustomer();
        checkout.processNextCustomer();

        // Show updated inventory
        checkout.showInventory();

        // Show remaining queue
        checkout.showQueue();

        // Process last customer
        checkout.processNextCustomer();
    }
}
