// 6. Heap Sort - Sort Job Applicants by Salary
// Problem: Sort salary demands in ascending order using Heap Sort algorithm

import java.util.Arrays;

public class HeapSort {
    
    /**
     * Sorts an array of salary demands in ascending order using Heap Sort.
     * 
     * Time Complexity: O(n log n) - in all cases
     * Space Complexity: O(1) - sorts in place
     * 
     * @param salaries Array of salary demands (integers)
     */
    public static void heapSort(int[] salaries) {
        
        // Get the length of the salaries array
        int n = salaries.length;
        
        // Step 1: Build a Max Heap from the array
        // Start from the last non-leaf node and heapify each node
        // Last non-leaf node is at index (n/2 - 1)
        // We go backwards to ensure parent nodes are heapified after their children
        for (int i = n / 2 - 1; i >= 0; i--) {
            // Heapify the subtree rooted at index i
            heapify(salaries, n, i);
        }
        
        // Step 2: Extract elements from heap one by one
        // The heap now has the largest element at root (index 0)
        // We'll extract elements from end to beginning
        for (int i = n - 1; i > 0; i--) {
            
            // Swap current root (largest element) with last element
            // This moves the largest unsorted element to its correct position at the end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            
            // Reduce heap size by 1 (exclude the sorted element)
            // and heapify the root to maintain max heap property
            // The element at position i is now in its final sorted position
            heapify(salaries, i, 0);
        }
    }
    
    /**
     * Heapify a subtree rooted at index i.
     * Ensures the max heap property: parent >= children
     * 
     * @param arr Array representing the heap
     * @param n Size of heap (number of elements to consider)
     * @param i Index of root of subtree to heapify
     */
    private static void heapify(int[] arr, int n, int i) {
        
        // Initialize largest as root
        // We assume the current node i is the largest
        int largest = i;
        
        // Calculate index of left child
        // In a binary heap, left child of node i is at index 2*i + 1
        int left = 2 * i + 1;
        
        // Calculate index of right child
        // In a binary heap, right child of node i is at index 2*i + 2
        int right = 2 * i + 2;
        
        // Check if left child exists and is greater than root
        // left < n ensures the child exists in the heap
        if (left < n && arr[left] > arr[largest]) {
            // Update largest to left child index
            largest = left;
        }
        
        // Check if right child exists and is greater than current largest
        // right < n ensures the child exists in the heap
        if (right < n && arr[right] > arr[largest]) {
            // Update largest to right child index
            largest = right;
        }
        
        // If largest is not root, we need to swap and continue heapifying
        // This means one of the children was larger than the parent
        if (largest != i) {
            
            // Swap root with the largest child
            // This moves the larger value up in the heap
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Recursively heapify the affected subtree
            // The subtree rooted at 'largest' might now violate heap property
            // So we need to heapify it
            heapify(arr, n, largest);
        }
    }
    
    /**
     * Heap Sort with step-by-step details for learning purposes.
     * Prints each step of the sorting process.
     * 
     * @param salaries Array of salary demands
     */
    public static void heapSortWithDetails(int[] salaries) {
        
        // Get array length
        int n = salaries.length;
        
        System.out.println("Initial array: " + Arrays.toString(salaries));
        System.out.println("============================================================");
        
        // Build Max Heap
        System.out.println("\nStep 1: Building Max Heap");
        System.out.println("------------------------------------------------------------");
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("Heapifying subtree rooted at index " + i + " (value: " + salaries[i] + ")");
            heapify(salaries, n, i);
            System.out.println("  Array after heapify: " + Arrays.toString(salaries));
        }
        
        System.out.println("\nMax Heap built: " + Arrays.toString(salaries));
        System.out.println("============================================================");
        
        // Extract elements from heap
        System.out.println("\nStep 2: Extracting elements from heap");
        System.out.println("------------------------------------------------------------");
        for (int i = n - 1; i > 0; i--) {
            System.out.println("\nIteration " + (n - i) + ":");
            System.out.println("  Swapping root " + salaries[0] + " with last element " + salaries[i]);
            
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            
            System.out.println("  Array after swap: " + Arrays.toString(salaries));
            
            System.out.print("  Sorted portion: [");
            for (int k = i; k < n; k++) {
                System.out.print(salaries[k]);
                if (k < n - 1) System.out.print(", ");
            }
            System.out.println("]");
            
            System.out.println("  Heapifying remaining elements (heap size: " + i + ")");
            heapify(salaries, i, 0);
            System.out.println("  Array after heapify: " + Arrays.toString(salaries));
        }
        
        System.out.println("\n============================================================");
        System.out.println("Final sorted array: " + Arrays.toString(salaries));
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
        
        // Sample test case: Array of salary demands (unsorted)
        int[] salaryDemands = {50000, 75000, 45000, 90000, 60000, 55000, 80000};
        
        // Print the original unsorted salaries
        printArray(salaryDemands, "Original salary demands: ");
        
        // Call the heapSort method to sort the salaries
        // This will sort the array in ascending order
        heapSort(salaryDemands);
        
        // Print the sorted salaries
        printArray(salaryDemands, "Sorted salary demands (ascending): ");
        
        // Detailed example with step-by-step output
        System.out.println("\n============================================================");
        System.out.println("DETAILED STEP-BY-STEP EXAMPLE");
        System.out.println("============================================================");
        int[] detailedSalaries = {12000, 11000, 13000, 5000, 6000, 7000};
        heapSortWithDetails(detailedSalaries);
        
        // Additional test case with small array
        System.out.println("\n============================================================");
        System.out.println("--- Test Case 2: Small Array ---");
        int[] smallArray = {4, 10, 3, 5, 1};
        printArray(smallArray, "Small array: ");
        heapSort(smallArray);
        printArray(smallArray, "After heap sort: ");
        
        // Additional test case with already sorted array
        System.out.println("\n--- Test Case 3: Already Sorted Array ---");
        int[] alreadySorted = {30000, 40000, 50000, 60000, 70000};
        printArray(alreadySorted, "Already sorted salaries: ");
        heapSort(alreadySorted);
        printArray(alreadySorted, "After heap sort: ");
        
        // Additional test case with reverse sorted array
        System.out.println("\n--- Test Case 4: Reverse Sorted Array ---");
        int[] reverseSorted = {90000, 80000, 70000, 60000, 50000};
        printArray(reverseSorted, "Reverse sorted salaries: ");
        heapSort(reverseSorted);
        printArray(reverseSorted, "After heap sort: ");
        
        // Additional test case with duplicate values
        System.out.println("\n--- Test Case 5: Array with Duplicates ---");
        int[] withDuplicates = {50000, 60000, 50000, 70000, 60000};
        printArray(withDuplicates, "Salaries with duplicates: ");
        heapSort(withDuplicates);
        printArray(withDuplicates, "After heap sort: ");
    }
}
