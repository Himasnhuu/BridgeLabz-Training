package Week_01.arrays.level1;

import java.util.Scanner;

public class DynamicArrayInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Define array of 10 elements and variables
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter numbers (up to 10). Enter 0 or negative to stop:");
        
        // Infinite loop to take user input
        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double number = sc.nextDouble();
            
            // Break if user entered 0 or negative number
            if (number <= 0) {
                System.out.println("Stopping input (0 or negative number entered).");
                break;
            }
            
            // Assign number to array
            numbers[index] = number;
            index++;
            
            // Break if array is full
            if (index == 10) {
                System.out.println("Maximum 10 numbers reached.");
                break;
            }
        }
        
        // Calculate total
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
            total += numbers[i];
        }
        
        // Display total
        System.out.println("\nSum of all numbers: " + total);
        
        sc.close();
    }
}
