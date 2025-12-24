package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program calculates factorial of a number using while loop
public class FactorialWhile {
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
            // Initialize factorial and counter variables
            long factorial = 1;
            int i = 1;
            
            // Calculate factorial using while loop
            while (i <= number) {
                factorial *= i;
                i++;
            }
            
            // Display the factorial result
            System.out.println("Factorial of " + number + " is " + factorial);
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
