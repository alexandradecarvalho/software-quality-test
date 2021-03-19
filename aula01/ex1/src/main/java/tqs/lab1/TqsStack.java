package tqs.lab1;

import java.util.LinkedList;

public class TqsStack<T> {

    private LinkedList<T> collection = new LinkedList<>();

    private int MAX = 5;

    void push(T x){
        if (collection.size()<MAX){
            collection.addFirst(x);
        }else{
            throw(new IllegalStateException());
        }

    }

    T pop(){
        T first = collection.getFirst();
        collection.removeFirst();
        return first;
    }

    T peek(){
        return collection.getFirst();
    }

    int size(){
        return collection.size();
    }

    boolean isEmpty(){
        return collection.isEmpty();
    }
}
