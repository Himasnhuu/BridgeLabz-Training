package list;

import java.util.*;

public class RemoveDuplicates {
    
    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> list) {
        List<T> result = new ArrayList<>();
        Set<T> seen = new LinkedHashSet<>();
        
        for (T element : list) {
            if (seen.add(element)) {
                result.add(element);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        
        System.out.println("Input: " + numbers);
        System.out.println("Output: " + removeDuplicatesPreserveOrder(numbers));
    }
}
