// 4. Quick Sort - Sort Product Prices
// Problem: Sort product prices in ascending order using Quick Sort algorithm

import java.util.Arrays;

public class QuickSort {
    
    /**
     * Sorts an array of product prices in ascending order using Quick Sort.
     * 
     * Time Complexity: O(n log n) - average case, O(n²) - worst case
     * Space Complexity: O(log n) - for recursion stack
     * 
     * @param prices Array of product prices (integers)
     */
    public static void quickSort(int[] prices) {
        // Call the recursive quickSort with initial indices
        // low = 0 (start of array)
        // high = prices.length - 1 (end of array)
        quickSort(prices, 0, prices.length - 1);
    }
    
    /**
     * Recursive Quick Sort method
     * 
     * @param prices Array to sort
     * @param low Starting index of the portion to sort
     * @param high Ending index of the portion to sort
     */
    private static void quickSort(int[] prices, int low, int high) {
        
        // Base case: If low is less than high, there are at least 2 elements to sort
        // If low >= high, the array has 0 or 1 element, which is already sorted
        if (low < high) {
            
            // Partition the array and get the pivot index
            // After partition, all elements left of pivot are smaller
            // and all elements right of pivot are larger
            int pivotIndex = partition(prices, low, high);
            
            // Recursively sort the left partition (elements before pivot)
            // Sort from low to pivotIndex - 1
            quickSort(prices, low, pivotIndex - 1);
            
            // Recursively sort the right partition (elements after pivot)
            // Sort from pivotIndex + 1 to high
            quickSort(prices, pivotIndex + 1, high);
        }
    }
    
    /**
     * Partitions the array around a pivot element.
     * Places smaller elements to the left and larger elements to the right.
     * 
     * @param prices Array to partition
     * @param low Starting index of partition
     * @param high Ending index of partition
     * @return Final index of the pivot element
     */
    private static int partition(int[] prices, int low, int high) {
        
        // Choose the last element as pivot
        // This is a simple pivot selection strategy
        // Other strategies: first element, middle element, or random element
        int pivot = prices[high];
        
        // Index of smaller element
        // This will track the position where we'll place the pivot
        // Initialize to low - 1 (before the first element)
        int i = low - 1;
        
        // Traverse through all elements in the range [low, high-1]
        // Compare each element with pivot
        for (int j = low; j < high; j++) {
            
            // If current element is smaller than or equal to pivot
            // We want to move it to the left side
            if (prices[j] <= pivot) {
                
                // Increment index of smaller element
                // This marks the next position for a small element
                i++;
                
                // Swap current element with element at index i
                // This moves the smaller element to the left side
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        
        // After the loop, all elements <= pivot are on the left (indices low to i)
        // All elements > pivot are on the right (indices i+1 to high-1)
        
        // Place pivot in its correct position
        // Swap pivot (at high) with element at i+1
        // Now pivot is between smaller and larger elements
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        
        // Return the index of pivot
        // This is where the pivot ended up after partitioning
        return i + 1;
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
        
        // Sample test case: Array of product prices (unsorted)
        int[] productPrices = {850, 200, 650, 120, 500, 300, 950};
        
        // Print the original unsorted prices
        printArray(productPrices, "Original product prices: ");
        
        // Call the quickSort method to sort the prices
        // This will sort the array in ascending order
        quickSort(productPrices);
        
        // Print the sorted prices
        printArray(productPrices, "Sorted product prices (ascending): ");
        
        // Additional test case with small array
        System.out.println("\n--- Test Case 2: Small Array ---");
        int[] smallArray = {5, 2, 8, 1, 9};
        printArray(smallArray, "Small array: ");
        quickSort(smallArray);
        printArray(smallArray, "After quick sort: ");
        
        // Additional test case with duplicate values
        System.out.println("\n--- Test Case 3: Array with Duplicates ---");
        int[] withDuplicates = {500, 200, 500, 100, 200, 300};
        printArray(withDuplicates, "Prices with duplicates: ");
        quickSort(withDuplicates);
        printArray(withDuplicates, "After quick sort: ");
        
        // Additional test case with already sorted array (worst case for last element pivot)
        System.out.println("\n--- Test Case 4: Already Sorted Array ---");
        int[] alreadySorted = {100, 200, 300, 400, 500};
        printArray(alreadySorted, "Already sorted (worst case): ");
        quickSort(alreadySorted);
        printArray(alreadySorted, "After quick sort: ");
        
        // Additional test case with reverse sorted array
        System.out.println("\n--- Test Case 5: Reverse Sorted Array ---");
        int[] reverseSorted = {900, 700, 500, 300, 100};
        printArray(reverseSorted, "Reverse sorted: ");
        quickSort(reverseSorted);
        printArray(reverseSorted, "After quick sort: ");
        
        // Additional test case with single element
        System.out.println("\n--- Test Case 6: Single Element ---");
        int[] singleElement = {42};
        printArray(singleElement, "Single element: ");
        quickSort(singleElement);
        printArray(singleElement, "After quick sort: ");
    }
}
