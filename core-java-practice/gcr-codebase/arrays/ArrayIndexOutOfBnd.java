package Week_01.stringarray.level1;
import java.util.Scanner;
public class ArrayIndexOutOfBnd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Take input for array size
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();
		String [] names = new String [size];
		
		// Take input for names
		System.out.print("Enter the names : ");
		for(int i= 0; i < size; i++) {
			names[i]=sc.nextLine();
		}
		
		// Call exception handling method
		handlingEx(names);
		
		sc.close();
	}
	
	// Method to intentionally generate ArrayIndexOutOfBoundsException
	public static void generateEx(String[] names) {
		// Accessing invalid index (array.length is out of bounds)
		System.out.print(names[names.length]);
	}
	
	// Method to handle ArrayIndexOutOfBoundsException using try-catch
	public static void handlingEx(String[] names) {
		try {
			// Call method that generates exception
			generateEx(names);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			// Handle specific exception
			System.out.print("Error Handled : " + e.getMessage());
		}
		catch(RuntimeException e) {
			// Handle generic runtime exception
			System.out.print("Genric Error Handled : " +e.getMessage());
		}
	}

}



