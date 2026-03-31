package Week_01.javaMethods.extras;
import java.util.Scanner;

public class GCDandLCMCalculator {
    
    public static void main(String[] args) {
        
        System.out.println("GCD AND LCM CALCULATOR\n");
        
        // take two numbers as input
        int[] numbers = getInput();
        int num1 = numbers[0];
        int num2 = numbers[1];
        
        // calculate GCD
        int gcd = calculateGCD(num1, num2);
        
        // calculate LCM
        int lcm = calculateLCM(num1, num2, gcd);
        
        // display results
        displayResult(num1, num2, gcd, lcm);
    }
    
    // method to get two numbers from user
    static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        
        System.out.print("Enter first number: ");
        nums[0] = sc.nextInt();
        
        System.out.print("Enter second number: ");
        nums[1] = sc.nextInt();
        
        sc.close();
        return nums;
    }
    
    // method to calculate GCD
    static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // method to calculate LCM using formula: LCM = (a * b) / GCD
    static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
    
    // method to display results
    static void displayResult(int num1, int num2, int gcd, int lcm) {
        System.out.println("\nNumbers: " + num1 + " and " + num2);
        System.out.println("GCD (Greatest Common Divisor): " + gcd);
        System.out.println("LCM (Least Common Multiple): " + lcm);
    }
}
