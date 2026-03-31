package Week_01.FlowControl.Level1;

import java.util.Scanner;

// This program calculates bonus for employees based on years of service
public class EmployeeBonus {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for salary
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        
        // Taking user input for years of service
        System.out.print("Enter years of service: ");
        int yearsOfService = sc.nextInt();
        
        // Initialize bonus amount
        double bonus = 0.0;
        
        // Check if employee has more than 5 years of service
        if (yearsOfService > 5) {
            // Calculate 5% bonus
            bonus = salary * 0.05;
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("Bonus amount: " + bonus);
        }
        
        // Closing the Scanner class
        sc.close();
    }
}
