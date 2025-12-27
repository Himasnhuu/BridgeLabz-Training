package leetcode;
import java.util.Scanner;
public class PowerOfThree {
	
	public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        } else if ( n == 1) {
            return true;
        } else {
            while (n % 3 == 0) {
                n = n / 3;
            }
            if ( n == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}
}
