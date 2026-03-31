package Week_01.javaMethods.extras;
import java.util.Scanner;

public class PalindromeChecker {
    
    public static void main(String[] args) {
        
        System.out.println("PALINDROME CHECKER\n");
        
        // take input string from user
        String str = getInput();
        
        // check if palindrome
        boolean isPalindrome = checkPalindrome(str);
        
        // display result
        displayResult(str, isPalindrome);
    }
    
    // method to get string input from user
    static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        sc.close();
        return s;
    }
    
    // method to check if string is palindrome
    static boolean checkPalindrome(String str) {
    	
        // remove spaces and convert to lowercase
        str = str.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = str.length() - 1;
        
        // compare characters from both ends
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // method to display the result
    static void displayResult(String str, boolean isPalindrome) {
        System.out.println("\nString: " + str);
        if (isPalindrome) {
            System.out.println("It is a PALINDROME.");
        } else {
            System.out.println("It is NOT a palindrome.");
        }
    }
}
