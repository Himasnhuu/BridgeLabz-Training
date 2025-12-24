package Week_01.ProgrammingElements.Level2;

import java.util.Scanner;

// This program performs various arithmetic operations on three double values
public class DoubleOperation {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for three double values
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();

        // Perform different arithmetic operations
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        // Display all results
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
        
        // Closing the Scanner class
        sc.close();
    }
}
