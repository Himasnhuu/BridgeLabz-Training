package Week_01.stringarray.extra;
import java.util.Scanner;

public class SubstringOccurrences {

    // Method to count substring occurrences
    public static int countSubstringOccurrences(String text, String substring) {
        int count = 0;
        int substringLength = substring.length();

        // Check if substring can fit in text
        if (substringLength > text.length()) {
            return 0;
        }

        for (int i = 0; i <= text.length() - substringLength; i++) {
            boolean match = true;

            // Check if substring matches at position i
            for (int j = 0; j < substringLength; j++) {
                if (text.charAt(i + j) != substring.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String text = sc.nextLine();

        System.out.print("Enter the substring to search: ");
        String substring = sc.nextLine();

        int count = countSubstringOccurrences(text, substring);

        System.out.println("The substring \"" + substring + "\" occurs " + count + " time(s) in the string.");

        sc.close();
    }
}
