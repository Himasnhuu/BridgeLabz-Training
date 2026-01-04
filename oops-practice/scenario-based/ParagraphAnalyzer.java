package scenariobased;

public class ParagraphAnalyzer {

    // Method to analyze paragraph
    public static void analyzeParagraph(String paragraph,String wordToReplace,String replacement) {
        // Edge cases
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }
        // Normalize spaces
        String cleanedParagraph = paragraph.trim().replaceAll("\\s+", " ");

        // Split words (handles punctuation)
        String[] words = cleanedParagraph.split("\\W+");

        // Count words
        int wordCount = words.length;

        // Find longest word
        String longestWord = words[0];
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // Replace word (case-insensitive)
        String replacedParagraph = cleanedParagraph.replaceAll(
                "(?i)\\b" + wordToReplace + "\\b",
                replacement
        );

        // Output
        System.out.println("Original Paragraph:");
        System.out.println(cleanedParagraph);

        System.out.println("\nWord Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);

        System.out.println("\nAfter Replacement:");
        System.out.println(replacedParagraph);
    }

    // Test the program
    public static void main(String[] args) {

        String paragraph = "  Java is powerful. java is object oriented, and Java is popular!   ";

        analyzeParagraph(paragraph, "java", "Python");
    }
}