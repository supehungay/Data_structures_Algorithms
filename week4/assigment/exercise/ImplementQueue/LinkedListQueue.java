package week4.assigment.exercise.ImplementQueue;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {

    class Node {
		E element;
		Node next;

        // public Node(E element) {
        //     this.element = element;
        //     next = null;
        // }
	}

    private Node front;
    private Node rear;
    private int n;

    public LinkedListQueue() {
        front = null;
        rear = null;
        n = 0;
    }
    
    @Override
    public void enqueue(E element) {
        // Node newNode = new Node(element);
        // if (n == 0) {
        //     front = rear = newNode;
        //     n++;
        //     return;
        // } 
        // rear.next = newNode;
        // rear = newNode; 
        // n++;

        Node newNode = new Node();
        newNode.element = element;
        newNode.next = null;

        if (front == null) {
            front = rear = newNode;
        } 

        rear.next = newNode;
        rear = newNode;
        n++;
    }

    @Override
    public E dequeue() {
        if (n == 0) {
            return null;
        }

        Node currNode = front;
        front = front.next;
        n--;
        return currNode.element;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	class QueueIterator implements Iterator<E> {

		private Node currentNode = front;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public E next() {
			E data = currentNode.element;
			currentNode = currentNode.next;
			return data;
		}
	}

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        linkedListQueue.enqueue(1);        
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);
        linkedListQueue.enqueue(4);
        linkedListQueue.enqueue(5);

        linkedListQueue.dequeue();

        for (Integer integer : linkedListQueue) {
            System.out.println(integer);
        }

    }
    
}
