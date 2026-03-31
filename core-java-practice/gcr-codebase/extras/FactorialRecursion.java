package Week_01.javaMethods.extras;
import java.util.Scanner;

public class FactorialRecursion {
    
    public static void main(String[] args) {
        
        System.out.println("FACTORIAL CALCULATOR (Recursion)\n");
        
        // take input from user
        int number = getInput();
        
        // calculate factorial using recursion
        long factorial = calculateFactorial(number);
        
        // display result
        displayResult(number, factorial);
    }
    
    // method to get number input from user
    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        return num;
    }
    
    // recursive method to calculate factorial
    static long calculateFactorial(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // recursive case
        return n * calculateFactorial(n - 1);
    }
    
    // method to display the result
    static void displayResult(int number, long factorial) {
        System.out.println("\nFactorial of " + number + " = " + factorial);
    }
}
