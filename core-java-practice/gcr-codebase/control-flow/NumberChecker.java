package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program checks if a number is positive, negative, or zero
public class NumberChecker {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Check if number is positive, negative, or zero
        if (number > 0) {
            System.out.println("positive");
        } else if (number < 0) {
            System.out.println("negative");
        } else {
            System.out.println("zero");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
