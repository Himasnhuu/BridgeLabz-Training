package Week_01.stringarray.level2;
import java.util.Scanner;

public class StringLengthCalculation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input string from user
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		// Display calculated length
		System.out.print("Length of String : "+lengthCalculation(text));
		sc.close();
	}
	
	// Method to calculate string length without using length() method
	static int lengthCalculation(String text) {
		int lt = 0;
		try {
			// Keep incrementing until exception occurs
			for(int i=0; i<=i+2; i++) {
				text.charAt(i);
				lt++;
			}
		}
		catch(Exception e) {
			// Exception occurs when index is out of bounds
			return lt;
		}
		return -1;
	}
	
}
