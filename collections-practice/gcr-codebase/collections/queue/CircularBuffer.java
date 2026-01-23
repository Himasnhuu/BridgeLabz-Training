package queue;

public class CircularBuffer {
    
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
        
        if (size < capacity) {
            size++;
        } else {
            // Overwrite oldest element
            head = (head + 1) % capacity;
        }
    }
    
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return result;
    }
    
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        
        System.out.print("Buffer after inserting 1, 2, 3: [");
        int[] arr = buffer.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
        
        buffer.insert(4);
        
        System.out.print("Buffer after inserting 4: [");
        arr = buffer.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
