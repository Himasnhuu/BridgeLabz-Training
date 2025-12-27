package Week_01.stringarray.extra;
import java.util.Scanner;

public class RemoveDuplicates {

    // Method to check if character already exists in result
    public static boolean isDuplicate(char[] result, int currentLength, char ch) {
        for (int i = 0; i < currentLength; i++) {
            if (result[i] == ch) {
                return true;
            }
        }
        return false;
    }

    // Method to remove duplicate characters from string
    public static String removeDuplicates(String text) {
        char[] result = new char[text.length()];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            if (!isDuplicate(result, index, ch)) {
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

        String result = removeDuplicates(text);

        System.out.println("Original String: " + text);
        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}
