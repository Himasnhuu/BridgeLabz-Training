package Week_01.stringarray.level1;
import java.util.Scanner;

public class IllegalArgumentEx {

	public static void main(String[] args) {
		// Take user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String text = sc.nextLine();
		
		handelingException(text);
		sc.close();
		
	}
	
	// Method to generate IllegalArgumentException
	public static void generateException(String text) {
		System.out.println("Here the Exception will be generated" + text.substring(text.length(),0));
	}
	
	// Method to handle exception
	public static void handelingException(String text) {
		try {
			generateException(text);
		}
		catch(IllegalArgumentException ex){
			System.out.println("Error Handeled :" + ex.getMessage());
		}
		catch(Exception ex) {
			System.out.print("Generic Exception :" +ex.getMessage());
		}
		
	}

}
