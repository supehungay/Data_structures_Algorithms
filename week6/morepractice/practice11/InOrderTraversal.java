package week6.morepractice.practice11;

/**
 * BinaryTree
 */
public class InOrderTraversal {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }    
    }

    private Node root;

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        InOrderTraversal binaryTree = new InOrderTraversal();

        Node root = binaryTree.new Node(5);
        root.left = binaryTree.new Node(10);
        root.right = binaryTree.new Node(15);
        root.left.left = binaryTree.new Node(20);
        root.left.right = binaryTree.new Node(25);
        root.left.right.right = binaryTree.new Node(45);
        root.right.left = binaryTree.new Node(30);
        root.right.right = binaryTree.new Node(35);

        binaryTree.inOrder(root);
    }
}