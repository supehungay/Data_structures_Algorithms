package week6.morepractice.practice2;

/**
 * HeightBinaryTree
 */
public class HeightBinaryTree {

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

    // private Node root;

    private int findHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        HeightBinaryTree binaryTree = new HeightBinaryTree();

        Node root = binaryTree.new Node(5);
        root.left = binaryTree.new Node(10);
        root.right = binaryTree.new Node(15);
        root.left.left = binaryTree.new Node(20);
        root.left.right = binaryTree.new Node(25);
        root.left.right.right = binaryTree.new Node(45);
        root.right.left = binaryTree.new Node(30);
        root.right.right = binaryTree.new Node(35);

        System.out.println(binaryTree.findHeight(root));

    }
}