
/*Write a program that generates five 4 digit random values and then finds their average value, and 
 * their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().
Hint => 
Write a method that generates array of 4 digit random numbers given the size as a parameter as shown 
in the method signature 
public int[] generate4DigitRandomArray(int size)
Write a method to find average, min and max value of an array 
public double[] findAverageMinMax(int[] numbers) */

package Week_01.javaMethods.level2;
import java.util.Scanner;
public class GenerateRandomValues {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GenerateRandomValues gr = new GenerateRandomValues();
		
		System.out.print("Enter the number of values you wants to generate : ");
		int num = sc.nextInt();
		
		int[] rv = gr.generate4DigitRandomArray(num);
		double[] result = gr.findAverageMinMax(rv);
		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
		
		
		sc.close();
	}
	
	//method to generate random numbers
	public int[] generate4DigitRandomArray(int size) {
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = (int)(Math.random()*9000)+1000;
		}
		return arr;
	}
	
	//method to perform the calculations
	public double[] findAverageMinMax(int[] n) {
		int size = n.length;
		double avg; 
		int sum=0;
		double min = n[0];
		double max = n[0];
		for(int i=0; i<size; i++) {
			if(min>n[i]) {
				min= n[i];
			}
			if(max<n[i]) {
				max = n[i];
			}
			
			sum+=n[i];
		}
		avg = sum/size;
		double[] arr = {avg, min, max};
		
		return arr;
		
	}
}
