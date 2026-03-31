package Week_01.javaMethods.level3;
import java.util.Scanner;

public class FactorOperations {
    
    // method to find factors and return as array
    public static int[] findFactors(int number) {
        // first loop: count factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        
        // second loop: store factors in array
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        
        return factors;
    }
    
    // method to find greatest factor
    public static int findGreatestFactor(int[] factors) {
        int greatest = factors[0];
        
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] > greatest) {
                greatest = factors[i];
            }
        }
        
        return greatest;
    }
    
    // method to find sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        
        return sum;
    }
    
    // method to find product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        
        return product;
    }
    
    // method to find product of cube of factors
    public static double productOfCubeFactors(int[] factors) {
        double product = 1;
        
        for (int i = 0; i < factors.length; i++) {
            product *= Math.pow(factors[i], 3);
        }
        
        return product;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        int[] factors = findFactors(number);
        
        System.out.println();
        
        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
        
        System.out.println("Total factors: " + factors.length);
        System.out.println("Greatest factor: " + findGreatestFactor(factors));
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Product of cube of factors: " + productOfCubeFactors(factors));
        
        sc.close();
    }
}
