package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program calculates sum of numbers until user enters 0
public class SumUntilZero {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Initialize total and number variables
        double total = 0.0;
        double number;
        
        // Taking user input for first number
        System.out.print("Enter a number (0 to stop): ");
        number = sc.nextDouble();
        
        // Continue adding numbers until user enters 0
        while (number != 0) {
            total += number;
            System.out.print("Enter a number (0 to stop): ");
            number = sc.nextDouble();
        }
        
        // Display total sum
        System.out.println("Total sum: " + total);
        
        // Closing the Scanner class
        sc.close();
    }
}
