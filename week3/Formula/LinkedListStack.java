package week3.Formula;

import java.util.Iterator;

public class LinkedListStack<T> implements StackInterface<T> {

	class Node {
		T element;
		Node next;

        public Node(T element) {
            this.element = element;
            next = null;
        }
	}

	Node stack = null;
    int size = 0;

	@Override
	public void push(T element) {
        Node newNode = new Node(element);
        newNode.next = stack;
        stack = newNode;
        size++;
	}

	@Override
	public T pop() {
        Node currNode = stack;
        stack = stack.next;
        size--;
		return currNode.element;
	}

	@Override
	public boolean isEmpty() {
		return  size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}

	class StackIterator implements Iterator<T> {

		private Node currentNode = stack;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public T next() {
			T data = currentNode.element;
			currentNode = currentNode.next;
			return data;
		}
	}

}
