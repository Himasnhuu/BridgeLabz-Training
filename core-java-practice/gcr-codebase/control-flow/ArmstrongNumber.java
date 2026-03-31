package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program checks if a number is an Armstrong number
// An Armstrong number is equal to the sum of cubes of its digits
public class ArmstrongNumber {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Store original number for later comparison
        int originalNumber = number;
        // Initialize sum to store sum of cubes
        int sum = 0;
        
        // Use while loop till the originalNumber is not equal to zero
        while (number != 0) {
            // Remove the last digit from number in each iteration
            int digit = number % 10;
            
            // Find the cube of the number and add it to the sum variable
            sum = sum + (digit * digit * digit);
            
            // Trim the number to remove the last digit of original number
            number = number / 10;
        }
        
        // Check if sum equals original number
        // Finally check if the sum and the original number. If same => an Armstrong number
        if (sum == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong Number");
        } else {
            System.out.println(originalNumber + " is not an Armstrong Number");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
