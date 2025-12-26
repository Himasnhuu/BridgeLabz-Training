package Week_01.javaMethods;
import java.util.Scanner;

public class CheckNumberSign {
    
    // method to check if number is positive, negative or zero
    public static int checkSign(int number) {
        if (number > 0) {
            return 1;  
        } else if (number < 0) {
            return -1;  
        } else {
            return 0;  
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int result = checkSign(num);
        
        if (result == 1) {
            System.out.println(num + " is positive");
        } else if (result == -1) {
            System.out.println(num + " is negative");
        } else {
            System.out.println(num + " is zero");
        }
        
        sc.close();
    }
}
