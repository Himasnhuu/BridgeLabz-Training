package practiceProblemDay1;

import java.util.Scanner;

// This program calculates the perimeter of a rectangle
public class PerimeterOfRectangle {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for length and width
        System.out.print("Enter length: ");
        double length = sc.nextDouble();
        System.out.print("Enter width: ");
        double width = sc.nextDouble();

        // Calculating perimeter using formula: 2 × (length + width)
        double perimeter = 2 * (length + width);
        System.out.print("Perimeter of Rectangle = " + perimeter);
        
        // Closing the Scanner class
        sc.close();
    }
}
