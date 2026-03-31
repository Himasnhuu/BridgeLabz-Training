// 2. Insertion Sort - Sort Employee IDs
// Problem: Sort employee IDs in ascending order using Insertion Sort algorithm

import java.util.Arrays;

public class InsertionSort {
    
    /**
     * Sorts an array of employee IDs in ascending order using Insertion Sort.
     * 
     * Time Complexity: O(n²) - worst case, O(n) - best case (already sorted)
     * Space Complexity: O(1) - sorts in place
     * 
     * @param employeeIds Array of employee IDs (integers)
     */
    public static void insertionSort(int[] employeeIds) {
        
        // Get the length of the employeeIds array
        // This tells us how many employee IDs we need to sort
        int n = employeeIds.length;
        
        // Outer loop: Start from index 1 (second element)
        // We consider the first element (index 0) as already sorted
        // This loop picks each element one by one to insert into the sorted portion
        for (int i = 1; i < n; i++) {
            
            // Store the current element that needs to be inserted into sorted portion
            // This is the "key" element we'll place in its correct position
            int key = employeeIds[i];
            
            // Initialize j to point to the last element of the sorted portion
            // j will help us find the correct position for the key element
            int j = i - 1;
            
            // Inner loop: Move elements of sorted portion that are greater than key
            // This creates space for inserting the key element
            // Continue while:
            // 1. j >= 0 (we haven't reached the beginning of the array)
            // 2. employeeIds[j] > key (current element is greater than key)
            while (j >= 0 && employeeIds[j] > key) {
                
                // Shift the element one position to the right
                // This makes room for the key element to be inserted
                employeeIds[j + 1] = employeeIds[j];
                
                // Move j one position to the left to check the next element
                // We're moving backwards through the sorted portion
                j--;
            }
            
            // Insert the key element at its correct position
            // j + 1 is the correct position because:
            // - Either j became -1 (key is smallest), so j+1 = 0
            // - Or employeeIds[j] <= key, so key should go right after j
            employeeIds[j + 1] = key;
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
        
        // Sample test case: Array of employee IDs (unsorted)
        int[] employeeIds = {1005, 1002, 1008, 1001, 1003, 1007};
        
        // Print the original unsorted employee IDs
        printArray(employeeIds, "Original employee IDs: ");
        
        // Call the insertionSort method to sort the IDs
        // This will sort the array in ascending order
        insertionSort(employeeIds);
        
        // Print the sorted employee IDs
        printArray(employeeIds, "Sorted employee IDs (ascending): ");
        
        // Additional test case with small array
        System.out.println("\n--- Test Case 2: Small Array ---");
        int[] smallArray = {5, 2, 4, 1, 3};
        printArray(smallArray, "Small array: ");
        insertionSort(smallArray);
        printArray(smallArray, "After insertion sort: ");
        
        // Additional test case with already sorted array (best case)
        System.out.println("\n--- Test Case 3: Already Sorted Array ---");
        int[] alreadySorted = {1001, 1002, 1003, 1004, 1005};
        printArray(alreadySorted, "Already sorted IDs: ");
        insertionSort(alreadySorted);
        printArray(alreadySorted, "After insertion sort: ");
        
        // Additional test case with duplicate values
        System.out.println("\n--- Test Case 4: Array with Duplicates ---");
        int[] withDuplicates = {1005, 1002, 1005, 1001, 1002};
        printArray(withDuplicates, "IDs with duplicates: ");
        insertionSort(withDuplicates);
        printArray(withDuplicates, "After insertion sort: ");
        
        // Additional test case with reverse sorted array (worst case)
        System.out.println("\n--- Test Case 5: Reverse Sorted Array ---");
        int[] reverseSorted = {1009, 1007, 1005, 1003, 1001};
        printArray(reverseSorted, "Reverse sorted IDs: ");
        insertionSort(reverseSorted);
        printArray(reverseSorted, "After insertion sort: ");
    }
}
