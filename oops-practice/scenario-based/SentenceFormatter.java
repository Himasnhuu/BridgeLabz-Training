package scenariobased;
import java.util.Scanner;

public class SentenceFormatter {
    
    static String stringCorrection(String s) {
        // Handle null or empty input
        if(s == null || s.trim().isEmpty()) {
            return "";
        }
        
        // Step 1: Trim and replace multiple spaces with single space
        s = s.trim().replaceAll("\\s+", " ");
        
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // If we need to capitalize this character
            if (capitalizeNext && Character.isLetter(currentChar)) {
                sb.append(Character.toUpperCase(currentChar));
                capitalizeNext = false;
            } else {
                sb.append(currentChar);
            }
            
            // Check if current character is end of sentence punctuation
            if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                capitalizeNext = true;
                
                // Ensure there's exactly one space after punctuation
                // (unless we're at the end of the string)
                if (i + 1 < s.length() && s.charAt(i + 1) != ' ') {
                    sb.append(' ');
                }
            }
            
            // Handle multiple spaces after punctuation
            if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                // Skip any extra spaces after punctuation
                while (i + 1 < s.length() && s.charAt(i + 1) == ' ') {
                    i++;
                }
                // Add a single space if next character is not end of string
                if (i + 1 < s.length() && Character.isLetter(s.charAt(i + 1))) {
                    sb.append(' ');
                }
            }
        }
        
        // Final cleanup: ensure only one space after punctuation
        String result = sb.toString();
        result = result.replaceAll("\\s+", " ");
        result = result.replaceAll("\\.\\s+", ". ");
        result = result.replaceAll("\\!\\s+", "! ");
        result = result.replaceAll("\\?\\s+", "? ");
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nEnter your own text to format:");
        String userInput = sc.nextLine();
        System.out.println("Formatted: " + stringCorrection(userInput));
        
        sc.close();
    }
} 
