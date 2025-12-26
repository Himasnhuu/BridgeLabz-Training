package Week_01.stringarray.level1;
import java.util.Scanner;

class StringIndexOutOfBounds {

    // Method that generates StringIndexOutOfBoundsException
    public static void generateStringIndexOutOfBounds(String text) {
        int invalidIndex = text.length(); // index equal to length is invalid

        // This will throw StringIndexOutOfBoundsException
        char ch = text.charAt(invalidIndex);
        System.out.println("Character at invalid index: " + ch);
    }

    // Method that handles StringIndexOutOfBoundsException
    public static void handleStringIndexOutOfBounds(String text) {
        try {
        	generateStringIndexOutOfBounds(text);
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Take user input
        Scanner scanner = new Scanner(System.in);

        // Take user input string
        System.out.print("Enter a text: ");
        String text = scanner.next();

        // First call method that generates exception
        // Comment after one run because it terminates program
        // generateStringIndexOutOfBounds(text);

        // Then call method that handles the exception
        handleStringIndexOutOfBounds(text);

        scanner.close();
    }
}
