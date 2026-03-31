package list;

import java.util.LinkedList;

public class NthFromEnd {
    
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || list.isEmpty()) {
            return null;
        }
        
        // Use two pointers
        int firstPointer = 0;
        int secondPointer = 0;
        
        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            firstPointer++;
            if (firstPointer > list.size()) {
                return null;
            }
        }
        
        // Move both pointers until first reaches end
        while (firstPointer < list.size()) {
            firstPointer++;
            secondPointer++;
        }
        
        return list.get(secondPointer);
    }
    
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        
        int n = 2;
        System.out.println("Input: " + list + ", N=" + n);
        System.out.println("Output: " + findNthFromEnd(list, n));
    }
}
