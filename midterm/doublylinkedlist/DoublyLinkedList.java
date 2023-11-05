package midterm.doublylinkedlist;

import java.io.EOFException;

public class DoublyLinkedList<T> {
    class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }
    
    private Node top;
    private Node bot;
    private int n;

    public DoublyLinkedList() {
        top = null;
        bot = null;
        n = 0;
    }
    
    public void add(T data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top.prev = newNode;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.prev = bot;
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public void addIndex(int index, T data) throws Exception {

        if (index < 0 || index >= n) {
            throw new Exception("Index out of bounds");
        }

        Node newNode = new Node(data);


        if (index == 0) {
            add(data);
        } else if (index == n - 1) {
            addBot(data);
        } else {
            Node currNode = top;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }

            newNode.next = currNode;
            newNode.prev = currNode.prev;
            currNode.prev = newNode;
            // currNode = newNode;
            n++;
        }
    }

    public void removeTop() {
        if (n == 0) {
            return;
        } else if (n == 1) {
            top = null;
            bot = null;
        } else {
            top = top.next;
            top.prev = null;
        }
        n--;
    }
    public void removeBot() {
        if (n == 0) {
            return;
        } else if (n == 1) {
            top = null;
            bot = null;
        } else {
            bot = bot.prev;
            bot.next = null;
        }
        n--;
    }
    
    public void removeIndex(int index) throws Exception {
        if (index < 0 || index >= n) {
            throw new EOFException("Index out of bounds");
        }

        if (top == null) {
            return;
        }

        if (index == 0) {
            removeTop();
        } else if (index == n - 1) {
            removeBot();
        } else {
            Node currNode = top;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            n--;
        }  
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }
    
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> doublylinkedlist = new DoublyLinkedList<>();
        doublylinkedlist.add(1);
        doublylinkedlist.add(3);
        doublylinkedlist.addBot(2);
        doublylinkedlist.addIndex(0,9);
        doublylinkedlist.removeTop();
        doublylinkedlist.removeBot();
        doublylinkedlist.removeIndex(1);
        System.out.printf("Số phần tử trong danh sách: %d \n", doublylinkedlist.size());
        System.out.printf("Danh sách trống: %b", doublylinkedlist.isEmpty());
    }
}
