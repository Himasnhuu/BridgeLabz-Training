package Week_01.stringarray.level2;
import java.util.Scanner;

public class StringLengthCalculation {
	public static void main(String[] args) {
		// Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		System.out.print("Length of String : "+lengthCalculation(text));
		sc.close();
	}
	
	// Method to calculate length without using length() method
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
	
}
