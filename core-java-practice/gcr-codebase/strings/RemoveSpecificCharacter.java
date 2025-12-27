package Week_01.stringarray.extra;
import java.util.Scanner;

public class RemoveSpecificCharacter {

    // Method to remove all occurrences of a specific character
    public static String removeCharacter(String text, char charToRemove) {
        char[] result = new char[text.length()];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            if (ch != charToRemove) {
                result[index++] = ch;
            }
        }

        // Create string from result array with actual length
        char[] finalResult = new char[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }

        return new String(finalResult);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.print("Enter the character to remove: ");
        char charToRemove = sc.next().charAt(0);

        String modifiedString = removeCharacter(text, charToRemove);

        System.out.println("Original String: \"" + text + "\"");
        System.out.println("Modified String: \"" + modifiedString + "\"");

        sc.close();
    }
}
