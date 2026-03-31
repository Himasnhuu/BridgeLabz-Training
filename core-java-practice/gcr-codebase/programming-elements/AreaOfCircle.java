package practiceProblemDay1;

import java.util.Scanner;

// This program calculates the area of a circle based on user input
public class AreaOfCircle {
    public static void main(String[] args) {
    	
        // Create a Scanner object to read input from the keyboard
        Scanner sc = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter radius of a Circle: ");
        double radius = sc.nextDouble();

        // Calculating the area
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + area);
        
        // Closing the Scanner
        sc.close();
    }
}
