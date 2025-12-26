
/*Write a program Quadratic to find the roots of the equation ax2+ bx + c. Use Math functions Math.pow() and Math.sqrt()
Hint => 
Take a, b, and c as input values to find the roots of x.
The roots are computed using the following formulae
delta = b2+ 4*a*c
If delta is positive the find the two roots using formulae 
root1 of x = (-b + delta)/(2*a) 
root1 of x = (-b - delta)/(2*a)
If delta is zero then there is only one root of x  
root of x = -b/(2*a)
If delta is negative return empty array or nothing 
Write a Method to find find the roots of a quadratic equation and return the roots
*/

package Week_01.javaMethods.level2;
import java.util.Scanner;
public class FindTheRoots {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		FindTheRoots roots = new FindTheRoots();
		
		System.out.print("Enter the value of a : ");
		int a = sc.nextInt();
		
		System.out.print("Enter the value of b : ");
		int b = sc.nextInt();
		
		System.out.print("Enter the value of c : ");
		int c = sc.nextInt();
		
		double[] arr = roots.calculateRoots(a,b,c);
		
		System.out.print("Roots of the Equation are : ");
		for(int i=0; i<arr.length; i++) {
			
			System.out.print(arr[i]+" ");
			
		}
		
		sc.close();
	}
	
	//method to Calculate the delta
	double calculateDelta(int a, int b, int c){
		return (Math.pow(b, 2)-4*a*c);
	}
	
	//method to find the roots of the quadratic equation
	double[] calculateRoots(int a, int b, int c) {
		double delta = calculateDelta(a,b,c);
		
		if(delta<=-1) {
			double[] arr = new double[1];
			return arr;
		}
		else if (delta==0) {
			double[] arr = new double[1];
			arr[0] = -b/(2*a);
			return arr;
		}else {
			double[] arr = new double[2];
			arr[0] = (-b+delta)/(2*a);
			arr[1] = (-b-delta)/(2*a);
			return arr;
		}
	}
}
