package Week_01.stringarray.level3;
import java.util.Scanner;

/*
 * Write a program to find the first non-repeating character in a string and show the result
Hint => 
Non-repeating character is a character that occurs only once in the string
Create a Method to find the first non-repeating character in a string using the charAt() method and return the character. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Loop through the text to find the first non-repeating character in the text by checking the frequency of each character
In the main function take user inputs, call user-defined methods, and displays result. 
*/

public class FindNonReCh {
    
    // method to find first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {
        // array to store frequency of each ascii character (256 characters)
        int[] frequency = new int[256];
        
        // first loop: count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            frequency[currentChar]++; // use ascii value as index
        }
        
        // second loop: find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (frequency[currentChar] == 1) {
                return currentChar; // return first non-repeating character
            }
        }
        
        // if no non-repeating character found
        return ' '; // null character
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // user enters text to analyze
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // find first non-repeating character
        char result = findFirstNonRepeatingChar(input);
        
        // display result
        if (result == ' ') {
            System.out.println("No non-repeating character found!");
        } else {
            System.out.println("First non-repeating character: '" + result + "'");
        }
        System.out.println();
        
        sc.close();
    }
}
