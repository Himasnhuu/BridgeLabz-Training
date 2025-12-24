package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program calculates factorial of a number using for loop
public class FactorialFor {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        
        // Check for positive integer
        if (number < 0) {
            System.out.println("Please enter a positive integer");
        } else {
            // Initialize factorial variable
            long factorial = 1;
            
            // Calculate factorial using for loop
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            
            // Display the factorial result
            System.out.println("Factorial of " + number + " is " + factorial);
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
