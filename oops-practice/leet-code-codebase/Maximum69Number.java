package leetcode;
import java.util.Scanner;
public class Maximum69Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int n = sc.nextInt();
		System.out.println(maximum69Number(n));
		sc.close();
	}
	
	public static int maximum69Number (int num) {
        return Integer.parseInt(  //parseInt use to convert string to int
            String.valueOf(num).replaceFirst("6", "9")  
        );
}
}
