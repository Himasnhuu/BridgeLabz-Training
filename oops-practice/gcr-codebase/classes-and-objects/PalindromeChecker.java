// 3. Program to Check Palindrome String
package week2.oops.classesAndObject;

public class PalindromeChecker {
    
    // attribute
    String text;
    
    // constructor
    PalindromeChecker(String text) {
        this.text = text;
    }
    
    // method to check if text is palindrome
    boolean isPalindrome() {
        // remove spaces and convert to lowercase
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        
        // check palindrome
        int left = 0;
        int right = cleanText.length() - 1;
        
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // method to display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
    
    public static void main(String[] args) {
        
        // test case 1
        PalindromeChecker checker1 = new PalindromeChecker("A man a plan a canal Panama");
        checker1.displayResult();
        
        // test case 2
        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        checker2.displayResult();
    }
}
