package Week_01.javaMethods.level3;
import java.util.Scanner;

public class NumberCheckerThree {
    
    // method to find proper divisors sum
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
    
    // method to check perfect number
    public static boolean isPerfectNumber(int number) {
        return sumOfProperDivisors(number) == number;
    }
    
    // method to check abundant number
    public static boolean isAbundantNumber(int number) {
        return sumOfProperDivisors(number) > number;
    }
    
    // method to check deficient number
    public static boolean isDeficientNumber(int number) {
        return sumOfProperDivisors(number) < number;
    }
    
    // method to find factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        
        return fact;
    }
    
    // method to check strong number
    public static boolean isStrongNumber(int number) {
        int temp = number;
        long sum = 0;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        
        return sum == number;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int divisorSum = sumOfProperDivisors(number);
        
        System.out.println();
        System.out.println("Sum of proper divisors: " + divisorSum);
        System.out.println("Is Perfect? " + isPerfectNumber(number));
        System.out.println("Is Abundant? " + isAbundantNumber(number));
        System.out.println("Is Deficient? " + isDeficientNumber(number));
        System.out.println("Is Strong? " + isStrongNumber(number));
        
        sc.close();
    }
}
