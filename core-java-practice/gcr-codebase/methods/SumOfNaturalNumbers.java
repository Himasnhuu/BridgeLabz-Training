package Week_01.javaMethods;
import java.util.Scanner;

public class SumOfNaturalNumbers {
    
    // method to find sum of n natural numbers
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        int sum = findSum(n);
        
        System.out.println("Sum of first " + n + " natural numbers: " + sum);
        
        sc.close();
    }
}
