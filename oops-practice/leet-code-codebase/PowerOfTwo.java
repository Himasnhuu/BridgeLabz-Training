package leetcode;
import java.util.Scanner;
public class PowerOfTwo {
	
	public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        long num = 1;
        while (num < n) {
            num *= 2;
        }
        return num == n;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}
}
