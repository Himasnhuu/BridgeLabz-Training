package Week_01.javaMethods.level3;
import java.util.Scanner;

public class NumberCheckerTwo {
    
    // method to store digits
    public static int[] storeDigits(int number) {
        int temp = number;
        int count = 0;
        
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        
        return digits;
    }
    
    // method to check prime number
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // method to check neon number
    public static boolean isNeonNumber(int number, int[] digits) {
        int square = number * number;
        int[] squareDigits = storeDigits(square);
        
        int sumOfSquareDigits = 0;
        for (int digit : squareDigits) {
            sumOfSquareDigits += digit;
        }
        
        return sumOfSquareDigits == number;
    }
    
    // method to check spy number
    public static boolean isSpyNumber(int[] digits) {
        int sum = 0;
        int product = 1;
        
        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }
        
        return sum == product;
    }
    
    // method to check automorphic number
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        
        int temp = number;
        int divisor = 1;
        while (temp > 0) {
            divisor *= 10;
            temp /= 10;
        }
        
        return square % divisor == number;
    }
    
    // method to check buzz number
    public static boolean isBuzzNumber(int number, int[] digits) {
        int lastDigit = digits[digits.length - 1];
        return (number % 7 == 0) || (lastDigit == 7);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int[] digits = storeDigits(number);
        
        System.out.println();
        System.out.println("Is Prime? " + isPrime(number));
        System.out.println("Is Neon? " + isNeonNumber(number, digits));
        System.out.println("Is Spy? " + isSpyNumber(digits));
        System.out.println("Is Automorphic? " + isAutomorphicNumber(number));
        System.out.println("Is Buzz? " + isBuzzNumber(number, digits));
        
        sc.close();
    }
}
