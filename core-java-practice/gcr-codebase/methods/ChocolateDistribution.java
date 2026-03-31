package Week_01.javaMethods;
import java.util.Scanner;

public class ChocolateDistribution {
    
    // method to find chocolates per child and remaining chocolates
    public static int[] distributeChocolates(int numberOfChocolates, int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        
        return new int[]{chocolatesPerChild, remainingChocolates};
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();
        
        System.out.print("Enter number of children: ");
        int children = sc.nextInt();
        
        int[] result = distributeChocolates(chocolates, children);
        
        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
        
        sc.close();
    }
}
