package week6.morepractice.practice1.exercise62;

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

        Node root = null;
        for (int i = 0; i < n; i++) {
            root = binaryTree.insert(root, array[i]);
        }
        binaryTree.inOrder(root);
    }
}