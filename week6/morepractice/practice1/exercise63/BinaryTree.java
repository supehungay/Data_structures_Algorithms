package week6.morepractice.practice1.exercise63;

import java.util.Scanner;

/**
 * BinaryTree
 */
public class BinaryTree {

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

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    private int leafCount(Node node) {
        if (node == null) {
            return 0;
        } 
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return leafCount(node.left) + leafCount(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    public static void inputArray(int[] arr, Scanner input) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        int n = input.nextInt();
        int array[] = new int[n];
        inputArray(array, input);

        binaryTree.root = null;
        for (int i = 0; i < n; i++) {
            binaryTree.root = binaryTree.insert(binaryTree.root, array[i]);
        }
        // binaryTree.inOrder(binaryTree.root);
        System.out.println(binaryTree.leafCount(binaryTree.root));
    }
}