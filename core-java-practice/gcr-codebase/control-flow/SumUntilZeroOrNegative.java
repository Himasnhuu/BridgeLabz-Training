package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program calculates sum of numbers until user enters 0 or negative number
public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Initialize total variable
        double total = 0.0;
        
        // Continue loop until user enters 0 or negative number
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = sc.nextDouble();
            
            // Break loop if number is 0 or negative
            if (number <= 0) {
                break;
            }
            
            // Add number to total
            total += number;
        }
        
        // Display total sum
        System.out.println("Total sum: " + total);
        
        // Closing the Scanner class
        sc.close();
    }
}
