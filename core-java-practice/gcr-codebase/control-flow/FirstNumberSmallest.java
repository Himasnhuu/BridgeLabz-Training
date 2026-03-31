package Week_01.FlowControl.Level1;


import java.util.Scanner;

// This program checks if the first number is the smallest among three numbers
class FirstNumberSmallest {
    public static void main(String[] args) {
       
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers ");
        
        // Input values for three numbers
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        
        // Checking if first number is smaller than both second and third
        if (number1 < number2 && number1 < number3) {
            System.out.println("Is the first number the smallest? true");
        } else {
            System.out.println("Is the first number the smallest? false");
        }
        
        // Closing the Scanner class
        sc.close();
       
    }
}
