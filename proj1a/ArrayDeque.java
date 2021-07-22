public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int ptr = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            temp[i] = items[ptr];
            ptr = plusOne(ptr);
        }
        items = temp;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private int minusOne(int index) {
        if (index - 1 < 0) {
            index = items.length - 1;
        } else {
            index--;
        }
        return index;
    }

    private int plusOne(int index) {
        if (index + 1 == items.length) {
            index = 0;
        } else {
            index++;
        }
        return index;
    }
    public void addFirst(T item) {
        if (size >= items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size >= items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    /* return the size of array */
    private int arraySize() {
        return items.length;
    }

    public void printDeque() {
        int ptr = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[ptr] + " ");
            ptr = plusOne(ptr);
        }
        System.out.println();
    }

    /* return true if the usage ratio is less than 25% */
    private boolean isLowEff() {
        if (size * 4 >= items.length || items.length < 16) {
            return false;
        }
        return true;
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        int ptr = plusOne(nextFirst);
        T temp = items[ptr];
        items[ptr] = null;
        nextFirst = ptr;
        size--;

        if (isLowEff()) {
            resize(items.length / 2);
        }
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        int ptr = minusOne(nextLast);
        T temp = items[ptr];
        items[ptr] = null;
        nextLast = ptr;
        size--;

        if (isLowEff()) {
            resize(items.length / 2);
        }
        return temp;
    }

    public T get(int index) {
        if (index < 0 || index >= size || size == 0) {
            return null;
        }

        int ptr = index + plusOne(nextFirst);
        if (ptr >= items.length) {
            ptr -= items.length;
        }
        T temp = items[ptr];
        return temp;
    }

}
