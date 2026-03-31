package Week_01.javaMethods.level3;
import java.util.Scanner;

public class NumChecker {
    
    // method to find count of digits and store digits in array
    public static int[] storeDigits(int number) {
        int temp = number;
        int count = 0;
        
        // count number of digits
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        
        // store digits in array
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        
        return digits;
    }
    
    // method to find sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }
    
    // method to find sum of squares of digits
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], 2);
        }
        return sum;
    }
    
    // method to check if number is harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int digitSum = sumOfDigits(digits);
        return number % digitSum == 0;
    }
    
    // method to find frequency of each digit
    public static int[][] findDigitFrequency(int[] digits) {
        // count unique digits
        int[] tempFreq = new int[10]; // for digits 0-9
        
        for (int i = 0; i < digits.length; i++) {
            tempFreq[digits[i]]++;
        }
        
        // count how many unique digits exist
        int uniqueCount = 0;
        for (int i = 0; i < 10; i++) {
            if (tempFreq[i] > 0) {
                uniqueCount++;
            }
        }
        
        // create 2D array with digit and frequency
        int[][] frequency = new int[uniqueCount][2];
        int index = 0;
        
        for (int i = 0; i < 10; i++) {
            if (tempFreq[i] > 0) {
                frequency[index][0] = i;           // digit
                frequency[index][1] = tempFreq[i]; // frequency
                index++;
            }
        }
        
        return frequency;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // store digits in array
        int[] digits = storeDigits(number);
        
        
        // display digits
        System.out.print("Digits: ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("\nCount of digits: " + digits.length);
        
        // sum of digits
        int digitSum = sumOfDigits(digits);
        System.out.println("Sum of digits: " + digitSum);
        
        // sum of squares of digits
        int squareSum = sumOfSquares(digits);
        System.out.println("Sum of squares: " + squareSum);
        
        // check harshad number
        boolean isHarshad = isHarshadNumber(number, digits);
        System.out.println("Is Harshad number? " + isHarshad);
        
        // frequency of each digit
        int[][] frequency = findDigitFrequency(digits);
        System.out.println("\nDigit Frequency");
        System.out.println("Digit\tFrequency");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(frequency[i][0] + "\t" + frequency[i][1]);
        }
        
        sc.close();
    }
}
