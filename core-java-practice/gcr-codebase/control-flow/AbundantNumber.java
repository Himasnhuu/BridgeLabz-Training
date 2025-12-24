package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program checks if a number is an abundant number
// A number is abundant if sum of its proper divisors is greater than the number
public class AbundantNumber {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Initialize sum to store sum of divisors
        int sum = 0;
        
        // Run a for loop from i = 1 to i < number
        for (int i = 1; i < number; i++) {
            // Inside the loop, check if number is divisible by i
            if (number % i == 0) {
                // If true, add i to sum
                sum = sum + i;
            }
        }
        
        // Check if sum is greater than number
        // Outside the loop Check if sum is greater than number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number");
        } else {
            System.out.println(number + " is Not an Abundant Number");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
