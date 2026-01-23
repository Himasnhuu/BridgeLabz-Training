package set;

import java.util.*;

public class ConvertToSortedList {
    
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }
    
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        
        System.out.println("Input: " + set);
        System.out.println("Output: " + convertToSortedList(set));
    }
}
