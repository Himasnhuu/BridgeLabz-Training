package Week_01.FlowControl.Level3;

import java.util.Scanner;

// This program calculates BMI and determines weight status
public class BMICalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for weight in kg
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();
        
        // Taking user input for height in cm
        System.out.print("Enter height in cm: ");
        double heightCm = sc.nextDouble();
        
        // Convert cm to meter
        double heightM = heightCm / 100;
        
        // Calculate BMI using formula BMI = weight / (height * height)
        double bmi = weight / (heightM * heightM);
        
        // Determine weight status based on BMI value
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        // Display BMI and weight status
        System.out.printf("BMI: %.2f kg/m^2\n", bmi);
        System.out.println("Status: " + status);
        
        // Closing the Scanner class
        sc.close();
    }
}
