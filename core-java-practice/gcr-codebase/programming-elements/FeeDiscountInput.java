package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program calculates the discount amount and final fee based on user input
public class FeeDiscountInput {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for fee and discount percentage
        System.out.print("Enter fee: ");
        double fee = sc.nextDouble();
        System.out.print("Enter discount percentage: ");
        double discountPercent = sc.nextDouble();

        // Calculate discount amount and final fee after discount
        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;

        // Display the discount amount and final discounted fee
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
        
        // Closing the Scanner class
        sc.close();
    }
}
