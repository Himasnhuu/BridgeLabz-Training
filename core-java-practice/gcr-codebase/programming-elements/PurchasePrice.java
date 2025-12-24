package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program calculates the total purchase price based on unit price and quantity
public class PurchasePrice {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for unit price and quantity
        System.out.print("Enter unit price: ");
        double unitPrice = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        // Calculate total purchase price
        double total = unitPrice * quantity;
        
        // Display the total purchase price
        System.out.println("The total purchase price is INR " + total + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
        
        // Closing the Scanner class
        sc.close();
    }
}
