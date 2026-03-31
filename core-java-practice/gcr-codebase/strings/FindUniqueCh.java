package Week_01.stringarray.level3;
import java.util.Scanner;

/*Find unique characters in a string using the charAt() method and display the result
Hint => 
Create a Method to find the length of the text without using the String method length()
Create a method to Find unique characters in a string using the charAt() method and return them as a 1D array. 
The logic used here is as follows:
Create an array to store the unique characters in the text. The size is the length of the text
Loops to Find the unique characters in the text. Find the unique characters in the text using a nested loop. 
An outer loop iterates through each character and an inner loop checks if the character is unique by comparing 
it with the previous characters. If the character is unique, it is stored in the result array
Create a new array to store the unique characters 
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result. 
*/

public class FindUniqueCh {
    
    // method to find length without using length() method
    public static int findLength(String text) {
        int count = 0;
        
        // keep reading characters until exception occurs
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // when exception occurs, we've reached the end
        }
        
        return count;
    }
    
    // method to find unique characters in string
    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);
        
        // temporary array to store unique characters
        char[] tempUnique = new char[length];
        int uniqueCount = 0;
        
        // outer loop: iterate through each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
            // inner loop: check if character already exists in unique array
            for (int j = 0; j < uniqueCount; j++) {
                if (tempUnique[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            
            // if character is unique, add to result array
            if (isUnique) {
                tempUnique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }
        
        // create new array with exact size for unique characters
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = tempUnique[i];
        }
        
        return result;
    }
    
    // method to display unique characters
    public static void displayUniqueCharacters(char[] uniqueChars) {
        System.out.print("Unique characters: ");
        
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i]);
            if (i < uniqueChars.length - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println("\nTotal unique characters: " + uniqueChars.length);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // user enters text to analyze
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // find length without using length() method
        int textLength = findLength(input);
        System.out.println("Length of string: " + textLength);
        
        // find unique characters using charAt() method
        char[] uniqueCharacters = findUniqueCharacters(input);
        
        // display results
        displayUniqueCharacters(uniqueCharacters);
        
        sc.close();
    }
}
