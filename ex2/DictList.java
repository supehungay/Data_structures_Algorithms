package ex2;

public class DictList<T> implements ListInterface<T> {

    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node top = null;
	private Node bot = null;
	private int n = 0;

	public int indexOf(T element) {
		Node currNode = top;
        int idx = 0;
		while (currNode != null) {
			if (currNode.data.equals(element)) {
				return idx;
			}
			currNode = currNode.next;
			idx++;
		}
		
        return -1;
    }

    @Override
	public void add(T data) {
		Node newNode = new Node(data);
		newNode.data = data;
		if (top == null) {
		    top = newNode;
		    bot = newNode;
		} else {
		    bot.next = newNode;
		    bot = newNode;
		}
	    n++;
	}

    @Override
	public T get(int i) {
	    Node currNode = top;
        for (int j = 0; j < i; j++) {
            currNode = currNode.next;
        }
        return currNode.data;
	}

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }
}
