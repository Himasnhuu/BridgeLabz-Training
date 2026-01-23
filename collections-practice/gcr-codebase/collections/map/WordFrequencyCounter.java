package map;

import java.util.*;

public class WordFrequencyCounter {
    
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        // Remove punctuation and convert to lowercase
        String cleanText = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
        String[] words = cleanText.split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequencyMap;
    }
    
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        
        System.out.println("Input: \"" + text + "\"");
        System.out.println("Output: " + countWords(text));
    }
}
