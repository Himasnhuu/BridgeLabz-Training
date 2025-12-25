package Week_01.stringarray.level1;
import java.util.Scanner;

class LowercaseConverter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input string from user
        System.out.print("Enter the String : ");
        String text = sc.nextLine();

        // Compare built-in toLowerCase() with custom method
        System.out.print("Comparison result : "+comparingBothStrings(text.toLowerCase(), toLowercaseManual(text)));

        sc.close();
    }

    // Method to convert string to lowercase manually using ASCII values
    public static String toLowercaseManual(String text) {
        int size = text.length();
        char [] result = new char[size];
        
        // Loop through each character and convert to lowercase
        for(int i=0; i<size; i++) {
            char ch = text.charAt(i);
            char lower;
            
            // Check if character is uppercase (A-Z)
            if (ch>='A' && ch<='Z') {
                // Convert to lowercase by adding 32 (ASCII difference)
                lower = (char)(ch + 32);
            }else {
                // Keep character as is if not uppercase
                lower = ch;
            }
            result[i]= lower;
        }
        return new String(result);
    }

    // Method to compare two strings character by character
    public static boolean comparingBothStrings(String first, String second) {

        // Check if lengths are different
        if(first.length()!=second.length()) {
            return false;
        }

        // Compare each character
        for(int i=0; i<first.length(); i++) {
            if(first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;

    }
}
