package Week_01.ProgrammingElements;

import java.util.Scanner;

// This program calculates the area of a triangle based on base and height
public class TriangleArea {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for base and height
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        // Calculating area 
        double area = 0.5 * base * height;
        
        // Displaying the calculated area
        System.out.println("Area of triangle is " + area);
        
        // Closing the Scanner class
        sc.close();
    }
}
