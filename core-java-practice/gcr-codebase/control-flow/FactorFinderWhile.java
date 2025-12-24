package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program finds all factors of a number using while loop
class FactorFinderWhile {
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
            
            int counter = 1;
            
            // Find all factors using while loop
            while (counter <= number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
