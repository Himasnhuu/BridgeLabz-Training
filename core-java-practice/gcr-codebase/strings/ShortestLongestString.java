package Week_01.stringarray.level2;
import java.util.Scanner;

/*
 * Write a program to split the text into words and find the shortest and longest strings in a given text
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method 
and return the words.
Create a method to find and return a string's length without using the length() method. 
Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use
 String built-in function String.valueOf() to generate the String value for the number
Create a Method that takes the 2D array of word and corresponding length as parameters, find the shortest and
 longest string and return them in an 1D int array. 
The main function calls the user-defined methods and displays the result. 
*/

public class ShortestLongestString {

	public static void main(String[] args) {
		// Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		System.out.print(shortLongLength(text)[0]+" "+shortLongLength(text)[1]);
		
		sc.close();
		
	}
	
	
	//method to split the String into String Array
		static String[] textSplitter(String text) {
			text.trim();
			// Count spaces to determine array size
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
		
		//method to calculate the string without using length function
		
		static int lengthCalculation(String text) {
			int lt = 0;
			try {
				for(int i=0; i<=i+2; i++) {
					text.charAt(i);
					lt++;
				}
			}
			catch(Exception e) {
				return lt;
			}
			return -1;
		}
		
		//method to create the 2d Array
		static String[][] wordLengthArray(String text){
			String[] WordArray = textSplitter(text);
			String[][] SArray = new String[WordArray.length][2];
			for(int i=0;i<WordArray.length;i++) {
				SArray[i][0] = WordArray[i];
				SArray[i][1] = String.valueOf(lengthCalculation(WordArray[i]));
			}
			return SArray;
		}
		
		// method to find the shortest and longest word from the Array
		static int[] shortLongLength(String text) {
			String[][] TwoDArray = wordLengthArray(text);
			
			int min=Integer.parseInt(TwoDArray[0][1]), max=Integer.parseInt(TwoDArray[0][1]);
			for(int i=1; i<TwoDArray.length;i++) {
				if(min>Integer.parseInt(TwoDArray[i][1])) {
					min = Integer.parseInt(TwoDArray[i][1]);
				}
				if(max<Integer.parseInt(TwoDArray[i][1])) {
					max = Integer.parseInt(TwoDArray[i][1]);
				}
			}
			int[] lengthArray = {min, max};
			return lengthArray;
		}
	
	

}
