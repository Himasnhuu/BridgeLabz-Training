package Week_01.stringarray.level1;
import java.util.Scanner;

public class NumberFormatEx {

	public static void main(String[] args) {
		// Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Entger the String :");
		String text = sc.nextLine();
		handlingException(text);
		sc.close();
	}
	
	// Method to generate NumberFormatException
	public static void generateEx(String text) {
		int n = Integer.parseInt(text);
	}
	
	// Method to handle exception
	public static void handlingException(String text) {
		try {
			generateEx(text);
		}
		catch(NumberFormatException e) {
			System.out.print("Error Handled : " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.print("Generic Error Handled : " + e.getMessage());
		}
	}
	
	

}



