package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program calculates the side length of a square from its perimeter
public class SquareSide {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user input for perimeter of the square
        System.out.print("Enter perimeter: ");
        double perimeter = sc.nextDouble();

        // Calculate side length by dividing perimeter by 4
        double side = perimeter / 4;
        
        // Display the side length
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        
        // Closing the Scanner class
        sc.close();
    }
}
