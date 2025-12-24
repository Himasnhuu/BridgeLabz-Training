package Week_01.ProgrammingElements.Level2;

import java.util.Scanner;

// This program calculates the quotient and remainder when dividing two numbers
public class QuotientRemainder {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for two numbers
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        // Calculate quotient and remainder
        int quotient = number1 / number2;
        int remainder = number1 % number2;

        // Display the quotient and remainder
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + number1 + " and " + number2);
        
        // Closing the Scanner class
        sc.close();
    }
}
