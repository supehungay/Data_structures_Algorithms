package midterm.linkedlist;

import java.util.Iterator;

public class SimpleArrayList<T> implements InterfaceArrayList<T> {

    private T[] array;
    private int n;
    private int defaulSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaulSize];
        n = 0;
    }

    public SimpleArrayList(int capacity) {
        // Hàm dựng với kích thước mảng là capacity
        array = (T[]) new Object[capacity];
        n = 0;
    }

    @Override
    public void add(T data) {
        if (n >= array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[n++] = data;
    }

    @Override
    public T get(int i) {
        return array[i];
    }

    @Override
    public void set(int I, T data) {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void remove(T data) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void isContain(T data) {
        throw new UnsupportedOperationException("Unimplemented method 'isContain'");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
