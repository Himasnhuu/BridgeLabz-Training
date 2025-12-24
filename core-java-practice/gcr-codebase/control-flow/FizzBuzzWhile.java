package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program prints FizzBuzz pattern using while loop
class FizzBuzzWhile {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer!");
        } else {
            int i = 1;
            
            // Print FizzBuzz pattern using while loop
            while (i <= number) {
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
                i++;
            }
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
