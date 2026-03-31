package Week_01.stringarray.extra;
import java.util.Scanner;

public class AnagramChecker {

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // Step 1: Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step 2: Create frequency arrays for ASCII characters
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Step 3: Count frequency of characters in both strings
        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i)]++;
            freq2[str2.charAt(i)]++;
        }

        // Step 4: Compare frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();

        boolean result = areAnagrams(str1, str2);

        if (result) {
            System.out.println("The two strings are ANAGRAMS of each other.");
        } else {
            System.out.println("The two strings are NOT ANAGRAMS of each other.");
        }

        sc.close();
    }
}
