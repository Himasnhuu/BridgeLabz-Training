package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program converts distance from feet to yards and miles
public class FeetConversion {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user input for distance in feet
        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();

        // Convert feet to yards and miles
        double yards = feet / 3;
        double miles = yards / 1760;

        // Display the converted distances
        System.out.println("Distance in yards is " + yards +
                " and in miles is " + miles);
        
        // Closing the Scanner class
        sc.close();
    }
}
