package practiceProblemDay1;

import java.util.Scanner;

// This program calculates the power of a number (base raised to exponent)
public class PowerCalculation {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for base and exponent
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter exponent: ");
        double exponent = sc.nextDouble();

        // Calculating power using Math.pow() method
        double result = Math.pow(base, exponent);
        System.out.println("Result = " + result);
        
        // Closing the Scanner class
        sc.close();
    }
}
