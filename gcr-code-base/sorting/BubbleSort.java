// 1. Bubble Sort - Sort Student Marks
// Problem: Sort student marks in ascending order using Bubble Sort algorithm

import java.util.Arrays;

public class BubbleSort {
    
    /**
     * Sorts an array of student marks in ascending order using Bubble Sort.
     * 
     * Time Complexity: O(n²) - worst and average case
     * Space Complexity: O(1) - sorts in place
     * 
     * @param marks Array of student marks (integers)
     */
    public static void bubbleSort(int[] marks) {
        
        // Get the length of the marks array
        // This tells us how many students' marks we need to sort
        int n = marks.length;
        
        // Outer loop: Controls the number of passes through the array
        // We need (n-1) passes because after each pass, one element is guaranteed to be in its correct position
        // Loop runs from 0 to n-2 (n-1 times)
        for (int i = 0; i < n - 1; i++) {
            
            // Flag to optimize: Track if any swap occurred in this pass
            // If no swaps occur, the array is already sorted and we can exit early
            boolean swapped = false;
            
            // Inner loop: Compares adjacent elements and swaps if needed
            // We use (n - i - 1) because after each pass, the largest element "bubbles up" to the end
            // So we don't need to check the last i elements (they're already sorted)
            for (int j = 0; j < n - i - 1; j++) {
                
                // Compare current element with the next element
                // If current element is greater than next, they are in wrong order (for ascending sort)
                if (marks[j] > marks[j + 1]) {
                    
                    // Swap the elements using a temporary variable
                    // This puts the smaller element before the larger element
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    
                    // Set flag to true because we made a swap
                    // This means the array wasn't sorted yet
                    swapped = true;
                }
            }
            
            // Optimization: If no swaps occurred in this entire pass,
            // the array is already sorted, so we can break early
            if (!swapped) {
                break;
            }
        }
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
        
        // Sample test case: Array of student marks (unsorted)
        int[] studentMarks = {64, 34, 25, 12, 22, 11, 90};
        
        // Print the original unsorted marks
        printArray(studentMarks, "Original student marks: ");
        
        // Call the bubbleSort method to sort the marks
        // This will sort the array in ascending order
        bubbleSort(studentMarks);
        
        // Print the sorted marks
        printArray(studentMarks, "Sorted student marks (ascending): ");
        
        // Additional test case with already sorted array
        System.out.println("\n--- Test Case 2: Already Sorted Array ---");
        int[] alreadySorted = {10, 20, 30, 40, 50};
        printArray(alreadySorted, "Already sorted marks: ");
        bubbleSort(alreadySorted);
        printArray(alreadySorted, "After bubble sort: ");
        
        // Additional test case with reverse sorted array (worst case)
        System.out.println("\n--- Test Case 3: Reverse Sorted Array ---");
        int[] reverseSorted = {90, 80, 70, 60, 50};
        printArray(reverseSorted, "Reverse sorted marks: ");
        bubbleSort(reverseSorted);
        printArray(reverseSorted, "After bubble sort: ");
        
        // Additional test case with duplicate values
        System.out.println("\n--- Test Case 4: Array with Duplicates ---");
        int[] withDuplicates = {50, 30, 50, 20, 30};
        printArray(withDuplicates, "Marks with duplicates: ");
        bubbleSort(withDuplicates);
        printArray(withDuplicates, "After bubble sort: ");
    }
}
