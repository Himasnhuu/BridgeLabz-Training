package Week_01.stringarray.level1;

import java.util.Scanner;

class SubstringComparison {

    // Method to create substring using charAt()
    public static String createSubstringByCharAt(String text, int start, int end) {
    	
        // Basic validation
        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid start or end index");
        }

        StringBuilder builder = new StringBuilder();

        // Append characters from start to end-1
        for (int i = start; i < end; i++) {
            builder.append(text.charAt(i));
        }

        return builder.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean areStringsEqualByCharAt(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Take user input
        Scanner sc = new Scanner(System.in);

        // Enter the String and indices
        System.out.print("Enter a text: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index (exclusive): ");
        int end = sc.nextInt();

        // Create substring using user-defined method
        String userDefinedSubstring = createSubstringByCharAt(text, start, end);
        System.out.println("Substring using charAt method: " + userDefinedSubstring);

        // Create substring using built-in substring()
        String builtInSubstring = text.substring(start, end);
        System.out.println("Substring using built-in substring(): " + builtInSubstring);

        // Compare results
        boolean check = areStringsEqualByCharAt(userDefinedSubstring, builtInSubstring);
        System.out.println("Are both substrings equal? " +check);

        sc.close();
    }
}
