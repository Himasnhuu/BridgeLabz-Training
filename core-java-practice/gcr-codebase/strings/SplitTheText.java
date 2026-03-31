package Week_01.stringarray.level2;
import java.util.Scanner;

/*
 * Write a program to split the text into words, compare the result with the split() method and display the result 
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to find the length of the String without using the built-in length() method. 
Create a Method to split the text into words using the charAt() method without using the String 
built-in split() method and return the words. Use the following logic
Firstly Count the number of words in the text and create an array to store the indexes of the spaces 
for each word in a 1D array
Then Create an array to store the words and use the indexes to extract the words
Create a method to compare the two String arrays and return a boolean
The main function calls the user-defined method and the built-in split() method. Call the user defined 
method to compare the two string arrays and display the result
*/

public class SplitTheText {

	public static void main(String[] args) {
		// Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		System.out.print("Result = " +StringArrayComparison(text));
		
		sc.close();
	}
	
	// custom method to split the array
	static String[] textSplitter(String text) {
		text.trim();
		// Count spaces for array sizing
		int spaces=0;
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i)==' ') {
				spaces++;
			}
		}
		String [] SArray = new String[spaces+1];
		String word = "";
		int count=0;
		for(int i=0; i<text.length();i++) {
			
			if(text.charAt(i)==' ' || i==text.length()-1) {
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
	
	// method to compare the String Arrays
	static boolean StringArrayComparison(String text) {
		
		String[] first = textSplitter(text);
		String[] second = text.split(" ");
		
		if (first.length != second.length) {
			return false;
		}
		
		for(int i=0; i<first.length; i++) {
			if (!(first[i].equals(second[i]))) {
				return false;
			}
		}
		return true;
	}

}
