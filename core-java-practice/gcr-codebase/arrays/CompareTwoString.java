package Week_01.stringarray.level1;
import java.util.Scanner;

class StringComparator {

    // Method to compare two strings using charAt()
    public static boolean areStringsEqualByCharAt(String first, String second) {
        // If lengths differ, strings cannot be equal
        if (first.length() != second.length()) {
            return false;
        }

        // Compare each character at the same index
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }

        // All characters matched
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for two strings
        System.out.print("Enter first string: ");
        String first = sc.next();

        System.out.print("Enter second string: ");
        String second = sc.next();

        // Compare using user-defined method
        boolean resultByCharAt = areStringsEqualByCharAt(first, second);

        // Compare using built-in equals() method
        boolean resultByEquals = first.equals(second);

        // Display results
        System.out.println("Result using charAt comparison: " + resultByCharAt);
        System.out.println("Result using equals() method: " + resultByEquals);

        // Check if both methods gave same result
        System.out.println("Do both methods give same result? " + (resultByCharAt == resultByEquals));

        sc.close();
    }
}
