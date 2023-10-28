package week6.practice.ImplementTree;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T>{

    protected static class Node<E> {
        E element ; // an element stored at this node
        Node <E> parent ; // a reference to the parent node (if any)
        Node <E> left ; // a reference to the left child
        Node <E> right ; // a reference to the right child

        // Constructs a node with the given element and neighbors .
        public Node (E e, Node <E> above , Node <E> leftChild , Node <E> rightChild ){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
    }

    private Node<E> root;
    private int size = 0;

    public LinkedBinaryTree() {
        root = null;
    }

    // update methods
    public Node <E> addRoot(E element) {
        // Add element to root of an empty tree
        if (isEmpty()) {
            root = new Node<E>(element, null, null, null);
            size = 1;
            return root;
        }
        return null;
    }

    public Node<E> addLeft(Node p, E element) {
        // Add element to the left child node of p if empty
        Node<E> parent = (Node<E>) p;
        if (parent.left == null) {
            Node<E> newNode = new Node<>(element, parent, null, null);
            parent.left = newNode;
            size++;
            return newNode;
        }
        return null;
    }

    public Node<E> addRight(Node p, E element) {
        // Add element to the right child node of p if empty
        Node<E> parent = (Node<E>) p;
        if (parent.right == null) {
            Node<E> newNode = new Node<>(element, parent, null, null);
            parent.right = newNode;
            size++;
            return newNode;
        }
        return null;
    }


    public void set(Node p, E element ) {
        // set element to node p
        Node<E> node = (Node<E>) p;
        node.element = element;
    }


    @Override
    public T root() {
        if (!isEmpty()) {
            return (T) root;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        int numChildren = 0;
        if (node.left != null) {
            numChildren++;
        }
        if (node.right != null) {
            numChildren++;
        }
        return numChildren;
    }

    @Override
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.parent;
    }

    @Override
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.left;
    }

    @Override
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.right;
    }

    @Override
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        Node<E> parent = node.parent;
        if (parent != null) {
            if (parent.left == node) {
                return (T) parent.right;
            } else if (parent.right == node) {
                return (T) parent.left;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        printHorizontally(root, 0);
        return "";
    }
    
    static final int COUNT = 10;
    static void printHorizontally(Node root, int space) {
        // Base case
        if (root == null)
            return;
 
        // Increase distance between levels
        space += COUNT;
 
        // Process right child first
        printHorizontally(root.right, space);
 
        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.element + "\n");
 
        // Process left child
        printHorizontally(root.left, space);
    }
}
