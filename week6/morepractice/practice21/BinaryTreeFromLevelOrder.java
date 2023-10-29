package week6.morepractice.practice21;

public class BinaryTreeFromLevelOrder {
    class Node {
        int data;
        Node left, right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node insertTree(int arr[], int idx) {
        Node node = null;
        if (idx < arr.length) {
            node = new Node(arr[idx]);
            node.left = insertTree(arr, 2 * idx + 1);
            node.right = insertTree(arr, 2 * idx + 2);
        }
        return node;
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeFromLevelOrder myTree = new BinaryTreeFromLevelOrder();
        int arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        Node root = myTree.insertTree(arr, 0);
        myTree.inOrder(root);
    }
}
