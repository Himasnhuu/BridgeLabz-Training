package leetcode;
import java.util.*;

public class PascalTriangle {
	
	public static List<List<Integer>> generate(int numRows) {
        // create 2d array to store pascal's triangle
        int[][] triangle = new int[numRows][];
        
        // initialize each row with appropriate size
        for (int i = 0; i < numRows; i++) {
            triangle[i] = new int[i + 1];
            
            // set first and last element of each row to 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;
        }
        
        // calculate middle elements
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        
        // convert int[][] to List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle[i].length; j++) {
                row.add(triangle[i][j]);
            }
            result.add(row);
        }
        
        return result;
    }
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of rows : ");
		int n = sc.nextInt();
		System.out.println(generate(n));
		sc.close();
	}
}
