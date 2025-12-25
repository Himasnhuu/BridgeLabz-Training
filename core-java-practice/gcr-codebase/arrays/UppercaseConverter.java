package Week_01.stringarray.level1;
import java.util.Scanner;

class UppercaseConverter{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input string from user
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		// Compare original text with manually converted uppercase
		System.out.print(comparingBothStrings(text, toUppercaseManual(text)));
		
		sc.close();
	}
	
	// Method to convert string to uppercase manually using ASCII values
	public static String toUppercaseManual(String text) {
		int size = text.length();
		char [] result = new char[size];
		
		// Loop through each character and convert to uppercase
		for(int i=0; i<size; i++) {
			char ch = text.charAt(i);
			char upper;
			
			// Check if character is lowercase (a-z)
			if (ch>='a' && ch<='z') {
				// Convert to uppercase by subtracting 32 (ASCII difference)
				upper = (char)(ch - 32);
			}else {
				// Keep character as is if not lowercase
				upper = ch;
			}
			result[i]= upper;
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