package Week_01.arrays.level2;

import java.util.Scanner;

public class BMICalculatorMultiDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // a. Take input for number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = sc.nextInt();
        
        // b. Create multi-dimensional array to store weight, height and BMI
        // personData[i][0] = weight, personData[i][1] = height, personData[i][2] = BMI
        double[][] personData = new double[numPersons][3];
        String[] statuses = new String[numPersons];
        
        // c. Take input for weight and height, ask for positive values
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
            // Get valid weight
            do {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = sc.nextDouble();
                if (personData[i][0] <= 0) {
                    System.out.println("Please enter a positive value!");
                }
            } while (personData[i][0] <= 0);
            
            // Get valid height
            do {
                System.out.print("Enter height (m): ");
                personData[i][1] = sc.nextDouble();
                if (personData[i][1] <= 0) {
                    System.out.println("Please enter a positive value!");
                }
            } while (personData[i][1] <= 0);
        }
        
        // d. Calculate BMI and store in personData array, find weight status
        for (int i = 0; i < numPersons; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            // Determine weight status
            if (personData[i][2] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                statuses[i] = "Normal";
            } else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
        // e. Display height, weight, BMI and status of each person
        System.out.println("\n===== BMI Report (Multi-Dimensional Array) =====");
        System.out.println("Person\tWeight(kg)\tHeight(m)\tBMI\t\tStatus");
        System.out.println("------\t----------\t---------\t---\t\t------");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                (i + 1), personData[i][0], personData[i][1], personData[i][2], statuses[i]);
        }
        
        sc.close();
    }
}
