// 5. Selection Sort - Sort Exam Scores
// Problem: Sort exam scores in ascending order using Selection Sort algorithm

import java.util.Arrays;

public class SelectionSort {
    
    /**
     * Sorts an array of exam scores in ascending order using Selection Sort.
     * 
     * Time Complexity: O(n²) - in all cases (best, average, worst)
     * Space Complexity: O(1) - sorts in place
     * 
     * @param scores Array of exam scores (integers)
     */
    public static void selectionSort(int[] scores) {
        
        // Get the length of the scores array
        // This tells us how many exam scores we need to sort
        int n = scores.length;
        
        // Outer loop: Iterate through each position in the array
        // We go from 0 to n-2 because the last element will automatically be in place
        // i represents the current position where we want to place the minimum element
        for (int i = 0; i < n - 1; i++) {
            
            // Assume the current position (i) has the minimum value
            // minIndex will store the index of the smallest element in the unsorted portion
            int minIndex = i;
            
            // Inner loop: Find the minimum element in the unsorted portion
            // Start from i+1 and go to the end of the array
            // This searches through all unsorted elements
            for (int j = i + 1; j < n; j++) {
                
                // If we find an element smaller than our current minimum
                // Update minIndex to point to this smaller element
                if (scores[j] < scores[minIndex]) {
                    // Update the index of minimum element
                    minIndex = j;
                }
            }
            
            // After finding the minimum element in unsorted portion,
            // swap it with the element at current position (i)
            // This places the minimum element at its correct sorted position
            // Only swap if minIndex has changed (optimization to avoid unnecessary swaps)
            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
        }
    }
    
    /**
     * Selection Sort with step-by-step details for learning purposes.
     * Prints each step of the sorting process.
     * 
     * @param scores Array of exam scores
     */
    public static void selectionSortWithDetails(int[] scores) {
        
        // Get the length of the array
        int n = scores.length;
        
        // Print initial state
        System.out.println("Initial array: " + Arrays.toString(scores));
        System.out.println("--------------------------------------------------");
        
        // Outer loop through each position
        for (int i = 0; i < n - 1; i++) {
            
            // Start with current position as minimum
            int minIndex = i;
            
            // Print current iteration information
            System.out.println("\nPass " + (i + 1) + ":");
            System.out.println("  Looking for minimum in unsorted portion [index " + i + " to " + (n-1) + "]");
            
            // Find minimum in unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Print what we found
            System.out.println("  Minimum value found: " + scores[minIndex] + " at index " + minIndex);
            
            // Swap if needed
            if (minIndex != i) {
                System.out.println("  Swapping " + scores[i] + " (index " + i + ") with " + scores[minIndex] + " (index " + minIndex + ")");
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            } else {
                System.out.println("  No swap needed (minimum already at correct position)");
            }
            
            // Print state after this pass
            System.out.println("  Array after pass " + (i + 1) + ": " + Arrays.toString(scores));
            
            // Print sorted and unsorted portions
            System.out.print("  Sorted portion: [");
            for (int k = 0; k <= i; k++) {
                System.out.print(scores[k]);
                if (k < i) System.out.print(", ");
            }
            System.out.print("], Unsorted portion: [");
            for (int k = i + 1; k < n; k++) {
                System.out.print(scores[k]);
                if (k < n - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
        
        System.out.println("\n==================================================");
        System.out.println("Final sorted array: " + Arrays.toString(scores));
    }
    
    /**
     * Helper method to print an array
     * 
     * @param arr Array to print
     * @param message Message to display before the array
     */
    public static void printArray(int[] arr, String message) {
        // Print the message followed by the array contents
        System.out.println(message + Arrays.toString(arr));
    }
    
    /**
     * Main method - Entry point of the program
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        
        // Sample test case: Array of exam scores (unsorted)
        int[] examScores = {85, 92, 73, 68, 95, 78, 88};
        
        // Print the original unsorted scores
        printArray(examScores, "Original exam scores: ");
        
        // Call the selectionSort method to sort the scores
        // This will sort the array in ascending order
        selectionSort(examScores);
        
        // Print the sorted scores
        printArray(examScores, "Sorted exam scores (ascending): ");
        
        // Detailed example with step-by-step output
        System.out.println("\n==================================================");
        System.out.println("DETAILED STEP-BY-STEP EXAMPLE");
        System.out.println("==================================================");
        int[] detailedScores = {64, 25, 12, 22, 11};
        selectionSortWithDetails(detailedScores);
        
        // Additional test case with already sorted array
        System.out.println("\n==================================================");
        System.out.println("--- Test Case 2: Already Sorted Array ---");
        int[] alreadySorted = {60, 70, 80, 90, 100};
        printArray(alreadySorted, "Already sorted scores: ");
        selectionSort(alreadySorted);
        printArray(alreadySorted, "After selection sort: ");
        
        // Additional test case with reverse sorted array
        System.out.println("\n--- Test Case 3: Reverse Sorted Array ---");
        int[] reverseSorted = {100, 90, 80, 70, 60};
        printArray(reverseSorted, "Reverse sorted scores: ");
        selectionSort(reverseSorted);
        printArray(reverseSorted, "After selection sort: ");
        
        // Additional test case with duplicate values
        System.out.println("\n--- Test Case 4: Array with Duplicates ---");
        int[] withDuplicates = {85, 70, 85, 60, 70, 95};
        printArray(withDuplicates, "Scores with duplicates: ");
        selectionSort(withDuplicates);
        printArray(withDuplicates, "After selection sort: ");
    }
}
