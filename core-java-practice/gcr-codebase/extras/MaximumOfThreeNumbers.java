package Week_01.javaMethods.extras;
import java.util.Scanner;

public class MaximumOfThreeNumbers {
    
    public static void main(String[] args) {
        
        System.out.println("MAXIMUM OF THREE NUMBERS\n");
        
        // take three integer inputs
        int[] numbers = takeInput();
        
        // find maximum value
        int max = findMaximum(numbers[0], numbers[1], numbers[2]);
        
        // display result
        displayResult(numbers[0], numbers[1], numbers[2], max);
        
    }
    
    
    //Method to take three integer inputs from user 
    static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[3];
        
        System.out.println("Enter three integer numbers:");
        
        System.out.print("First number: ");
        numbers[0] = sc.nextInt();
        
        System.out.print("Second number: ");
        numbers[1] = sc.nextInt();
        
        System.out.print("Third number: ");
        numbers[2] = sc.nextInt();
        
        sc.close();
        return numbers;
    }
    
    //Method to find maximum of three numbers
    static int findMaximum(int num1, int num2, int num3) {
        int max;
        
        if (num1 >= num2 && num1 >= num3) {
            max = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            max = num2;
        } else {
            max = num3;
        }
        
        return max;
    }
    
    //Method to display the result
    static void displayResult(int num1, int num2, int num3, int max) {
        System.out.println("\nResult");
        System.out.println("Numbers entered: " + num1 + ", " + num2 + ", " + num3);
        System.out.println("Maximum number: " + max);
    }
}
