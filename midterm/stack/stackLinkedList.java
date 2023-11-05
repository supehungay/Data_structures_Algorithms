package midterm.stack;

public class stackLinkedList<T> implements stack<T> {

    class Node {
        private T data;
        private Node next;

        public Node (T data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private int n;

    public stackLinkedList() {
        head = null;
        n = 0;
    }

    @Override
    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        n++;
    }

    @Override
    public T pop() {
        T data = head.data;
        head = head.next;
        n--;
        return data;
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
    public void show() {
        System.out.println("\n==================================\n");
        Node currNode = head;

        while (currNode != null) {
            System.out.println(currNode.data + " ");
            currNode = currNode.next;
        }
    }

        
    public static void main(String[] args) {
        stack<Integer> stack = new stackLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.show();

        stack.pop();
        stack.pop();
        stack.show();

        System.out.printf("stack of size: %d", stack.size());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.printf("\nisEmpty: %b", stack.isEmpty());
    }
}