package midterm.linkedlist;

/**
 * SimpleLinkedList
 */
public class SimpleLinkedList<T> implements InterfaceLinkedList<T>{

    class Node {
        T data;
        Node next;
    }

    private Node top;
    private Node bot;
    private int n;

    public SimpleLinkedList() {
        top = null;
        bot = null;
        n = 0;
    }

    @Override
    public void add(T data) { // Thêm phần tử vào đầu danh sách
        Node newNode = new Node();
            newNode.data = data;
        if (n == 0) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    @Override
    public void addBot(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (n == 0) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;                
        }
        n++;
    }

    @Override
    public T get(int i) throws Exception {
        if (i < 0 | i >= n) {
            throw new Exception("error");
        }

        Node currNode = top;
        for (int j = 0; j <= i; j++) {
            currNode = currNode.next;
        }
        return currNode.data;
    }

    @Override
    public void set(int i, T data) throws Exception {
        if (i < 0 | i >= n) {
            throw new Exception("error");
        }

        Node currNode = top;
        for (int j = 0; j <= i; j++) {
            currNode = currNode.next;
        }
        currNode.data = data;
    }

    @Override
    public boolean isContain(T data) {
        if (n == 0) {
            return false;
        }
        
        Node curNode = top;
        while (curNode != null) {
            if (curNode.data.equals(data)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
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
    public T removeTop() throws Exception{
        if (n == 0) {
            throw new Exception("error");
        }

        Node currNode = top;
        top = top.next;
        return currNode.data;
    }

    @Override
    public T removeBot() {
        T dataBot = bot.data;
        Node currNode = top;

        for (int i = 0; i < n - 1; i++) {
            currNode = currNode.next;
        }
        currNode.next = null;
        bot = currNode;
        return dataBot;
    }

    @Override
    public void remove(T data) throws Exception {
        if (!isContain(data)) 
            throw new Exception(data + " not in linkedlist"); 
    }
    
}