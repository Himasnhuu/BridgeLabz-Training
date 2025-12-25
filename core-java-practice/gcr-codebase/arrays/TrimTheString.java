package Week_01.stringarray.level2;
import java.util.Scanner;

/*Write a program to trim the leading and trailing spaces from a string using the charAt() method 
Hint => 
Create a method to trim the leading and trailing spaces from a string using the charAt() method. 
Inside the method run a couple of loops to trim leading and trailing spaces and determine the starting and ending points
 with no spaces. Return the start point and end point in an array
Write a method to create a substring from a string using the charAt() method with the string, start, and end index 
as the parameters
Write a method to compare two strings using the charAt() method and return a boolean result
The main function calls the user-defined trim and substring methods to get the text after trimming the leading and 
trailing spaces. Post that use the String built-in method trim() to trim spaces and compare the two strings. And 
finally display the result*/

public class TrimTheString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input string from user
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		// Display starting and ending characters of trimmed string
		System.out.println("Displaying elements at start index and end index : ");
		char[] Carray = displaySEpoint(text);
		System.out.println(Carray[0]+" "+Carray[1]);
		
		// Take input for substring indices
		System.out.print("Enter the starting and ending index to find the sub string : ");
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		// Create and display substring
		String s = subString(text, start, end);
		System.out.println(s);
		
		// Compare custom trim with built-in trim method
		System.out.print("Comparison of custom method string and built in method string : "+ stringComparison(text.trim(), stringtrim(text)));
		
		sc.close();
		
		

	}
	
	// Method to trim the string and return the trimmed string
	static String stringtrim(String text) {
		StringBuilder st = new StringBuilder(text);
		StringBuilder s = new StringBuilder("");
		
		// Remove leading, trailing and extra spaces
		for(int i=0; i<st.length();i++) {
			if(st.charAt(i)!=' ') {
				s.append(st.charAt(i));
			}else {
				// Keep space only between words
				if((i>0)&&(i<st.length()-1)) {
					if((st.charAt(i-1)!=' ')&&(st.charAt(i+1)!=' ')) {
						s.append(st.charAt(i));
					}
				}
			}
		}
		return s.toString();
	}
	
	// Method returning starting and ending point of the trimmed string
	static char[] displaySEpoint(String text) {
		// Get trimmed string
		String s = stringtrim(text);
		
		// Return first and last characters
		char[] arr = {s.charAt(0),s.charAt(s.length()-1)};
		return arr;
	}
	
	
	// Method to print the substring of a trimmed string
	static String subString(String text, int s, int e) {
		// First trim the string
		String st = stringtrim(text);
		StringBuilder sub = new StringBuilder("");
		
		// Extract substring from start to end index
		for(int i=s;i<e;i++) {
			sub.append(st.charAt(i));
		}
		return sub.toString();
	}
	
	// Method to compare two strings character by character
	static boolean stringComparison(String s1, String s2) {
		// Check if lengths differ
		// Check if lengths differ
		if(s1.length()!=s2.length()) {
			return false;
		}
		
		// Compare each character
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	

}


