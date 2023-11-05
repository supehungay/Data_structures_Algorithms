package midterm.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DoubleStack<E> implements QueueInterface<E> {

    Stack<E> stack1 = new Stack<>();
    Stack<E> stack2 = new Stack<>();
    Queue<E> queue = new LinkedList<>();

    @Override
    public void enqueue(E element) throws Exception {
        
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    } 
}
