package Week_01.javaMethods.level2;
import java.util.Scanner;

public class YoungestTallestFriend {
    
    // method to find the youngest friend
    public static String findYoungest(int[] ages, String[] names) {
        int minAge = ages[0];
        int index = 0;
        
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                index = i;
            }
        }
        
        return names[index];
    }
    
    // method to find the tallest friend
    public static String findTallest(double[] heights, String[] names) {
        double maxHeight = heights[0];
        int index = 0;
        
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                index = i;
            }
        }
        
        return names[index];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // take user input for ages and heights
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for " + names[i] + ":");
            System.out.print("Age: ");
            ages[i] = sc.nextInt();
            System.out.print("Height (in feet): ");
            heights[i] = sc.nextDouble();
        }
        
        // find youngest and tallest
        String youngest = findYoungest(ages, names);
        String tallest = findTallest(heights, names);
        
        // display results
        System.out.println("\nYoungest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);
        
        sc.close();
    }
}
