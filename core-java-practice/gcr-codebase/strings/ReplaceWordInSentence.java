package Week_01.stringarray.extra;
import java.util.Scanner;

public class ReplaceWordInSentence {

    // Method to check if two words are equal
    public static boolean areWordsEqual(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // Method to replace a word in a sentence
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        String currentWord = "";

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            // If character is not a space, build current word
            if (ch != ' ') {
                currentWord += ch;
            } else {
                // Word boundary found
                if (areWordsEqual(currentWord, oldWord)) {
                    result += newWord;
                } else {
                    result += currentWord;
                }
                result += ' ';
                currentWord = "";
            }
        }

        // Process last word
        if (areWordsEqual(currentWord, oldWord)) {
            result += newWord;
        } else {
            result += currentWord;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = sc.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();

        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("\nOriginal Sentence: " + sentence);
        System.out.println("Modified Sentence: " + modifiedSentence);

        sc.close();
    }
}
