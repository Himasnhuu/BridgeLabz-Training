package Week_01.stringarray.level1;
import java.util.Scanner;
public class ArrayIndexOutOfBnd {

	public static void main(String[] args) {
		// Take user input for array size
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();
		String [] names = new String [size];
		System.out.print("Enter the names : ");
		for(int i= 0; i < size; i++) {
			names[i]=sc.nextLine();
		}
		
		handlingEx(names);
		
		sc.close();
	}
	
	// Method to generate ArrayIndexOutOfBoundsException
	public static void generateEx(String[] names) {
		System.out.print(names[names.length]);
	}
	
	// Method to handle exception using try-catch
	public static void handlingEx(String[] names) {
		try {
			generateEx(names);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("Error Handled : " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.print("Genric Error Handled : " +e.getMessage());
		}
	}

}



