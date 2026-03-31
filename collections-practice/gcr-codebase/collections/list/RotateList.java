package list;

import java.util.*;

public class RotateList {
    
    public static <T> List<T> rotate(List<T> list, int positions) {
        if (list.isEmpty() || positions == 0) {
            return new ArrayList<>(list);
        }
        
        int size = list.size();
        positions = positions % size;
        
        List<T> rotated = new ArrayList<>();
        
        // Add elements from position to end
        for (int i = positions; i < size; i++) {
            rotated.add(list.get(i));
        }
        
        // Add elements from start to position
        for (int i = 0; i < positions; i++) {
            rotated.add(list.get(i));
        }
        
        return rotated;
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;
        
        System.out.println("Input: " + numbers + ", rotate by " + rotateBy);
        System.out.println("Output: " + rotate(numbers, rotateBy));
    }
}
