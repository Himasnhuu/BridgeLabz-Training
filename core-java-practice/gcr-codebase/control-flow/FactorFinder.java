package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program finds all factors of a number using for loop
class FactorFinder {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            System.out.println("Factors of " + number + " are:");
            
            // Find all factors from 1 to number
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                }
            }
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
