package Week_01.arrays.level1;
import java.util.Scanner;

public class ComparingElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Create array of size 5
		int [] arr = new int[5];
		
		// Take input for array elements
		System.out.println("Enter the values in an array : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// Check each element and classify as positive/negative and even/odd
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>0) {
				if(arr[i]%2==0) {
					System.out.println(arr[i]+" is Positive even number");
				}else {
					System.out.println(arr[i]+" is Positive odd number");
				}
			}else {
				if(arr[i]==0) {
					System.out.println(arr[i]+" is Zero");
				}else {
					System.out.println(arr[i]+" is Negative number");
				}
			}
		}
		
		// Comparison between first and last element of the array
		if(arr[0]>arr[arr.length-1]) {
			System.out.println(arr[0]+" is greater than "+arr[arr.length-1]);
		}
		else if(arr[0]<arr[arr.length-1]){
			System.out.println(arr[0]+" is smaller than "+arr[arr.length-1]);
		}else {
			System.out.println(arr[0]+" is equal to "+arr[arr.length-1]);
		}
	}

}
