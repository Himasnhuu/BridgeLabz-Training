package scenariobased;
import java.util.Scanner;

/*
 * 1. The Coffee Counter Chronicles ☕Ravi runs a café. Each customer orders different coffee types with quantities. 
 * Write a program that:
● Asks for coffee type (switch)
● Calculates total bill (price * quantity)
● Adds GST using arithmetic operators
Use while to continue for the next customer and break when "exit" is typed.*/

public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // cafe opens for business
        System.out.println("WELCOME TO RAVI'S CAFE");
        System.out.println("Menu: espresso, latte, cappuccino, mocha");
        System.out.println("Type 'exit' to close cafe");
        System.out.println();
        
        int totalCustomers = 0;
        double totalRevenue = 0;
        
        // serve customers throughout the day
        while(true) {
            // take order from customer
            System.out.print("Enter coffee type: ");
            String coffeeType = sc.nextLine().toLowerCase();
            
            // close cafe when shift ends
            if(coffeeType.equals("exit")) {
                break;
            }
            
            // take quantity order
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            
            double price = 0;
            
            // check menu and set price per cup
            switch(coffeeType) {
                case "espresso":
                    price = 80;
                    break;
                case "latte":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 100;
                    break;
                case "mocha":
                    price = 150;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    System.out.println();
                    continue;
            }
            
            // calculate customer's bill
            double subtotal = price * quantity;
            double gst = subtotal * 0.18; // 18% gst on food items
            double totalBill = subtotal + gst;
            
            // print receipt for customer
            System.out.println("\nBILL");
            System.out.println("Coffee: " + coffeeType);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per cup: Rs." + price);
            System.out.println("Subtotal: Rs." + subtotal);
            System.out.println("GST (18%): Rs." + gst);
            System.out.println("Total Bill: Rs." + totalBill);
            System.out.println("\n");
            
            // update daily sales
            totalCustomers++;
            totalRevenue += totalBill;
        }
        
        // end of day summary for ravi
        System.out.println("\nCAFE CLOSED");
        System.out.println("Total Customers Served: " + totalCustomers);
        System.out.println("Total Revenue: Rs." + totalRevenue);
        
        sc.close();
    }
}
