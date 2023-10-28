package week2.example2;

import java.util.Iterator;

interface ListInterface<T> extends Iterable<T> {
    public void add(T data) throws Exception;
    public T get(int i);
    public void set(int i, T data);
    public void remove(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
}

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize]; 
    }

    public SimpleArrayList(int capacity) throws Exception{
        // Hàm dựng với kích thước mảng là capacity
        if (capacity < 0) {
            throw new Exception("Capacity must be non-negative");
        }
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) throws Exception {
        if (n >= array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[n] = data;
        n++;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        // if (array[n - 1].equals(data)) {
        //     array[n - 1]
        // }
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                for (int k = i; k < n - 1; k++) {
                    array[k] = array[k + 1];
                }
                array[n - 1] = null;
                n--;
                i--;
            }
        }
    }

    @Override
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return array[currentIndex++];
            }
        };
    }

    public static void main(String[] args) {
        
    }
}

