package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program calculates sum of first n natural numbers using formula
public class NaturalNumberSum {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Check if the number is a natural number (positive integer)
        if (number > 0) {
            // Calculate sum using formula: n * (n + 1) / 2
            int sum = number * (number + 1) / 2;
            // Display the sum result
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
