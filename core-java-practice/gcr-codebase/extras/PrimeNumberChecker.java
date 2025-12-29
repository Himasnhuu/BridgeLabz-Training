package Week_01.javaMethods.extras;
import java.util.Scanner;

public class PrimeNumberChecker {
    
    public static void main(String[] args) {
        
        System.out.println("PRIME NUMBER CHECKER\n");
        
        // take input from user
        int number = getInput();
        
        // check if number is prime
        boolean isPrime = checkPrime(number);
        
        // display result
        displayResult(number, isPrime);
        
    }
    
    //Method to get number input from user
    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int num = sc.nextInt();
        sc.close();
        return num;
    }
    
    /**
     * Method to check if a number is prime
     * @param num number to check
     * @return true if prime, false otherwise
     */
    static boolean checkPrime(int num) {
        // numbers less than or equal to 1 are not prime
        if (num <= 1) {
            return false;
        }
        
        // 2 and 3 are prime numbers
        else if (num == 2 || num == 3) {
            return true;
        }
        
        else {
        	// check divisibility from 3 to sqrt(num)
            for (int i = 2; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0) {
                    return false;
                }
        	
        }
      
        }
        
        return true;
    }
    
    //Method to display the result
    static void displayResult(int number, boolean isPrime) {
    	
        System.out.println("\nNumber: " + number);
        if (isPrime) {
            System.out.println(number + " is a PRIME number.");
        } else {
            System.out.println(number + " is NOT a prime number.");
        }
    }
}
