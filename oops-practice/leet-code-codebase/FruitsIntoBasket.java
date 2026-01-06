package leetcode;
import java.util.Scanner;
public class FruitsIntoBasket {
	
	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unplaced = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = 0;
                    unplaced--;
                    break;
                }
            }
        }

        return unplaced; 
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}
}

