package practiceProblemDay1;

import java.util.Scanner;

// This program converts distance from kilometers to miles
public class KilometerToMiles {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user input for distance in kilometers
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();

        // Converting kilometers to miles using conversion factor 0.621371
        double miles = km * 0.621371;
        System.out.println("Distance in miles = " + miles);
        
        // Closing the Scanner class
        sc.close();
    }
}
