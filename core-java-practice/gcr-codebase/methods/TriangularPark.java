package Week_01.javaMethods;
import java.util.Scanner;

/*An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants 
 * to complete a 5 km run, then how many rounds must the athlete complete
Hint => 
Take user input for 3 sides of a triangle 
The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
Write a Method to compute the number of rounds user needs to do to complete 5km run
*/

public class TriangularPark {
    
    // method to calculate number of rounds needed
    public static int calculateRounds(double side1, double side2, double side3) {
        // calculate perimeter of triangular park in meters
        double perimeter = side1 + side2 + side3;
        
        // target distance is 5 km = 5000 meters
        double targetDistance = 5000;
        
        // calculate number of rounds needed
        double rounds = targetDistance / perimeter;
        
        // round up to complete full rounds
        return (int)(rounds);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //measurements of park sides
        System.out.print("Enter side 1 of triangle (meters): ");
        double side1 = sc.nextDouble();
        
        System.out.print("Enter side 2 of triangle (meters): ");
        double side2 = sc.nextDouble();
        
        System.out.print("Enter side 3 of triangle (meters): ");
        double side3 = sc.nextDouble();
        
        // calculate perimeter of one round
        double perimeter = side1 + side2 + side3;
        
        // calculate number of rounds needed
        int rounds = calculateRounds(side1, side2, side3);
        
        // display results to athlete
        System.out.println("Park perimeter: " + perimeter + " meters");
        System.out.println("Target distance: 5000 meters (5 km)");
        System.out.println("Rounds needed: " + rounds);
        System.out.println("Total distance: " + (rounds * perimeter) + " meters");
        
        sc.close();
    }
}
