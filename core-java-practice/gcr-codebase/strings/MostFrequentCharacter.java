package Week_01.stringarray.extra;
import java.util.Scanner;

public class MostFrequentCharacter {

    // Method to find the most frequent character in a string
    public static char findMostFrequentCharacter(String text) {
        int[] frequency = new int[256]; // ASCII characters

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Find character with maximum frequency
        char mostFrequent = text.charAt(0);
        int maxFrequency = frequency[text.charAt(0)];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] > maxFrequency) {
                maxFrequency = frequency[ch];
                mostFrequent = ch;
            }
        }

        return mostFrequent;
    }

    // Method to get frequency of a character
    public static int getFrequency(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char mostFrequent = findMostFrequentCharacter(text);
        int frequency = getFrequency(text, mostFrequent);

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
        System.out.println("Frequency: " + frequency);

        sc.close();
    }
}
