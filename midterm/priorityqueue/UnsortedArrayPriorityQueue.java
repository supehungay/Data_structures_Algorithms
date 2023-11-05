package midterm.priorityqueue;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
        protected class ArrEntry<K, E> implements Entry<K, E> {
            K key;
            E element;

            public ArrEntry(K key, E element) {
                this.key = key;
                this.element = element;
            }

            @Override
            public K getKey() {
                return key;
            }
            @Override
            public E getValue() {
                return element;
            }
        }

    ArrEntry<K, E> [] array;
    int n;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultsize];
        n = 0;
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
    public void insert(Entry<K, E> entry) {
        if (n == array.length) {
            return;
        }
        array[n++] = (ArrEntry<K, E>) entry;
    }
    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }
    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIdx].getKey()) < 0) {
                minIdx = i;
            }
        }

        Entry<K, E> minEntry = array[minIdx];

        array[minIdx] = array[n - 1];
        array[n - 1] = null;
        n--;
        return minEntry;
    }
    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        int minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIdx].getKey()) < 0) {
                minIdx = i;
            }
        }

        return array[minIdx];
    }

}