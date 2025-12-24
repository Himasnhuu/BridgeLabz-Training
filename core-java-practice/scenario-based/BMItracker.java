/*
 * 2. Maya's BMI Fitness Tracker 🏃‍♀️
Maya, a fitness coach, wants to record the BMI of her clients.
● Ask for height and weight.
● Use formula BMI = weight / (height * height)
● Print category using if-else: Underweight, Normal, Overweight.
Use clear variable names and comments to maintain code hygiene.*/

package Week_01.scenarioBased;
import java.util.Scanner;

public class BMItracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // maya starts her fitness consultation session
        System.out.println("MAYA'S FITNESS TRACKER");
        System.out.println("Let's calculate your BMI!\n");
        
        // record client's physical measurements
        System.out.print("Enter your weight (in kg): ");
        double weight = sc.nextDouble();
        
        System.out.print("Enter your height (in meters): ");
        double height = sc.nextDouble();
        
        // calculate bmi using standard formula
        double bmi = weight / (height * height);
        
        // display calculated bmi to client
        System.out.println("\nYOUR BMI REPORT");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.printf("BMI: %.2f\n", bmi);
        
        // determine fitness category based on who guidelines
        String category;
        String advice;
        
        if (bmi < 18.5) {
            // client needs to gain weight
            category = "Underweight";
            advice = "You should focus on gaining healthy weight with proper nutrition.";
        } else if (bmi >= 18.5 && bmi < 25) {
            // client is in healthy range
            category = "Normal";
            advice = "Great! You are in a healthy weight range. Keep maintaining!";
        } else if (bmi >= 25 && bmi < 30) {
            // client needs to lose some weight
            category = "Overweight";
            advice = "Consider regular exercise and balanced diet to reach healthy weight.";
        } else {
            // client is obese - needs immediate attention
            category = "Obese";
            advice = "Please consult with a healthcare professional for a proper fitness plan.";
        }
        
        // maya shares fitness advice with client
        System.out.println("Category: " + category);
        System.out.println("Advice: " + advice);
        System.out.println("\n");
        
        System.out.println("Thank you for using Maya's Fitness Tracker!");
        
        sc.close();
    }
}
