package queue;

import java.util.*;

public class ReverseQueue {
    
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        
        // Remove all elements from queue and push to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        
        // Pop from stack and add back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        
        return queue;
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        
        System.out.println("Input: " + queue);
        reverse(queue);
        System.out.println("Output: " + queue);
    }
}
