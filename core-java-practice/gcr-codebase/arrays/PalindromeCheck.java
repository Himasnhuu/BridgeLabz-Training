package Week_01.stringarray.level3;
import java.util.Scanner;

public class PalindromeCheck {

    // Method 1: Iterative comparison using start and end pointers
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        // Compare characters from both ends moving towards center
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Recursive palindrome check
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        // Base case: if pointers meet or cross, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Check if current characters match
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Recursively check remaining characters
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Method 3: Reverse string using charAt()
    public static char[] reverseString(String text) {
        char[] reverse = new char[text.length()];
        int index = 0;

        // Copy characters from end to start
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index++] = text.charAt(i);
        }

        return reverse;
    }

    // Method 3: Compare original and reversed arrays
    public static boolean isPalindromeUsingArray(String text) {
        // Get original and reversed character arrays
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        // Compare each character
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // Take input string from user
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // Check palindrome using three different methods
        boolean result1 = isPalindromeIterative(input);
        boolean result2 = isPalindromeRecursive(input, 0, input.length() - 1);
        boolean result3 = isPalindromeUsingArray(input);

        // Display results from all three methods
        System.out.println("\nPalindrome Check Results:");
        System.out.println("--------------------------");
        System.out.println("Logic 1 (Iterative): " + result1);
        System.out.println("Logic 2 (Recursive): " + result2);
        System.out.println("Logic 3 (Array): " + result3);

        sc.close();
    }
}