package method_propagation;

public class ExceptionPropagation {
    
    // Method that throws ArithmeticException
    public static void method1() throws ArithmeticException {
        int result = 10 / 0;
    }
    
    // Method that calls method1 and propagates exception
    public static void method2() throws ArithmeticException {
        method1();
    }
    
    // Main method handles the exception
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            // Exception propagated from method1 -> method2 -> main
            System.out.println("Handled exception in main");
        }
    }
}
