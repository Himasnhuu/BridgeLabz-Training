package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program prints FizzBuzz pattern using for loop
class FizzBuzz {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            // Print FizzBuzz pattern from 1 to number
            for (int i = 1; i <= number; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } 
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } 
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } 
                else {
                    System.out.println(i);
                }
            }
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
