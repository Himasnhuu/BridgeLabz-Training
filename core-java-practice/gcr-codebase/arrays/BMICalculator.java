package Week_01.arrays.level2;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // a. Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = sc.nextInt();
        
        // b. Create arrays to store weight, height, BMI, and weight status
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];
        
        // c. Take input for weight and height of the persons
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            weights[i] = sc.nextDouble();
            System.out.print("Enter height (m): ");
            heights[i] = sc.nextDouble();
        }
        
        // d. Calculate BMI and determine weight status
        for (int i = 0; i < numPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            
            // f. Use table to determine weight status
            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] >= 25.0 && bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
        // e. Display height, weight, BMI, and weight status of each person
        System.out.println("\n===== BMI Report =====");
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("------\t---------\t----------\t---\t\t------");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }
        
        sc.close();
    }
}
