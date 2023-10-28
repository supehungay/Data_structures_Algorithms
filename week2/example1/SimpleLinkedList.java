package week2.example1;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;

        if (top == null) {
            bot = newNode;
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node();
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

    public T get(int i) throws Exception {

        if (i < 0 || i >= n) {
            throw new Exception("Index out of bounds");
        }

        Node currNode = top;
        for (int j = 0; j < i; j++) {
            currNode = currNode.next;
        }
        return currNode.data;
    }

    public void set(int i, T data) throws Exception {
        if (i < 0 || i >= n) {
            throw new Exception("Index out of bounds");
        }

        Node currNode = top;
        for (int j = 0; j < i; j++) {
            if (j == i) {
                currNode.data = data;
                return;
            }
            currNode = currNode.next;
        }
    }

    public boolean isContain(T data) {
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        Node currNode = top;
        for (int j = 0; j < n; j++) {
            if (currNode.data.equals(data)) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public int size() {
        // Trả lại thông tin số phần tử có trong danh sách
        return n;
    }

    public boolean isEmpty() {
        // Kiểm tra danh sách có rỗng hay không?
        return n == 0;
    }

    public T removeTop() {
        // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        Node currNode = top;
        top = top.next;
        return currNode.data;
    }

    public T removeBot() {
        // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        T dataBot = bot.data;
        Node currNode = top;

        if (n == 1) {
            top = null;
            bot = null;
        }

        for (int i = 0; i < n; i++) {
            if (i == (n - 2)) {
                currNode.next = null;
                bot = currNode;
                return dataBot;
            }   
            currNode = currNode.next;         
        }
        return null;
    }

    public void remove(T data) throws Exception {
        // Xóa tất cả các phần tử có giá trị bằng data
        if (!isContain(data)) throw new Exception(data + " not in linkedlist");

        Node current = top;
        Node prev = null;
        while (current != null) {
            if (current.data.equals(data)) {
                if (prev == null) {
                    top = current.next;
                } else {
                    prev.next = current.next;
                }
                if (current == bot) {
                    bot = prev;
                }
                n--;
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) throws Exception {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.addBot(5);
        linkedList.addBot(6);

        linkedList.addBot(8);

        linkedList.addBot(9);
        linkedList.add(9);

        // linkedList.add(2);
        // linkedList.add(3);

        // System.out.println(linkedList.get(0));

        // System.out.println(linkedList.removeTop());
        // System.out.println(linkedList.get(0));
        // System.out.println(linkedList.get(1));
        // System.out.println(linkedList.get(5));
        System.out.println(linkedList.isContain(9));

        // System.out.println(linkedList.removeBot());
        // System.out.println(linkedList.get(4));

        linkedList.remove(9);
        System.out.println(linkedList.get(4));
    }
}
