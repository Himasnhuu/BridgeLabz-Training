package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program generates multiplication table of a number from 6 to 9
class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        final int START_MULTIPLIER = 6;
        final int END_MULTIPLIER = 9;
        
        System.out.println("\nMultiplication table of " + number + " from " + 
                          START_MULTIPLIER + " to " + END_MULTIPLIER + ":");
        
        // Generate multiplication table from 6 to 9
        for (int i = START_MULTIPLIER; i <= END_MULTIPLIER; i++) {
            int result = number * i;
            System.out.println(number + " * " + i + " = " + result);
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
