package Week_01.arrays.level2;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input for a number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        
        // Find count of digits
        long tempNumber = Math.abs(number);
        int digitCount = 0;
        long temp = tempNumber;
        
        if (temp == 0) {
            digitCount = 1;
        } else {
            while (temp != 0) {
                temp = temp / 10;
                digitCount++;
            }
        }
        
        // Find digits and save in array
        int[] digits = new int[digitCount];
        int index = 0;
        
        if (tempNumber == 0) {
            digits[0] = 0;
        } else {
            while (tempNumber != 0) {
                digits[index] = (int)(tempNumber % 10);
                tempNumber = tempNumber / 10;
                index++;
            }
        }
        
        // Define frequency array of size 10 (for digits 0-9)
        int[] frequency = new int[10];
        
        // Loop through digits array and increase frequency
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        // Display frequency of each digit
        System.out.println("\n===== Digit Frequency Report =====");
        System.out.println("Digit\tFrequency");
        System.out.println("-----\t---------");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + "\t" + frequency[i]);
            }
        }
        
        sc.close();
    }
}
