package Week_01.stringarray.extra;
import java.util.Scanner;

public class ReverseString {

    // Method to reverse a string without using built-in reverse function
    public static String reverseString(String text) {
        char[] reversed = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed[index++] = text.charAt(i);
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String reversed = reverseString(text);

        System.out.println("Original String: " + text);
        System.out.println("Reversed String: " + reversed);

        sc.close();
    }
}
