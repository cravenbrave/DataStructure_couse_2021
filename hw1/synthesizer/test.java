package synthesizer;

import java.util.Iterator;

public class test<T> implements BoundedQueue<T> {
    private int capacity;
    private int size;
    private int first, last;
    private T[] array;

    public test() {
        capacity = 4;
        size = 0;
        last = 0;
        first = 0;
        array = (T[]) new Object[capacity];
    }
    // return size of the buffer
    public int capacity() {
        return capacity;
    }

    // return number of items currently in the buffer
    public int fillCount() {
        return size;
    }

    // add item x to the end
    public void enqueue(T x) {
        if (isFull()) {
            return;
        }
        array[last] = x;
        last++;
        if (last == capacity) {
            last = 0;
        }
        size++;
    }

    // delete and return item from the front
    public T dequeue() {
        T temp = array[first];
        array[first] = null;
        first++;
        if (first == capacity) {
            first = 0;
        }
        size--;
        return temp;
    }

    // return (but do not delete) item from the front
    public T peek() {
        return array[first];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public static void main(String[] args) {
        test<Double> tt = new test<>();
        boolean is = tt.isEmpty() ;      //
        tt.enqueue(9.3);   // 9.3
        tt.enqueue(15.1);  // 9.3  15.1
        tt.enqueue(31.2);   // 9.3  15.1  31.2
        is = tt.isFull();        // 9.3  15.1  31.2
        tt.enqueue(-3.1);   // 9.3  15.1  31.2  -3.1
        is = tt.isFull();        // 9.3  15.1  31.2  -3.1 (returns )
        double dd = tt.dequeue();       // 15.1 31.2  -3.1       (returns 9.3)
        dd = tt.peek();          // 15.1 31.2  -3.1       (returns 15.1)

        tt.enqueue(5.0);
    }
}
