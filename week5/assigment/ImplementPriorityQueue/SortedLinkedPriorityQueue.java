package week5.assigment.ImplementPriorityQueue;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
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
    private int n;

    public SortedLinkedPriorityQueue() {
        head = null;
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

        if (head == null || entry.getKey().compareTo(head.getKey()) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeEntry<K, E> current = head;
            NodeEntry<K, E> prev = null;

            while (current != null && entry.getKey().compareTo(current.getKey()) >= 0) {
                prev = current;
                current = current.next;
            }

            newNode.next = current;
            prev.next = newNode;
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
        head = head.next;
        n--;

        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null; // or throw an exception
        }

        return head;
    }
}
