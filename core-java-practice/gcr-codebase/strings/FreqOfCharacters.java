package Week_01.stringarray.level3;
import java.util.Scanner;

/*
Write a program to find the frequency of characters in a string using the charAt() method and display the result
Hint => 
Create a method to find the frequency of characters in a string using the charAt() method and return the characters and their frequencies in a 2D array. The logic used here is as follows:
Create an array to store the frequency of characters in the text. ASCII values of characters are used as indexes in the array to store the frequency of each character. There are 256 ASCII characters
Loop through the text to find the frequency of characters in the text
Create an array to store the characters and their frequencies
Loop through the characters in the text and store the characters and their frequencies
In the main function take user inputs, call user-defined methods, and displays result.
*/

public class FreqOfCharacters {
    
    // method to find frequency of characters
    public static String[][] findCharacterFrequency(String text) {
        // array to store frequency of each ascii character (256 characters)
        int[] frequency = new int[256];
        
        // loop through text to count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            frequency[currentChar]++; // use ascii value as index
        }
        
        // count how many unique characters exist
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (frequency[currentChar] > 0) {
                uniqueCount++;
                frequency[currentChar] = -frequency[currentChar]; // mark as counted
            }
        }
        
        // restore positive frequencies
        for (int i = 0; i < 256; i++) {
            if (frequency[i] < 0) {
                frequency[i] = -frequency[i];
            }
        }
        
        // create 2d array to store character and frequency
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        
        // loop through text and store unique characters with frequencies
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (frequency[currentChar] > 0) {
                result[index][0] = currentChar + ""; // character
                result[index][1] = frequency[currentChar] + ""; // frequency
                frequency[currentChar] = 0; // mark as stored
                index++;
            }
        }
        
        return result;
    }
    
    // method to display character frequencies in tabular format
    public static void displayFrequency(String[][] freqData) {
        System.out.println();
        System.out.println("Character\tFrequency");
        
        for (int i = 0; i < freqData.length; i++) {
            System.out.println("  '" + freqData[i][0] + "'\t\t  " + freqData[i][1]);
        }
        
        System.out.println("Total unique characters: " + freqData.length);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // user enters text to analyze
        System.out.println("FREQUENCY OF CHARACTERS");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // find frequency of characters using charAt() method
        String[][] frequencyData = findCharacterFrequency(input);
        
        // display results in tabular format
        displayFrequency(frequencyData);
        
        sc.close();
    }
}
