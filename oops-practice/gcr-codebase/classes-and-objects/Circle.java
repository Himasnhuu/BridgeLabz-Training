// 2. Program to Compute Area of a Circle
package week2.oops.classesAndObject;

public class Circle {
    
    // attribute
    double radius;
    
    // method to calculate area of a Circle
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    // method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    
    // method to display results
    void displayCircleDetails() {
        double area = calculateArea();
        double circumference = calculateCircumference();
        
        System.out.println("Area of circle: " + String.format("%.4f", area));
        System.out.println("Circumference of circle: " + String.format("%.4f", circumference));
    }
    
    public static void main(String[] args) {
        
        // create circle object
        Circle circle = new Circle();
        
        // set radius
        circle.radius = 2.5;
        
        // display circle details
        circle.displayCircleDetails();
    }
}
