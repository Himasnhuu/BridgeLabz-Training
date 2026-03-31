package map;

import java.util.*;

public class FindKeyWithHighestValue {
    
    public static <K> K findMaxKey(Map<K, Integer> map) {
        if (map.isEmpty()) {
            return null;
        }
        
        K maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        
        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        
        return maxKey;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        
        System.out.println("Input: " + map);
        System.out.println("Output: " + findMaxKey(map));
    }
}
