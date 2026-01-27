package finally_block;

import java.util.Scanner;

public class IntegerDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            
            // Perform division
            int result = num1 / num2;
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Cannot divide by zero");
        } finally {
            // Always executed regardless of exception
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
