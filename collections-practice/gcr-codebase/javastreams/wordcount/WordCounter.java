package wordcount;

import java.io.*;
import java.util.*;

/**
 * Counts word occurrences in a text file and displays
 * the top 5 most frequently occurring words
 */
public class WordCounter {
    public static void main(String[] args) {
        String filename = "textfile.txt";

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            // HashMap to store word frequencies
            HashMap<String, Integer> wordCount = new HashMap<>();
            String line;

            while ((line = br.readLine()) != null) {
                // Split line into words and count occurrences
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    // Remove punctuation
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort words by frequency in descending order
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Display top 5 words
            System.out.println("Top 5 most frequently occurring words:");
            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                Map.Entry<String, Integer> entry = sortedWords.get(i);
                System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
