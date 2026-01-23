package queue;

import java.util.*;

public class StackUsingQueues {
    
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int value) {
        queue1.add(value);
    }
    
    public int pop() {
        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }
        
        // Move all elements except last to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        int popped = queue1.remove();
        
        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return popped;
    }
    
    public int top() {
        if (queue1.isEmpty()) {
            throw new EmptyStackException();
        }
        
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        int top = queue1.peek();
        queue2.add(queue1.remove());
        
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return top;
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top());
    }
}
