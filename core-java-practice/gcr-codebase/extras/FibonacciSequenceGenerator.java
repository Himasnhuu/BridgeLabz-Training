package Week_01.javaMethods.extras;
import java.util.Scanner;

public class FibonacciSequenceGenerator {
    
    public static void main(String[] args) {
        
        System.out.println("FIBONACCI SEQUENCE GENERATOR\n");
        
        // take input from user
        int terms = getInput();
        
        // generate and print fibonacci sequence
        generateFibonacci(terms);
    }
    
    // method to get number of terms from user
    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        sc.close();
        return n;
    }
    
    // method to calculate and print fibonacci sequence
    static void generateFibonacci(int n) {
        int first = 0, second = 1;
        
        System.out.print("\nFibonacci Sequence: ");
        
        // handle edge cases
        if (n <= 0) {
            System.out.println("Invalid input. Please enter a positive number.");
            return;
        }
        
        // print fibonacci sequence
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            
            // calculate next term
            int next = first + second;
            first = second;
            second = next;
        }
        
    }
}
