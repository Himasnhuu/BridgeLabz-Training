package Week_01.stringarray.level1;
import java.util.Scanner;

class LowercaseConverter{
    public static void main(String[] args) {
        // Take user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String text = sc.nextLine();

        System.out.print("Comparison result : "+comparingBothStrings(text.toLowerCase(), toLowercaseManual(text)));

        sc.close();
    }

    // Method to convert string to lowercase manually
    public static String toLowercaseManual(String text) {
        int size = text.length();
        char [] result = new char[size];
        for(int i=0; i<size; i++) {
            char ch = text.charAt(i);
            char lower;
            if (ch>='A' && ch<='Z') {
                lower = (char)(ch + 32);
            }else {
                lower = ch;
            }
            result[i]= lower;
        }
        return new String(result);
    }

    // Method to compare two strings
    public static boolean comparingBothStrings(String first, String second) {

        if(first.length()!=second.length()) {
            return false;
        }

        for(int i=0; i<first.length(); i++) {
            if(first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;

    }
}
