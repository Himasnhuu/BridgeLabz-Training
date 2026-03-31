package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program checks if a number is a prime number
public class PrimeNumber {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Initialize flag to check if number is prime
        boolean isPrime = true;
        
        // Check if number is less than or equal to 1
        if (number <= 1) {
            isPrime = false;
        } else {
            // Check for factors from 2 to number/2
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        // Display result
        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
