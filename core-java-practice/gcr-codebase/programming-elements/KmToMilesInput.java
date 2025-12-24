package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program converts distance from kilometers to miles based on user input
public class KmToMilesInput {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user input for distance in kilometers
        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();

        // Convert kilometers to miles
        double miles = km / 1.6;
        
        // Display the converted distance in miles
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        
        // Closing the Scanner class
        sc.close();
    }
}
