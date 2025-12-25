package Week_01.stringarray.level2;
import java.util.Scanner;

/*
 * Write a program to split the text into words and return the words along with their lengths in a 2D array
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in 
split() method and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length.
 Use String built-in function String.valueOf() to generate the String value for the number
The main function calls the user-defined method and displays the result in a tabular format. During display 
make sure to convert the length value from String to Integer and then display
*/

public class SplitTheTextWithLength {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input string from user
		System.out.print("Enter the String :");
		String text = sc.nextLine();
		
		// Get 2D array of words and their lengths
		String[][] TwoDArray= wordLengthArray(text);
		
		// Display each word with its length
		for(int i=0; i<TwoDArray.length;i++) {
			System.out.println(TwoDArray[i][0]+ " " + Integer.parseInt(TwoDArray[i][1]));
		}
		sc.close();
	}
	
	// Method to split the string into string array
	static String[] textSplitter(String text) {
		text.trim();
		
		// Count spaces to find number of words
		int spaces=0;
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i)==' ') {
				spaces++;
			}
		}
		
		// Create array for storing words
		String [] SArray = new String[spaces+1];
		String word = "";
		int count=0;
		
		// Extract words from text
		for(int i=0; i<text.length();i++) {
			
			if(text.charAt(i)==' ' || i==text.length()-1) {
				// Handle last character of text
				if (text.length()-1==i){
					word=word+text.charAt(i);
					SArray[count]=word;
					
				}else {
					SArray[count]=word;
					word="";
					count++;
				}
			}else {
				word=word+text.charAt(i);
			}
		}
		
		return SArray;	
	}
	
	// Method to calculate string length without using length() function
	static int lengthCalculation(String text) {
		int lt = 0;
		try {
			// Keep incrementing counter until exception
			for(int i=0; i<=i+2; i++) {
				text.charAt(i);
				lt++;
			}
		}
		catch(Exception e) {
			// Return count when out of bounds
			return lt;
		}
		return -1;
	}
	
	// Method to create 2D array with words and their lengths
	// Method to create 2D array with words and their lengths
	static String[][] wordLengthArray(String text){
		// Split text into words
		String[] WordArray = textSplitter(text);
		String[][] SArray = new String[WordArray.length][2];
		
		// Store each word with its length
		for(int i=0;i<WordArray.length;i++) {
			SArray[i][0] = WordArray[i];
			SArray[i][1] = String.valueOf(lengthCalculation(WordArray[i]));
		}
		return SArray;
	}

}







