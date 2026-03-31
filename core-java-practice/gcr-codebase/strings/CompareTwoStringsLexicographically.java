package Week_01.stringarray.extra;
import java.util.Scanner;

public class CompareTwoStringsLexicographically {

    // Method to compare two strings lexicographically without using built-in methods
    public static int compareStrings(String str1, String str2) {
        int minLength = str1.length() < str2.length() ? str1.length() : str2.length();

        for (int i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 != ch2) {
                return ch1 - ch2;
            }
        }

        // If all characters match, compare lengths
        return str1.length() - str2.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();

        int result = compareStrings(str1, str2);

        System.out.println();
        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }

        sc.close();
    }
}
