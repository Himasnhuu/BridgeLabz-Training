
/*Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.
Hint => 
Simple Interest = Principal * Rate * Time / 100
Take user input for principal, rate, time
Write a method to calculate the simple interest given principle, rate and time as parameters
Output “The Simple Interest is ___ for Principal ___, Rate of Interest ___ and Time ___”
*/

package Week_01.javaMethods;
import java.util.Scanner;
public class CalculateSI {
	
	//method that will calculate SI
	static double simpleInterest(double p, double r, double t) {
		return (p*r*t)/100;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Principal : ");
		double p = sc.nextDouble();
		
		System.out.print("Enter the rate : ");
		double r = sc.nextDouble();
		
		System.out.print("Enter the time(in years) : ");
		double t = sc.nextDouble();
		
		double si = simpleInterest(p,r,t);
		System.out.print("Simple Interest : "+si);

		sc.close();
	}
}
