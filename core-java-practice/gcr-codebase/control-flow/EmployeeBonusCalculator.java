package Week_01.FlowControl.Level2;

import java.util.Scanner;

// This program calculates employee bonus based on years of service
class EmployeeBonusCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for employee salary
        System.out.print("Enter employee salary: ");
        double salary = sc.nextDouble();
        
        // Taking user input for years of service
        System.out.print("Enter years of service: ");
        int yearsOfService = sc.nextInt();
        
        final double BONUS_PERCENTAGE = 5.0;
        double bonusAmount = 0.0;
        
        // Check if employee has more than 5 years of service
        if (yearsOfService > 5) {
            bonusAmount = (salary * BONUS_PERCENTAGE) / 100;
            System.out.println("Employee is eligible for bonus!");
        } else {
            System.out.println("Employee is not eligible for bonus.");
        }
        
        System.out.println("Bonus amount: " + bonusAmount);
        
        // Closing the Scanner class
        sc.close();
    }
}
