
/*Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods
 *  and display results. Make sure all are static methods
Hint => 
Method to Find the count of digits in the number
Method to Store the digits of the number in a digits array
Method to Check if a number is a duck number using the digits array. A duck number is a number that
 has a non-zero digit present in it
Method to check if the number is a armstrong number using the digits array. ​​Armstrong number is a number
 that is equal to the sum of its own digits raised to the power of the number of digits. Eg: 153 = 1^3 + 5^3 + 3^3
Method to find the largest and second largest elements in the digits array. Use Integer.MIN_VALUE to 
initialize the variable.
Method to find the the smallest and second smallest elements in the digits array. Use Integer.MAX_VALUE to initialize the variable.*/


package Week_01.javaMethods.level3;
import java.util.Arrays;
import java.util.Scanner;
public class NumberChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		
		System.out.println("count of the digits : "+count(n));
		System.out.print("digit Array : ");
		char[] ch = digitArray(n);
		for(char x:ch) {
			System.out.print(x+" ");
		}
		
		System.out.println("\nduck number : "+duckNumber(ch));
		
		System.out.println("Armstrong number : "+armstrongNo(ch));
		
		int[] l = findLargestAndSecondLargest(ch);
		System.out.print("Largest : "+l[0]+"\tSecond Largest : "+l[1]);
		
		int[] s = findSmallestAndSecondSmallest(ch);
		System.out.print("\nSmallest : "+l[0]+"\tSecond Smallest : "+l[1]);
		

		sc.close();
	}
	
	//method to count the digits
	static int count(int n) {
		String c = String.valueOf(n);
		return c.length();
	}
	
	//method to create digits array
	static char[] digitArray(int n) {
		return Integer.toString(n).toCharArray();
	}
	
	//method to check the duck number
	static boolean duckNumber(char[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='0') {
				return false;
			}
		}
		return true;
	}
	
	//Method to check if the number is a armstrong number
	static boolean armstrongNo(char [] arr) {
		double n = Integer.parseInt(String.valueOf(arr));
		double sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=Math.pow(Integer.parseInt((String.valueOf(arr[i]))), 2);
		}
		
		if (sum==n) {
			return true;
		}
		return false;
	}
	
	//Method to find the largest and second largest elements in the digits array
	static int[] findLargestAndSecondLargest(char[] arr) {
		int max = Integer.MIN_VALUE;
		int smax = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(max<Integer.parseInt(String.valueOf(arr[i]))) {
				smax = max;
				max = Integer.parseInt(String.valueOf(arr[i]));
				
			}
			else if((Integer.parseInt(String.valueOf(arr[i]))>smax) && (Integer.parseInt(String.valueOf(arr[i]))!=max)) {
				smax=Integer.parseInt(String.valueOf(arr[i]));
			}
		}
		
		return new int[] {max, smax};
	}
	
	//Method to find the smallest and second smallest elements in the digits array
		static int[] findSmallestAndSecondSmallest(char[] arr) {
			int min = Integer.MAX_VALUE;
			int smin = Integer.MAX_VALUE;
			for(int i=0; i<arr.length; i++) {
				if(min>Integer.parseInt(String.valueOf(arr[i]))) {
					smin = min;
					min = Integer.parseInt(String.valueOf(arr[i]));
					
				}
				else if((Integer.parseInt(String.valueOf(arr[i]))<smin) && (Integer.parseInt(String.valueOf(arr[i]))!=min)) {
					smin=Integer.parseInt(String.valueOf(arr[i]));
				}
			}
			
			return new int[] {min, smin};
		}
}
