package Week_01.stringarray.level1;
import java.util.Scanner;

public class NumberFormatEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input string from user
		System.out.print("Entger the String :");
		String text = sc.nextLine();
		
		// Call exception handling method
		handlingException(text);
		sc.close();
	}
	
	// Method to intentionally generate NumberFormatException
	public static void generateEx(String text) {
		// Parsing non-numeric string throws NumberFormatException
		int n = Integer.parseInt(text);
	}
	
	// Method to handle NumberFormatException using try-catch
	public static void handlingException(String text) {
		try {
			// Call method that generates exception
			generateEx(text);
		}
		catch(NumberFormatException e) {
			// Handle specific exception
			System.out.print("Error Handled : " + e.getMessage());
		}
		catch(RuntimeException e) {
			// Handle generic runtime exception
			System.out.print("Generic Error Handled : " + e.getMessage());
		}
	}
	
	

}



