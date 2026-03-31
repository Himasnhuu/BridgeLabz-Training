package scenariobased;
import java.util.Scanner;
import java.util.Arrays;

public class LineComparisonProblem {
    
    public static void main(String[] args) {
        
        // display welcome message
        System.out.println("WELCOME TO LINE COMPARISON COMPUTATION PROGRAM.\n");
        System.out.println("-------------------------------------------------------------------");
        
        int [] userInputs = takingInput();
        int x1 = userInputs[0];
        int y1 = userInputs[1];
        int x2 = userInputs[2];
        int y2 = userInputs[3];
        
        // UC1: calculate length of a line
        double length1 = useCase1(x1, y1, x2, y2);
        System.out.printf("UC1 - Length of Line 1: %.2f\n",length1);
        System.out.println("-------------------------------------------------------------------");
        
        
        // UC2: check equality of two lines
        double length2 = useCase1(4, 8, 2, 6);
        boolean areEqual = useCase2(length1, length2);
        System.out.printf("UC2 - Line 1 Length: %.2f\n", length1);
        System.out.printf("    - Line 2 Length: %.2f\n", length2);
        System.out.println("    - Lines are equal: " + areEqual);
        System.out.println("-------------------------------------------------------------------");
        
        // UC3: compare two lines (greater, less, or equal)
        double length3 = useCase1(0, 0, 6, 8);
        String comparisonResult = useCase3(length1, length3);
        System.out.printf("UC3 - Line 1 Length: %.2f\n",length1);
        System.out.printf("    - Line 3 Length: %.2f\n", length3);
        System.out.print("    - Comparison: ");
        System.out.print(comparisonResult+"\n");
        
        
        
        System.out.println("-------------------------------------------------------------------");
    }
    
    static int[] takingInput() {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the values of x1, y1, x2 & y2 seperated by space : ");
    	int[] ar = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	return ar;
    	
    	
    }
    
    // UC1: calculate length of a line using distance formula
    // length = sqrt((x2 - x1)^2 + (y2 - y1)^2)
    static double useCase1(int x1, int y1, int x2, int y2) {
        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return length;
    }
    
    // UC2: check equality of two lines using equals method
    static boolean useCase2(double length1, double length2) {
        return String.valueOf(length1).equals(String.valueOf(length2));
    }
    
    // UC3: compare two lines using compareTo method
    // returns positive if length1 > length2
    // returns negative if length1 < length2
    // returns 0 if length1 == length2
    static String useCase3(double length1, double length2) {
        int comparisonResult =  Double.valueOf(length1).compareTo(Double.valueOf(length2));
        
        if (comparisonResult > 0) {
            return "Line 1 is GREATER than Line 3";
        } else if (comparisonResult < 0) {
            return "Line 1 is LESS than Line 3";
        } else {
            return "Line 1 is EQUAL to Line 3";
        }
        
    }
}
