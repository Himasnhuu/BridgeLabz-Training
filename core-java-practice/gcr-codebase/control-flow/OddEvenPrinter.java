package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program prints odd and even numbers from 1 to n
class OddEvenPrinter {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a natural number (positive integer)");
        } else {
            // Print odd and even numbers from 1 to number
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an even number");
                } else {
                    System.out.println(i + " is an odd number");
                }
            }
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
