package Week_01.stringarray.level3;
import java.util.Scanner;

public class CharacterFrequencyNestedLoop {

    // Method to find character frequency using nested loops
    public static String[] findFrequency(String text) {

        // Convert string to character array
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        // Initialize frequency array with 1 for each character
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
        }

        // Nested loop to find frequency of each character
        for (int i = 0; i < chars.length; i++) {

            // Skip already counted characters
            if (chars[i] == '0') {
                continue;
            }

            // Inner loop to find duplicates
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate as processed
                }
            }
        }

        // Count valid characters (not marked as duplicates)
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Create 1D String array with character and frequency
        String[] result = new String[count];
        int index = 0;

        // Store character and frequency in result array
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " : " + freq[i];
            }
        }

        return result;
    }

    // Method to display frequency results
    public static void displayResult(String[] data) {
        System.out.println("\nCharacter Frequency:");
        
        // Display each character with its frequency
        for (String entry : data) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input string from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Find character frequency using nested loop method
        String[] frequency = findFrequency(input);
        
        // Display results
        displayResult(frequency);

        sc.close();
    }
}