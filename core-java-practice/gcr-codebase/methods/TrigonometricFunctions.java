package Week_01.javaMethods;
import java.util.Scanner;

public class TrigonometricFunctions {
    
    //method to calculate trigonometric functions
    public double[] calculateTrigonometricFunctions(double angle) {
        // convert degrees to radians
        double radians = Math.toRadians(angle);
        
        // calculate sine, cosine, tangent
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        
        return new double[]{sine, cosine, tangent};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // create object to call non-static method
        TrigonometricFunctions tf = new TrigonometricFunctions();
        
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        
        double[] result = tf.calculateTrigonometricFunctions(angle);
        
        System.out.println("Sine(" + angle + " degree) = " + result[0]);
        System.out.println("Cosine(" + angle + " degree) = " + result[1]);
        System.out.println("Tangent(" + angle + " degree) = " + result[2]);
        
        sc.close();
    }
}
