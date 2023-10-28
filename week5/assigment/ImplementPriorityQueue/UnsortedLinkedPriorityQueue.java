package week5.assigment.ImplementPriorityQueue;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
            next = null;
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

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n;

    public UnsortedLinkedPriorityQueue() {
        head = null;
        tail = null;
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
        NodeEntry<K, E> newNode = new NodeEntry<>(entry.getKey(), entry.getValue());
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null; // or throw an exception
        }

        NodeEntry<K, E> minEntry = head;
        NodeEntry<K, E> prev = null;
        NodeEntry<K, E> current = head;
        NodeEntry<K, E> minPrev = null;

        while (current != null) {
            if (minEntry.getKey().compareTo(current.getKey()) > 0) {
                minEntry = current;
                minPrev = prev;
            }

            prev = current;
            current = current.next;
        }

        if (minPrev == null) {
            head = minEntry.next;
        } else {
            minPrev.next = minEntry.next;
        }

        if (minEntry == tail) {
            tail = minPrev;
        }

        n--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null; // or throw an exception
        }

        NodeEntry<K, E> minEntry = head;
        NodeEntry<K, E> current = head;

        while (current != null) {
            if (minEntry.getKey().compareTo(current.getKey()) > 0) {
                minEntry = current;
            }

            current = current.next;
        }

        return minEntry;
    }
}
