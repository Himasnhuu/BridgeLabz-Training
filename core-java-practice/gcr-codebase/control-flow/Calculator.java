package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program performs basic arithmetic operations based on user input
public class Calculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Declare variables for two numbers and operator
        // Create two double variables named first and second and a String variable named op
        double first, second;
        String op;
        
        // Taking user input for first number
        // Get input values for all variables
        System.out.print("Enter first number: ");
        first = sc.nextDouble();
        
        // Taking user input for second number
        System.out.print("Enter second number: ");
        second = sc.nextDouble();
        
        // Taking user input for operator
        System.out.print("Enter operator (+, -, *, /): ");
        op = sc.next();
        
        // Based on the input value of the op, perform specific operations using the switch...case
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid Operator");
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
