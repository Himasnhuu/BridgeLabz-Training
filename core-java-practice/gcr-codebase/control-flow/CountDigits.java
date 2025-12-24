package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program counts the number of digits in an integer
public class CountDigits {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        
        // Convert negative numbers to positive
        // Handle negative numbers
        number = Math.abs(number);
        
        // Initialize count variable
        // Create an integer variable count with value 0
        int count = 0;
        
        // Special case for 0
        if (number == 0) {
            count = 1;
        } else {
            // Use a loop to iterate until number is not equal to 0
            while (number != 0) {
                // Remove the last digit from number in each iteration
                number = number / 10;
                // Increase count by 1 in each iteration
                count++;
            }
        }
        
        // Display the number of digits
        // Finally display the count to show the number of digits
        System.out.println("Number of digits: " + count);
        
        // Closing the Scanner class
        sc.close();
    }
}
