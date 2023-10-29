import java.util.Iterator;
@SuppressWarnings({"unchecked", "deprecation"})
public class SimpleLinkedList<T> implements ListInterface<T> {
	class Node {
		T data;
		Node next;
	}
	private Node top = null;
	private Node bot = null;
	private int n = 0;
	
	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		Node newNode = new Node();
		newNode.data = data;
// 		newNode.next = top;
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
		// TODO Auto-generated method stub
// 		if (i < 0 || i >= n) {
// 		    return ;
// 		}
		
	    Node currNode = top;
        for (int j = 0; j < i; j++) {
            currNode = currNode.next;
        }	 	  	   	 	    	   	  	 	
        return currNode.data;
	}
	@Override
	public void set(int i, T data) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= n) {
            return;
        }
        
        Node currNode = top;
        for (int j = 0; j < i; j++) {
            currNode = currNode.next;
        }
        currNode.data = data;
	
	}
	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= n) {
            return;
        }
        
        if (i == 0) {
            top = top.next;
        } else {
            Node currNode = top;
            for (int j = 0; j < i; j++) {
                currNode = currNode.next;
            }
            
            currNode.next = currNode.next.next;
        }
		n--;
	}
	@Override
	public boolean isContain(T data) {	 	  	   	 	    	   	  	 	
		// TODO Auto-generated method stub
	 // Kiểm tra trong danh sách có chứa phần tử data hay không?
        
        Node currNode = top;
        while (currNode != null) {
            if (currNode.data.equals(data)) {
                return true;
            }
        currNode = currNode.next;
        }
        return false;
	}
	@Override
	public int indexOf(T data) {
		// TODO Auto-generated method stubNode  p = top;
        
        Node currNode = top;
        for (int i = 0; i < n; i++) {
            if (currNode.data.equals(data)) {
                return i;
            }
            currNode = currNode.next;
        }
        return -1;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}
	
	@Override
	public Iterator<T> iterator() {	 	  	   	 	    	   	  	 	
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	class LinkedListIterator implements Iterator<T>{
	
	    Node currNode = top;
	
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currNode != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
		    T data = currNode.data;
		    currNode = currNode.next;
			return data;
		}
		
	}

}
	 	  	   	 	    	   	  	 	
