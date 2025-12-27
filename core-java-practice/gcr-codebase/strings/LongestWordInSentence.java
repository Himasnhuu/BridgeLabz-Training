package Week_01.stringarray.extra;
import java.util.Scanner;

public class LongestWordInSentence {

    // Method to find the longest word in a sentence
    public static String findLongestWord(String sentence) {
        String longestWord = "";
        String currentWord = "";

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            // If character is a letter, add to current word
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                currentWord += ch;
            } else {
                // Word boundary found
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
                currentWord = "";
            }
        }

        // Check last word
        if (currentWord.length() > longestWord.length()) {
            longestWord = currentWord;
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String longestWord = findLongestWord(sentence);

        System.out.println("Longest word: " + longestWord);
        System.out.println("Length: " + longestWord.length());

        sc.close();
    }
}
