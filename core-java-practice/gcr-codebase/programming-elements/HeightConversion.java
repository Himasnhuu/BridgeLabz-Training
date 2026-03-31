package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program converts height from centimeters to feet and inches
public class HeightConversion {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user input for height in centimeters
        System.out.print("Enter height in cm: ");
        double cm = sc.nextDouble();

        // Convert centimeters to inches, then to feet and remaining inches
        double inches = cm / 2.54;
        int feet = (int) (inches / 12);
        double remainingInches = inches % 12;

        // Display the converted height in feet and inches
        System.out.println("Your Height in cm is " + cm + " while in feet is " + feet + " and inches is " + remainingInches);
        
        // Closing the Scanner class
        sc.close();
    }
}
