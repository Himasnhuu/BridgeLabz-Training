package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program calculates power of a number using for loop
class PowerCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for base number
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();
        
        // Taking user input for power
        System.out.print("Enter the power: ");
        int power = sc.nextInt();
        
        if (power < 0) {
            System.out.println("Please enter a positive integer for power!");
        } else {
            long result = 1;
            
            // Calculate power using for loop
            for (int i = 1; i <= power; i++) {
                result = result * number;
            }
            
            System.out.println(number + " raised to the power " + power + " = " + result);
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
