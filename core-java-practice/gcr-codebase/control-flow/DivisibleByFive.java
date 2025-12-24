package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program checks if a number is divisible by 5
class DivisibleByFive {
    public static void main(String[] args) {

        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Take number from user
        System.out.println("Enter=");
        int number = sc.nextInt();

        // Check divisibility by 5
        boolean result = (number % 5 == 0);

        // Display the result
        System.out.println("Is the number " + number + " divisible by 5? " + result);

        // Closing the Scanner class
        sc.close();
    }
}

