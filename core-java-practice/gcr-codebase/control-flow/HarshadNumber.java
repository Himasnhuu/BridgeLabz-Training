package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program checks if a number is a Harshad number
// A Harshad number is divisible by the sum of its digits
public class HarshadNumber {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Store original number for later comparison
        int originalNumber = number;
        // Initialize sum to store sum of digits
        int sum = 0;
        
        // Create a while loop to access each digit of the number
        while (number != 0) {
            // Add each digit of the number to sum
            sum = sum + (number % 10);
            number = number / 10;
        }
        
        // Check if the original number is divisible by sum of digits
        // Check if the number is perfectly divisible by the sum
        if (sum != 0 && originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number");
        } else {
            System.out.println(originalNumber + " is Not a Harshad Number");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
