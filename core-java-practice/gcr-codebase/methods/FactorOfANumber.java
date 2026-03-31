
/*Create a program to find the factors of a number taken as user input,  
 *  store the factors in an array,
 *  and display the factors. Also find the sum, sum of square of 
 *  factors and product of the factors and
 *   display the results
Hint => 
Take the input for a number
Write a static Method to find the factors of the number and save them in an array and return the array. 
To find factors and save to array will have two loops. The first loop to find the count and initialize 
the array with the count. And the second loop save the factors into the array
Write a method to find the sum of the factors using factors array
Write a method to find the product of the factors using factors array
Write a method to find the sum of square of the factors using Math.pow() method*/

package Week_01.javaMethods.level2;
import java.util.Scanner;
public class FactorOfANumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		
		System.out.print("Array of factors : ");
		int[] arr = findFactors(n);
		for(int x : arr) {
			System.out.print(x+" ");
		}
		
		System.out.println("\nsum : "+sumOfFactors(arr));
		System.out.println("product : "+productOfFactors(arr));
		System.out.println("sum of square : "+sumOfSquare(arr));
		
		sc.close();
	}
	
	//method to find the factors of a number
	static int[] findFactors(int n) {
		StringBuilder sb = new StringBuilder("");
		for(int i=2; i<(n/2)+1; i++) {
			 if(n%i==0) {
				 sb.append(i);
				 sb.append(" ");
			 }
		}
		String s = new String(sb);
		String[] arr =  s.split(" ");
		int [] ar = new int[arr.length];
		for(int i=0; i<ar.length; i++) {
			ar[i] = Integer.parseInt(arr[i]);
		}
		return ar;
	}
	
	//method to find the sum of array
	static int sumOfFactors(int[] arr) {
		int sum = 0;
		for(int x:arr) {
			sum+=x;
		}
		return sum;
	}
	
	//method to find the product of array
	static long productOfFactors(int[] arr) {
		long pro = 1;
		for(int x:arr) {
			pro*=x;
		}
		return pro;
	}
	
	//method to find the product of square of array
		static long sumOfSquare(int[] arr) {
			long sum = 1;
			for(int x:arr) {
				sum+=Math.pow(x, 2);
			}
			return sum;
		}
}


