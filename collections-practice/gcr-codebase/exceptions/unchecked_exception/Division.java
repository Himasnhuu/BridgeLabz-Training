package unchecked_exception;

import java.util.Scanner;

public class Division {
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
            System.out.println("ArithmeticException");
        } catch (java.util.InputMismatchException e) {
            // Handle non-numeric input
            System.out.println("InputMismatchException");
        } finally {
            scanner.close();
        }
    }
}
