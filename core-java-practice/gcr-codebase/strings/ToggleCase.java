package Week_01.stringarray.extra;
import java.util.Scanner;

public class ToggleCase {

    // Method to toggle case of characters
    public static String toggleCase(String text) {
        char[] result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Convert uppercase to lowercase
            if (ch >= 'A' && ch <= 'Z') {
                result[i] = (char)(ch + 32);
            }
            // Convert lowercase to uppercase
            else if (ch >= 'a' && ch <= 'z') {
                result[i] = (char)(ch - 32);
            }
            // Keep non-alphabetic characters as is
            else {
                result[i] = ch;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String toggled = toggleCase(text);

        System.out.println("Original String: " + text);
        System.out.println("Toggled String: " + toggled);

        sc.close();
    }
}
