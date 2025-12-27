package leetcode;
import java.util.Scanner;
public class ReverseTheInteger {
	
	//method to reverse the integer
	public static int reverse(int x) {
        int num = Math.abs(x);  // removing negative sign if present
        
        int rev = 0;  // Reversed number
        
        while (num != 0) {
            int ld = num % 10;  // getting Last digit 
            
            // Overflow check
            if (rev > (Integer.MAX_VALUE - ld) / 10) {
                return 0;  // return 0 if overflow
            }
            
            rev = rev * 10 + ld;  // Adding digits in the reverse
            num = num / 10;  // removing last digit
        }
        
        return (x < 0) ? (-rev) : rev;  // adding sign if present in the original number
    }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		System.out.print("\nReversed number : "+reverse(n));
		sc.close();
	}
}

