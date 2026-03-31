package Week_01.stringarray.level3;
import java.util.Scanner;

/*
Write a program to find the frequency of characters in a string using unique characters and display the result
Hint => 
Create a method to Find unique characters in a string using the charAt() method and return them as a 1D array.  Use Nested Loops to find the unique characters in the text
Create a method to find the frequency of characters in a string and return the characters and their frequencies in a 2D array. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Call the uniqueCharacters() method to find the unique characters in the text
Create a 2D String array to store the unique characters and their frequencies. 
Loop through the unique characters and store the characters and their frequencies
In the main function take user inputs, call user-defined methods, and displays result.
*/

public class UniqueFreqOfCh {
    
    // method to find unique characters using nested loops
    public static char[] findUniqueCharacters(String text) {
        // temporary array to store unique characters
        char[] tempUnique = new char[text.length()];
        int uniqueCount = 0;
        
        // outer loop: iterate through each character
        for (int i = 0; i < text.length(); i++) {
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
    
    // method to find frequency of characters
    public static String[][] findCharacterFrequency(String text) {
        // array to store frequency of each ascii character (256 characters)
        int[] frequency = new int[256];
        
        // loop through text to count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            frequency[currentChar]++; // use ascii value as index
        }
        
        // get unique characters using nested loop method
        char[] uniqueChars = findUniqueCharacters(text);
        
        // create 2d array to store unique characters and frequencies
        String[][] result = new String[uniqueChars.length][2];
        
        // loop through unique characters and store with frequencies
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = ch + ""; // character
            result[i][1] = frequency[ch] + ""; // frequency
        }
        
        return result;
    }
    
    // method to display character frequencies in tabular format
    public static void displayFrequency(String[][] freqData) {
        System.out.println("Character\tFrequency");
        
        for (int i = 0; i < freqData.length; i++) {
            System.out.println("  '" + freqData[i][0] + "'\t\t  " + freqData[i][1]);
        }
        
        System.out.println("Total unique characters: " + freqData.length);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // user enters text to analyze
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // find frequency of characters using unique characters method
        String[][] frequencyData = findCharacterFrequency(input);
        
        // display results in tabular format
        displayFrequency(frequencyData);
        
        sc.close();
    }
}
