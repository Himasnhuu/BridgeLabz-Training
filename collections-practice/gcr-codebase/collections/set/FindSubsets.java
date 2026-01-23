package set;

import java.util.*;

public class FindSubsets {
    
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }
    
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        
        System.out.println("Set1: " + set1 + ", Set2: " + set2);
        System.out.println("Output: " + isSubset(set1, set2));
    }
}
