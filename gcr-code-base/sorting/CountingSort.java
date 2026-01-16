// 7. Counting Sort - Sort Student Ages
// Problem: Sort student ages (ranging from 10 to 18) using Counting Sort algorithm

import java.util.Arrays;

public class CountingSort {
    
    /**
     * Sorts an array of student ages using Counting Sort.
     * 
     * Time Complexity: O(n + k) where n is number of elements and k is range of input
     * Space Complexity: O(k) for the count array
     * 
     * Note: This implementation works for any range of integers
     * 
     * @param ages Array of student ages (integers)
     */
    public static void countingSort(int[] ages) {
        
        // Edge case: If array is empty or has one element, it's already sorted
        if (ages.length <= 1) {
            return;
        }
        
        // Step 1: Find the maximum and minimum values in the array
        // We need this to determine the range and size of count array
        int max = ages[0];
        int min = ages[0];
        
        // Loop through array to find max and min
        for (int i = 1; i < ages.length; i++) {
            // Update max if current element is larger
            if (ages[i] > max) {
                max = ages[i];
            }
            // Update min if current element is smaller
            if (ages[i] < min) {
                min = ages[i];
            }
        }
        
        // Calculate the range of values
        // range = max - min + 1 gives us the number of unique possible values
        int range = max - min + 1;
        
        // Step 2: Create a count array to store frequency of each age
        // Index i in count array represents value (min + i)
        // count[i] will store how many times (min + i) appears in the input
        int[] count = new int[range];
        
        // Step 3: Store the count of each element
        // For each age in input array, increment its count
        for (int i = 0; i < ages.length; i++) {
            // ages[i] - min gives us the index in count array for this age
            // For example, if min=10 and age=12, index = 12-10 = 2
            count[ages[i] - min]++;
        }
        
        // Step 4: Compute cumulative frequencies
        // This determines the position of each element in the sorted array
        // count[i] now contains the number of elements <= (min + i)
        for (int i = 1; i < count.length; i++) {
            // Add previous count to current count
            count[i] += count[i - 1];
        }
        
        // Step 5: Build the output array
        // Create a temporary array to store sorted result
        int[] output = new int[ages.length];
        
        // Traverse the input array from right to left
        // This ensures stability (maintains relative order of equal elements)
        for (int i = ages.length - 1; i >= 0; i--) {
            
            // Get the current age
            int currentAge = ages[i];
            
            // Find the index in count array for this age
            int countIndex = currentAge - min;
            
            // count[countIndex] tells us the position of this age in sorted array
            // Subtract 1 because array indices are 0-based
            int sortedPosition = count[countIndex] - 1;
            
            // Place the age at its correct position in output array
            output[sortedPosition] = currentAge;
            
            // Decrement the count for this age
            // So next occurrence of same age goes to previous position
            count[countIndex]--;
        }
        
        // Step 6: Copy the sorted elements back to original array
        // Replace original array contents with sorted values
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }
    
    /**
     * Counting Sort with step-by-step details for learning purposes.
     * Prints each step of the sorting process.
     * 
     * @param ages Array of student ages
     */
    public static void countingSortWithDetails(int[] ages) {
        
        if (ages.length <= 1) {
            System.out.println("Array has <= 1 element, already sorted");
            return;
        }
        
        System.out.println("Initial array: " + Arrays.toString(ages));
        System.out.println("============================================================");
        
        // Find max and min
        int max = ages[0];
        int min = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] > max) max = ages[i];
            if (ages[i] < min) min = ages[i];
        }
        
        System.out.println("\nStep 1: Find range");
        System.out.println("  Minimum age: " + min);
        System.out.println("  Maximum age: " + max);
        
        int range = max - min + 1;
        System.out.println("  Range: " + range);
        
        // Create count array
        int[] count = new int[range];
        
        System.out.println("\nStep 2: Count frequency of each age");
        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - min]++;
        }
        
        // Print count array
        System.out.print("  Count array: [");
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i]);
            if (i < count.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        System.out.print("  Meaning: ");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.print("age " + (min + i) + " appears " + count[i] + " time(s)");
                if (i < count.length - 1) System.out.print(", ");
            }
        }
        System.out.println();
        
        // Compute cumulative frequencies
        System.out.println("\nStep 3: Compute cumulative frequencies");
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        System.out.print("  Cumulative count: [");
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i]);
            if (i < count.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        // Build output array
        System.out.println("\nStep 4: Build sorted array (processing from right to left)");
        int[] output = new int[ages.length];
        
        for (int i = ages.length - 1; i >= 0; i--) {
            int currentAge = ages[i];
            int countIndex = currentAge - min;
            int sortedPosition = count[countIndex] - 1;
            
            System.out.println("  Processing age " + currentAge + " from index " + i);
            System.out.println("    Position in sorted array: " + sortedPosition);
            
            output[sortedPosition] = currentAge;
            count[countIndex]--;
        }
        
        System.out.println("\nStep 5: Copy to original array");
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
        
        System.out.println("============================================================");
        System.out.println("Final sorted array: " + Arrays.toString(ages));
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
        
        // Sample test case: Array of student ages (unsorted, ranging from 10 to 18)
        int[] studentAges = {14, 17, 11, 15, 14, 12, 16, 18, 13, 11, 15};
        
        // Print the original unsorted ages
        printArray(studentAges, "Original student ages: ");
        
        // Call the countingSort method to sort the ages
        // This will sort the array in ascending order
        countingSort(studentAges);
        
        // Print the sorted ages
        printArray(studentAges, "Sorted student ages (ascending): ");
        
        // Detailed example with step-by-step output
        System.out.println("\n============================================================");
        System.out.println("DETAILED STEP-BY-STEP EXAMPLE");
        System.out.println("============================================================");
        int[] detailedAges = {12, 11, 13, 12, 11, 14};
        countingSortWithDetails(detailedAges);
        
        // Additional test case with wider range
        System.out.println("\n============================================================");
        System.out.println("--- Test Case 2: Wider Range ---");
        int[] widerRange = {10, 18, 10, 12, 15, 18, 13, 11, 17};
        printArray(widerRange, "Ages with wider range: ");
        countingSort(widerRange);
        printArray(widerRange, "After counting sort: ");
        
        // Additional test case with all same values
        System.out.println("\n--- Test Case 3: All Same Values ---");
        int[] allSame = {15, 15, 15, 15, 15};
        printArray(allSame, "All same ages: ");
        countingSort(allSame);
        printArray(allSame, "After counting sort: ");
        
        // Additional test case with already sorted array
        System.out.println("\n--- Test Case 4: Already Sorted Array ---");
        int[] alreadySorted = {10, 11, 12, 13, 14, 15};
        printArray(alreadySorted, "Already sorted: ");
        countingSort(alreadySorted);
        printArray(alreadySorted, "After counting sort: ");
        
        // Additional test case with reverse sorted array
        System.out.println("\n--- Test Case 5: Reverse Sorted Array ---");
        int[] reverseSorted = {18, 17, 16, 15, 14, 13, 12, 11, 10};
        printArray(reverseSorted, "Reverse sorted: ");
        countingSort(reverseSorted);
        printArray(reverseSorted, "After counting sort: ");
    }
}
