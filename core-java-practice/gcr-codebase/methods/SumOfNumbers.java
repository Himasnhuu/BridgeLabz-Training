
/*Write a program to find the sum of n natural numbers using recursive method and compare 
 * the result with the formulae n*(n+1)/2 and show the result from both computations is 
 * correct. 
Hint => 
Take the user input number and check whether it's a Natural number
Write a Method to find the sum of n natural numbers using recursion
Write a Method to find the sum of n natural numbers using the formulae n*(n+1)/2 
Compare the two results and print the result
*/

package Week_01.javaMethods.level2;
import java.util.Scanner;
public class SumOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Natural Number : ");
		int n;
		while(true) {
			n = sc.nextInt();
			if (n>0) {
				System.out.println("Recursion sum : "+sumOfNum(n-1));
				System.out.println("Formula sum : "+formulaSum(n));
				
				break;
			}else {
				System.out.println("Enter a valid number again");
			}
		}

		sc.close();
	}
	
	//method to find the sum of natural numbers using recursion
	static int sumOfNum(int n) {
		if (n==1) {
			return 1;
		}else {
			{
				return n+sumOfNum(n-1);
			}
		}
	}
	
	//method to find the the sum of numbers using formula
	static int formulaSum(int n) {
		int sum = n*((n-1)/2);
		return sum;
	}
}
