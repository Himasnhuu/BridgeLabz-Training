package practiceProblemDay1;

import java.util.Scanner;

// This program calculates the volume of a cylinder
public class VolumeOfCylinder {
    public static void main(String[] args) {
    
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Taking user inputs for radius and height
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        // Calculating volume using formula
        double volume = 3.14 * radius * radius * height;
        System.out.println("Volume of Cylinder = " + volume);
        
        // Closing the Scanner class
        sc.close();
    }
}
