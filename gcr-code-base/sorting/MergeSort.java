// 3. Merge Sort - Sort an Array of Book Prices
// Problem: Sort book prices in ascending order using Merge Sort algorithm

import java.util.Arrays;

public class MergeSort {
    
    /**
     * Sorts an array of book prices in ascending order using Merge Sort.
     * 
     * Time Complexity: O(n log n) - in all cases (best, average, worst)
     * Space Complexity: O(n) - requires additional space for merging
     * 
     * @param prices Array of book prices (integers)
     */
    public static void mergeSort(int[] prices) {
        
        // Base case: If array has 1 or 0 elements, it's already sorted
        // This is the stopping condition for the recursion
        if (prices.length <= 1) {
            return;
        }
        
        // Find the middle index to divide the array into two halves
        // Using integer division to get the middle point
        int mid = prices.length / 2;
        
        // Create left half array (from start to mid)
        // This creates a new array containing elements from index 0 to mid-1
        int[] leftHalf = new int[mid];
        
        // Create right half array (from mid to end)
        // This creates a new array containing elements from index mid to end
        int[] rightHalf = new int[prices.length - mid];
        
        // Copy elements to left half
        // Loop through first half and copy each element
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = prices[i];
        }
        
        // Copy elements to right half
        // Loop through second half and copy each element
        // i - mid calculates the correct index in rightHalf array
        for (int i = mid; i < prices.length; i++) {
            rightHalf[i - mid] = prices[i];
        }
        
        // Recursively sort the left half
        // This will keep dividing the left half until we reach base case
        // Then it will start merging back up
        mergeSort(leftHalf);
        
        // Recursively sort the right half
        // This will keep dividing the right half until we reach base case
        // Then it will start merging back up
        mergeSort(rightHalf);
        
        // Merge the two sorted halves back into the original array
        // This is where the actual sorting happens
        merge(prices, leftHalf, rightHalf);
    }
    
    /**
     * Merges two sorted arrays into one sorted array.
     * 
     * @param prices Original array to store merged result
     * @param left Sorted left half array
     * @param right Sorted right half array
     */
    private static void merge(int[] prices, int[] left, int[] right) {
        
        // Initialize three pointers
        // i points to current element in left array
        int i = 0;
        // j points to current element in right array
        int j = 0;
        // k points to current position in original array
        int k = 0;
        
        // Compare elements from left and right arrays and merge them in sorted order
        // Continue while both arrays have elements remaining
        while (i < left.length && j < right.length) {
            
            // If current element in left is smaller or equal
            // Add it to original array and move left pointer forward
            if (left[i] <= right[j]) {
                prices[k] = left[i];
                // Move to next element in left array
                i++;
            } else {
                // Current element in right is smaller
                // Add it to original array and move right pointer forward
                prices[k] = right[j];
                // Move to next element in right array
                j++;
            }
            // Move to next position in original array
            k++;
        }
        
        // If there are remaining elements in left array
        // (right array is exhausted), add all remaining left elements
        // These are already sorted, so we can copy them directly
        while (i < left.length) {
            prices[k] = left[i];
            i++;
            k++;
        }
        
        // If there are remaining elements in right array
        // (left array is exhausted), add all remaining right elements
        // These are already sorted, so we can copy them directly
        while (j < right.length) {
            prices[k] = right[j];
            j++;
            k++;
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
        
        // Sample test case: Array of book prices (unsorted)
        int[] bookPrices = {299, 150, 450, 200, 350, 100, 500};
        
        // Print the original unsorted prices
        printArray(bookPrices, "Original book prices: ");
        
        // Call the mergeSort method to sort the prices
        // This will sort the array in ascending order
        mergeSort(bookPrices);
        
        // Print the sorted prices
        printArray(bookPrices, "Sorted book prices (ascending): ");
        
        // Additional test case with large array
        System.out.println("\n--- Test Case 2: Large Array ---");
        int[] largeArray = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50, 30};
        printArray(largeArray, "Large array: ");
        mergeSort(largeArray);
        printArray(largeArray, "After merge sort: ");
        
        // Additional test case with already sorted array
        System.out.println("\n--- Test Case 3: Already Sorted Array ---");
        int[] alreadySorted = {100, 200, 300, 400, 500};
        printArray(alreadySorted, "Already sorted: ");
        mergeSort(alreadySorted);
        printArray(alreadySorted, "After merge sort: ");
        
        // Additional test case with reverse sorted array
        System.out.println("\n--- Test Case 4: Reverse Sorted Array ---");
        int[] reverseSorted = {500, 400, 300, 200, 100};
        printArray(reverseSorted, "Reverse sorted: ");
        mergeSort(reverseSorted);
        printArray(reverseSorted, "After merge sort: ");
        
        // Additional test case with duplicate values
        System.out.println("\n--- Test Case 5: Array with Duplicates ---");
        int[] withDuplicates = {250, 150, 250, 100, 150};
        printArray(withDuplicates, "Prices with duplicates: ");
        mergeSort(withDuplicates);
        printArray(withDuplicates, "After merge sort: ");
    }
}
