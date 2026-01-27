package exception_propagation;

import java.util.Scanner;

public class InterestCalculator {
    
    // Method that throws exception for invalid input
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        
        // Calculate simple interest
        return (amount * rate * years) / 100;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        
        System.out.print("Enter rate: ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter years: ");
        int years = scanner.nextInt();
        
        try {
            // Call method that may throw exception
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Interest: " + interest);
            
        } catch (IllegalArgumentException e) {
            // Handle exception thrown by calculateInterest
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
