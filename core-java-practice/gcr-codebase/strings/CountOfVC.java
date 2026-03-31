package Week_01.stringarray.level2;
import java.util.Scanner;

/*Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string
Hint => 
Create a method to check if the character is a vowel or consonant and return the result. The logic used here is as follows:
Convert the character to lowercase if it is an uppercase letter using the ASCII values of the characters
Check if the character is a vowel or consonant and return Vowel, Consonant, or Not a Letter
Create a Method to Method to find vowels and consonants in a string using charAt() method and finally return the count of 
vowels and consonants in an array
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result. 
*/

public class CountOfVC {

	public static void main(String[] args) {
		// Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		
		System.out.print("Vowels : "+vcCount(text)[0]+ "\nConsonants : "+vcCount(text)[1]);
		sc.close();	
	}
	
	//method to convert the string into lowercase
	static String lowerCaseConversion(String text) {
		char[] c = new char[text.length()];
		for(int i=0;i<text.length();i++) {
			char ch = text.charAt(i);
			// Convert uppercase to lowercase using ASCII
			if (ch>='A' && ch<='Z') {
				c[i] = (char)(ch+32);
			}
			else {
				c[i] = ch;
			}
		}
		return new String(c);
	}
	
	// method to find the number of vowels and consonants in a string
	static int[] vcCount(String text) {
		String st = lowerCaseConversion(text);
		int v=0, c=0;
		for(int i=0; i<st.length();i++) {
			if ((st.charAt(i)=='a')||(st.charAt(i)=='e')||(st.charAt(i)=='i')||(st.charAt(i)=='o')||(st.charAt(i)=='u')) {
				v++;
			}else {
				if((st.charAt(i)>='a')||(st.charAt(i)<='z')) {
					c++;
				}
			}
		}
		int [] vcArray = {v,c};
		return vcArray;
	}

}
