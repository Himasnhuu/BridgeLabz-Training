package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program compares sum of natural numbers using formula and for loop
public class NaturalSumForCompare {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        // Check if it's a natural number
        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number");
        } else {
            // Calculate using formula
            int formulaSum = n * (n + 1) / 2;
            
            // Calculate using for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            
            // Display results
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
            
            // Compare results
            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("Results do not match!");
            }
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
