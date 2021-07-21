public class LinkedListDeque<T> {
    private class node {
        public T item;
        public node next;
        public node prev;

        public node(T i, node p, node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private int size;
    private node sentinel;

    public LinkedListDeque(){
        //initialize sentinel node, points itself
        sentinel = new node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item){
        size++;

        //create a new first node, prev node points to sentinel, next node points to the old first node
        node temp = new node(item, sentinel, sentinel.next);

        //set the sentinel points to new first node
        sentinel.next = temp;

        //set the old first node points to the new first node
        temp.next.prev = temp;
    }

    public void addLast(T item){
        size++;

        //create a new last node, prev node points to the old last node, next node points to sentinel
        node temp = new node(item, sentinel.prev, sentinel);

        //set the old last node points to the new one
        temp.prev.next = temp;

        //set the sentinel points to the new last node
        sentinel.prev = temp;
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

    public void printDeque(){
        if(size == 0){
            return;
        }
        node temp = sentinel.next;
        for(int i = 0; i < size; i++){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }

        //get the first node, return its value
        node temp = sentinel.next;

        //set the next node points to sentinel, then set it as the first node after sentinel
        temp.next.prev = sentinel;
        sentinel.next = temp.next;

        size--;
        return temp.item;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }

        //get the last node, return its value
        node temp = sentinel.prev;

        //set the sentinel points to the second last node, then set the second last node points to sentinel
        sentinel.prev = temp.prev;
        temp.prev.next = sentinel;

        size--;
        return temp.item;
    }

    public T get(int index){
        if(index >= size || index < 0){
            return null;
        }
        node temp = sentinel;
        while(index >= 0){
            temp = temp.next;
            index--;
        }
        return temp.item;
    }

    /* helper function: help getRecursive method to get node.item during recursion*/
    private node getRecursiveHelper(node n, int index){
        if(index == 0){
            return n;
        }
        return getRecursiveHelper(n.next, index - 1);
    }

    public T getRecursive(int index){
        if(index >= size || index < 0){
            return null;
        }
        node temp = sentinel.next;

        return getRecursiveHelper(temp, index).item;
    }
//    public static void main(String[] args){
//        LinkedListDeque<Integer> test = new LinkedListDeque<>();
//        System.out.println(test.isEmpty());
//        test.addFirst(10);
//        test.addFirst(5);
//        test.addLast(15);
//
//        System.out.println(test.getRecursive(0));
//        test.printDeque();
//        System.out.println(test.removeLast());
//        System.out.println(test.removeLast());
//        System.out.println(test.removeFirst());
//        System.out.println(test.isEmpty());
//        System.out.println(test);
//    }
}
