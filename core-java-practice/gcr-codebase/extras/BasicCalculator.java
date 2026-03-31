package Week_01.javaMethods.extras;
import java.util.Scanner;

public class BasicCalculator {
    
    public static void main(String[] args) {
        
        System.out.println("BASIC CALCULATOR\n");
        
        Scanner sc = new Scanner(System.in);
        
        // take two numbers as input
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        // display menu
        displayMenu();
        
        // get operation choice
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();
        
        // perform operation
        performOperation(num1, num2, choice);
        
        sc.close();
    }
    
    // method to display calculator menu
    static void displayMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
    }
    
    // method to perform selected operation
    static void performOperation(double a, double b, int choice) {
        double result = 0;
        String operation = "";
        
        switch (choice) {
            case 1:
                result = add(a, b);
                operation = "Addition";
                break;
            case 2:
                result = subtract(a, b);
                operation = "Subtraction";
                break;
            case 3:
                result = multiply(a, b);
                operation = "Multiplication";
                break;
            case 4:
                if (b != 0) {
                    result = divide(a, b);
                    operation = "Division";
                } else {
                    System.out.println("\nError: Division by zero!");
                    return;
                }
                break;
            default:
                System.out.println("\nInvalid choice!");
                return;
        }
        
        // display result
        System.out.println("\n" + operation + " Result: " + result);
    }
    
    // method for addition
    static double add(double a, double b) {
        return a + b;
    }
    
    // method for subtraction
    static double subtract(double a, double b) {
        return a - b;
    }
    
    // method for multiplication
    static double multiply(double a, double b) {
        return a * b;
    }
    
    // method for division
    static double divide(double a, double b) {
        return a / b;
    }
}
