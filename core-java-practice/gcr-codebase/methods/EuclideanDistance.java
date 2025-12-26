package Week_01.javaMethods.level3;
import java.util.Scanner;

public class EuclideanDistance {
    
    // method to find euclidean distance between two points
    public static double findDistance(int x1, int y1, int x2, int y2) {
        // distance = √((x2-x1)² + (y2-y1)²)
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }
    
    // method to find equation of line
    public static double[] findLineEquation(int x1, int y1, int x2, int y2) {
        // calculate slope: m = (y2 - y1) / (x2 - x1)
        double slope = (double)(y2 - y1) / (x2 - x1);
        
        // calculate y-intercept: b = y1 - m * x1
        double yIntercept = y1 - slope * x1;
        
        // return array with [slope, y-intercept]
        return new double[]{slope, yIntercept};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        // take input for point 1
        System.out.println("Enter coordinates for Point 1:");
        System.out.print("x1: ");
        int x1 = sc.nextInt();
        System.out.print("y1: ");
        int y1 = sc.nextInt();
        
        // take input for point 2
        System.out.println("\nEnter coordinates for Point 2:");
        System.out.print("x2: ");
        int x2 = sc.nextInt();
        System.out.print("y2: ");
        int y2 = sc.nextInt();
        
        // calculate distance
        double distance = findDistance(x1, y1, x2, y2);
        
        // find line equation
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        double slope = lineEquation[0];
        double yIntercept = lineEquation[1];
        
        // display results
        System.out.println("");
        System.out.println("Point 1: (" + x1 + ", " + y1 + ")");
        System.out.println("Point 2: (" + x2 + ", " + y2 + ")");
        System.out.println("\nEuclidean Distance: " + distance);
        System.out.println("\nLine Equation:");
        System.out.println("Slope (m): " + slope);
        System.out.println("Y-intercept (b): " + yIntercept);
        System.out.println("Equation: y = " + slope + "x + " + yIntercept);
        
        sc.close();
    }
}
