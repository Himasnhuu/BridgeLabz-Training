package Week_01.javaMethods.level3;
import java.util.Scanner;

public class NumberCheckerOne {
    
    // method to count digits and store in array
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
    
    // method to reverse digits array
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        
        return reversed;
    }
    
    // method to compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    // method to check palindrome using digits
    public static boolean isPalindrome(int number, int[] digits) {
        int[] reversed = reverseDigits(digits);
        return areArraysEqual(digits, reversed);
    }
    
    // method to check duck number
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int[] digits = storeDigits(number);
        
        System.out.println();
        
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println("\nCount: " + digits.length);
        
        int[] reversed = reverseDigits(digits);
        System.out.print("Reversed: ");
        for (int digit : reversed) {
            System.out.print(digit + " ");
        }
        System.out.println();
        
        boolean equal = areArraysEqual(digits, reversed);
        System.out.println("Original equals Reversed? " + equal);
        
        boolean palindrome = isPalindrome(number, digits);
        System.out.println("Is Palindrome? " + palindrome);
        
        boolean duck = isDuckNumber(digits);
        System.out.println("Is Duck Number? " + duck);
        
        sc.close();
    }
}
