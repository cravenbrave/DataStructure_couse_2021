public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    final int INITIAL_SIZE = 8;
    private int capacity;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_SIZE];
        size = 0;
        nextFirst = INITIAL_SIZE - 1;
        nextLast = 0;
        capacity = 8;
    }

    private void resize(int capacity){
        T[] temp = (T[])new Object[capacity];

        //copy the old array to next array with correct sequence
        //first item at temp[0], second at temp[1] ...
        for(int i = 0; i < size; i++){
            if(nextFirst == items.length - 1){
                nextFirst = 0;
            }else{
                nextFirst++;
            }
            temp[i] = items[nextFirst];
        }
        items = temp;

    }

    private void incrArray(){
        capacity *= 2;
        resize(capacity);
        nextFirst = capacity - 1;
        nextLast = size;
    }
    public void addFirst(T item){
        if(nextLast == nextFirst || nextFirst < 0){
            incrArray();
        }
        size++;
        items[nextFirst] = item;
        nextFirst--;
    }

    public void addLast(T item){
        if(nextFirst == nextLast || nextLast < 0){
            incrArray();
        }
        size++;
        items[nextLast] = item;
        nextLast++;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    /* return the size of array */
    private int arraySize(){
        return items.length;
    }

    public void printDeque(){
        int ptr = nextFirst;
        for(int i = 0; i < size; i++){
            if(ptr == items.length - 1){
                ptr = 0;
            }else{
                ptr++;
            }
            System.out.print(items[ptr] + " ");
        }
        System.out.println();
    }

    /* return true if the usage ratio is less than 25% */
    private boolean isLowEff(){
        if(size * 4 >= items.length || items.length < 16 ){
            return false;
        }
        return true;
    }

    /* if the usage ratio is less than 25%, resize the array*/
    private void decrArray(){
        capacity = size * 4;

        //add size back to make sure the resize copy size number is correct
        size++;
        resize(capacity);

        //reduce the size back
        size--;
        nextFirst = capacity - 1;
        nextLast = size + 1;
    }

    public T removeFirst(){
        //if list is empty,return null
        if(isEmpty()){
            return null;
        }

        //decrease the size to check whether it is low efficient, if true, decrease the length of array
        size--;
        if(isLowEff()){
            decrArray();
        }

        //if it at the end, reset the nextFirst
        if(nextFirst == items.length - 1){
            nextFirst = -1;
        }
        T temp = items[nextFirst + 1];



        //release the memory box
        items[nextFirst + 1] = null;
        nextFirst++;

        return temp;
    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }

        size--;
        if(isLowEff()){
            decrArray();
        }

        T temp;

        //if array is not resize yet,and nextLast is not updated once
        if(nextLast == 0){
           temp = items[INITIAL_SIZE - 1];
           nextLast = INITIAL_SIZE - 1;
           items[INITIAL_SIZE - 1] = null;
        }else{
            temp = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast--;
        }
        return temp;

    }

    public T get(int index){
        if(index >= size || index < 0 || size == 0){
            return null;
        }
        if(index == 0){
            if(nextFirst == items.length - 1){
                return items[0];
            }else{
                return items[nextFirst + 1];
            }
        }

        int temp;
        if(nextFirst == items.length - 1){
            temp = 0;
        }else{
            temp = nextFirst + 1;
        }

        for(int i = 0; i < index; i++){
            if(temp == items.length - 1){
                temp = 0;
            }else{
                temp++;
            }
        }

        return items[temp];
    }


    public static void main(String[] args){
        //common case
//        ArrayDeque<Integer> test = new ArrayDeque<>();
//        test.addFirst(1);
//        test.addLast(2);
//        test.addLast(3);
//        test.addFirst(4);
//        test.addFirst(5);
//        test.addLast(6);
//        test.addFirst(7);
//
//        test.addLast(8);
//        test.addFirst(9);
//        test.addFirst(10);
//        test.printDeque();
//
//        System.out.println("------------");
//        System.out.println(test.removeFirst());
//        test.printDeque();
//        System.out.println(test.removeLast());
//        test.printDeque();
//        System.out.println(test.removeLast());
//        test.printDeque();
//        System.out.println(test.size());
//        System.out.println(test.arraySize());
//
//        System.out.println("------test get------");
//        test.get(1);
//        System.out.println(test.get(1));
//        test.printDeque();

        //very large case
//        System.out.println("-----------test2-------------");
//
//        ArrayDeque<Integer> test2 = new ArrayDeque<>();
//        int i = 0;
//        while(i < 10000){
//            test2.addFirst(i);
//            i++;
//        }
//        test2.printDeque();
//
//        System.out.println("------test get------");
//        int j = test2.get(1);
//        System.out.println(test2.get(50));
//        test2.printDeque();
//        System.out.println("-----------");
//        i = 10000;
//        while(i > 30){
//            i--;
////            test2.removeLast();
//            System.out.print(test2.removeLast() + " ");
//
//        }
//        System.out.println();
//        System.out.println(test2.size());
//        System.out.println(test2.arraySize());
//        test2.printDeque();
//
//        System.out.println("------test get------");
//        System.out.println(test2.get(29));

        //test 3 only one item or empty
//        System.out.println("-----------test3-------------");
//        ArrayDeque<Integer> test3 = new ArrayDeque<>();
//        System.out.println(test3.isEmpty());
//        test3.addFirst(1);
//        test3.addLast(2);
//        test3.get(1);
//        System.out.println(test3.get(0));
//        int k = test3.removeLast();
//        System.out.println(k);
//
//        System.out.println("-----------test4-------------");
//        ArrayDeque<Integer> test4 = new ArrayDeque<>();
//        int ii = 9;
//        while(ii >= 0){
//            test4.addLast(ii);
//            ii--;
//        }
//        test4.printDeque();
//        int kk = test4.removeFirst();
//        System.out.println(kk);
//        test4.addFirst(11);
//        test4.addFirst(22);
//        test4.addFirst(33);
//        test4.printDeque();

    }
}
