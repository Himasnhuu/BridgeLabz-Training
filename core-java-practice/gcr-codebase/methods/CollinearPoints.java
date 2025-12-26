package Week_01.javaMethods.level3;
import java.util.Scanner;

public class CollinearPoints {
    
    // method to check if points are collinear using slope formula
    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // calculate slopes
        // slope AB = (y2 - y1) / (x2 - x1)
        // slope BC = (y3 - y2) / (x3 - x2)
        // slope AC = (y3 - y1) / (x3 - x1)
        
        // to avoid division, use cross multiplication
        // slope AB = slope BC means: (y2-y1)/(x2-x1) = (y3-y2)/(x3-x2)
        // cross multiply: (y2-y1)*(x3-x2) = (y3-y2)*(x2-x1)
        
        int slopeAB_numerator = y2 - y1;
        int slopeAB_denominator = x2 - x1;
        
        int slopeBC_numerator = y3 - y2;
        int slopeBC_denominator = x3 - x2;
        
        // check if slope AB = slope BC using cross multiplication
        return (slopeAB_numerator * slopeBC_denominator) == (slopeBC_numerator * slopeAB_denominator);
    }
    
    // method to check if points are collinear using area formula
    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        // area of triangle formula
        // area = 0.5 * (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))
        // if area = 0, points are collinear
        
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        
        return area == 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        // take input for 3 points
        System.out.println("Enter coordinates for Point A:");
        System.out.print("x1: ");
        int x1 = sc.nextInt();
        System.out.print("y1: ");
        int y1 = sc.nextInt();
        
        System.out.println("\nEnter coordinates for Point B:");
        System.out.print("x2: ");
        int x2 = sc.nextInt();
        System.out.print("y2: ");
        int y2 = sc.nextInt();
        
        System.out.println("\nEnter coordinates for Point C:");
        System.out.print("x3: ");
        int x3 = sc.nextInt();
        System.out.print("y3: ");
        int y3 = sc.nextInt();
        
        // display points
        System.out.println("\nPoints");
        System.out.println("A(" + x1 + ", " + y1 + ")");
        System.out.println("B(" + x2 + ", " + y2 + ")");
        System.out.println("C(" + x3 + ", " + y3 + ")");
        
        // check collinearity using slope method
        boolean collinearBySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        
        // check collinearity using area method
        boolean collinearByArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);
        
        // display results
        System.out.println();
        System.out.println("Collinear (Slope Method): " + collinearBySlope);
        System.out.println("Collinear (Area Method): " + collinearByArea);
        
        if (collinearBySlope && collinearByArea) {
            System.out.println("\nPoints are COLLINEAR!");
        } else {
            System.out.println("\nPoints are NOT COLLINEAR!");
        }
        
        sc.close();
    }
}
