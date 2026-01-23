package map;

import java.util.*;

public class InvertMap {
    
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        
        for (Map.Entry<K, V> entry : map.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        
        return invertedMap;
    }
    
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "1");
        
        System.out.println("Input: " + map);
        System.out.println("Output: " + invertMap(map));
    }
}
