
package synthesizer;


//import java.security.Key;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // Create new array with capacity elements.
        // first, last, and fillCount should all be set to 0.
        // this.capacity should be set appropriately. Note that the local variable
        // here shadows the field we inherit from AbstractBoundedQueue, so
        // you'll need to use this.capacity to set the capacity.
        this.capacity = capacity;
        rb = (T[]) new Object[this.capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    //implement the needed code to support iteration
    @Override
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<T> {
        private int pos;
        private int size;

        public KeyIterator() {
            pos = first;
            size = 0;
        }

        public boolean hasNext() {
            return size < capacity;
        }

        public T next() {
            T temp = rb[pos];
            pos++;
            size++;

            //iterate from first to last
            if (pos == capacity) {
                pos = 0;
            }
            return temp;
        }
    }
    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        last++;
        if (last == this.capacity) {
            last = 0;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        T temp = rb[first];
        rb[first] = null;
        first++;
        if (first == this.capacity) {
            first = 0;
        }

        fillCount--;
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        
        return rb[first];
    }

//    public static void main(String[] args) {
//        ArrayRingBuffer<Double> tt = new ArrayRingBuffer<>(4);
//        boolean is = tt.isEmpty();
////        tt.dequeue();
//        tt.enqueue(9.3);   // 9.3
//        tt.enqueue(15.1);  // 9.3  15.1
//        tt.enqueue(31.2);   // 9.3  15.1  31.2
//        is = tt.isFull();        // 9.3  15.1  31.2
//        tt.enqueue(-3.1);   // 9.3  15.1  31.2  -3.1
//        is = tt.isFull();        // 9.3  15.1  31.2  -3.1 (returns )
//        double dd = tt.dequeue();       // 15.1 31.2  -3.1       (returns 9.3)
//        dd = tt.peek();          // 15.1 31.2  -3.1       (returns 15.1)
//
//        tt.enqueue(5.0);
////        tt.enqueue(4.0);
//        for (double dd1 : tt) {
//            System.out.println(dd1);
//        }
//    }

}
