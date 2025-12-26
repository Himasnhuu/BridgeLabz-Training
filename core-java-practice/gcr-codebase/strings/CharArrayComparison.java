package Week_01.stringarray.level1;
import java.util.Scanner;

class CharArrayComparison {

    // Method to convert String to char array without using toCharArray()
    public static char[] convertToCharArrayManual(String text) {
        char[] characters = new char[text.length()];

        // Copy each character using charAt
        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }

        return characters;
    }

    // Method to compare two char arrays
    public static boolean areCharArraysEqual(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input string
        System.out.print("Enter a text: ");
        String text = sc.next();

        // Convert using user-defined method
        char[] manualArray = convertToCharArrayManual(text);

        // Convert using built-in toCharArray()
        char[] builtInArray = text.toCharArray();

        // Compare both arrays
        boolean check = areCharArraysEqual(manualArray, builtInArray);

        System.out.println("Are both character arrays equal? " + check);

        sc.close();
    }
}
