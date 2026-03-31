package Week_01.stringarray.level2;
import java.util.Scanner;

/*Write a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter
Hint => 
Create a method to check if the character is a vowel or consonant and return the result. The logic used here is as follows:
Convert the character to lowercase if it is an uppercase letter using the ASCII values of the characters
Check if the character is a vowel or consonant and return Vowel, Consonant, or Not a Letter
Create a Method to find vowels and consonants in a string using charAt() method and return the character and vowel or 
consonant in a 2D array
Create a Method to display the 2D Array of Strings in a Tabular Format
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result. 
*/

public class DisplayingVowelsConsonants {

	public static void main(String[] args) {
		// Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		String [][] arr = display2DArray(text);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
		sc.close();

	}
	//method to return the character type
	static String displaychartype(char c) {
		char ch=c;
		// Convert uppercase to lowercase
		if(c>='A' && c<='Z') {
			ch= (char)(c+32);
		}
		
		if(ch>='a' && ch<='z') {
			if((ch=='a')||(ch=='e')||(ch=='i')||(ch=='o')||(ch=='u')) {
				return "Vowel";
			}else {
				return "Consonant";
			}
		}
		
		return "Not a Letter";
		
	}

	//method to create the 2d array and inserting each character of string in the array
	static String [][] display2DArray(String text){
		String [][] TwoDArray = new String[text.length()][2];
		for(int i=0; i<text.length(); i++) {
			TwoDArray[i][0] = String.valueOf(text.charAt(i));
			TwoDArray[i][1] = displaychartype(text.charAt(i));
		}
		return TwoDArray;
	}
	
}






















