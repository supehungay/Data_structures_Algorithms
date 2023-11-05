package midterm.priorityqueue;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
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

    private ArrEntry<K, E> [] array;
    private int n;
    private int defaultsize = 1000;

    public SortedArrayPriorityQueue() {
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

        int insertIdx = n;
        while (insertIdx > 0 && entry.getKey().compareTo(array[insertIdx - 1].getKey()) < 0) {
            array[insertIdx] = array[insertIdx - 1];
            insertIdx--;
        }
        array[insertIdx] = (ArrEntry<K, E>) entry;
        n++;
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

        Entry<K, E> minEntry = array[0];

        for (int i = 0; i < n - 1; i++) {
            array[i] = array[i + 1];
        }

        array[n - 1] = null;
        n--;

        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }
}
