package midterm.queue;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E[] queue;
    private int n;
    private int top;
    private int count;
    private int default_size = 100;

    public ArrayQueue() {
        n = default_size;
        top = 0;
        count = 0;
        queue = (E[]) new Object[default_size];
    }   

    public ArrayQueue(int capacity) {
        n = capacity;
        top = 0;
        count = 0;
        queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E element) throws Exception {
        // if (count >= queue.length) {
        //     E[] newQueue = (E[]) new Object[n * 100];
        //     for (int i = 0; i < queue.length; i++) {
        //         newQueue[i] = queue[i];
        //     }
        //     queue = newQueue;
        // }

        // queue[count++] = element;

        if (count == n) {
            throw new Exception("Queue full");
        }

        int avail = (top + count) % n;
        queue[avail] = element;
        count++;
    }

    @Override
    public E dequeue() {
        // E data = queue[0];
        // E[] newQueue = (E[]) new Object[n];
        // for (int i = 0; i < queue.length - 1; i++) {
        //     newQueue[i] = queue[i + 1];
        // }
        // queue = newQueue;
        // count --;
        if (isEmpty())
            return null;
        E data = queue[top];
        queue[top] = null;
        top = (top + 1) % n;
        count--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
            // return current < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
            // return queue[current++];
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.enqueue(1);        
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        arrayQueue.dequeue();
        arrayQueue.dequeue();

        arrayQueue.enqueue(8);

        
        for (Integer integer : arrayQueue) {
            System.out.println(integer);
        }

        System.out.println(arrayQueue.isEmpty());
    }

}
