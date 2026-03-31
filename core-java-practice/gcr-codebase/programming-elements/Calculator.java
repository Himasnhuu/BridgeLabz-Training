package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program performs basic arithmetic operations on two numbers
public class Calculator {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for two numbers
        System.out.print("Enter first number: ");
        double n1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double n2 = sc.nextDouble();

        // Performing and displaying arithmetic operations
        System.out.println("Addition: " + (n1 + n2));
        System.out.println("Subtraction: " + (n1 - n2));
        System.out.println("Multiplication: " + (n1 * n2));
        System.out.println("Division: " + (n1 / n2));
        
        // Closing the Scanner class
        sc.close();
    }
}
