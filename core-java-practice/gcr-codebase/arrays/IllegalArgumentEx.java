package Week_01.stringarray.level1;
import java.util.Scanner;

public class IllegalArgumentEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Take input string from user
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		// Call exception handling method
		handelingException(text);
		sc.close();
		
	}
	
	// Method to intentionally generate IllegalArgumentException
	public static void generateException(String text) {
		// substring with begin > end throws IllegalArgumentException
		System.out.println("Here the Exception will be generated" + text.substring(text.length(),0));
	}
	
	// Method to handle IllegalArgumentException using try-catch
	public static void handelingException(String text) {
		try {
			// Call method that generates exception
			generateException(text);
		}
		catch(IllegalArgumentException ex){
			// Handle specific exception
			System.out.println("Error Handeled :" + ex.getMessage());
		}
		catch(Exception ex) {
			// Handle generic exception
			System.out.print("Generic Exception :" +ex.getMessage());
		}
		
	}

}
