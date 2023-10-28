package week6.practice.ImplementTree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class BinaryTreeMain {
    public static void main(String[] args) {
        // Tao cay nhi phan su dung ArrayBinaryTree
        ArrayBinaryTree<String, Integer> arrayTree = new ArrayBinaryTree<>();
        arrayTree.setRoot("1");
        arrayTree.setLeft(1, "2");
        arrayTree.setRight(1, "3");
        arrayTree.setLeft(2, "4");
        arrayTree.setRight(2, "5");
        arrayTree.setLeft(3, "6");
        arrayTree.setRight(3, "7");
        
        // In cau nhi phan su dung ArrayBinaryTree theo chieu ngang
        System.out.printf("%s Array Binary Tree %s%n", "=".repeat(20), "=".repeat(20));
        System.out.println(arrayTree);

        // Tạo cau nhi phan su dung LinkedBinaryTree
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> linkedTree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> root = linkedTree.addRoot(1);
        LinkedBinaryTree.Node<Integer> node2 = linkedTree.addLeft(root, 2);
        LinkedBinaryTree.Node<Integer> node3 = linkedTree.addRight(root, 3);
        LinkedBinaryTree.Node<Integer> node4 = linkedTree.addLeft(node2, 4);
        LinkedBinaryTree.Node<Integer> node5 = linkedTree.addRight(node2, 5);
        LinkedBinaryTree.Node<Integer> node6 = linkedTree.addLeft(node3, 6);
        LinkedBinaryTree.Node<Integer> node7 = linkedTree.addRight(node3, 7);
       
        // In cau nhi phan su dung LinkedBinaryTree theo chieu ngang
        System.out.printf("%s Linked Binary Tree %s%n", "=".repeat(20), "=".repeat(20));
        System.out.println(linkedTree);


        // Luu ket qua vao file output.txt
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\CTDL-TT\\week6\\practice\\ImplementTree\\output.txt");
            PrintStream printStream = new PrintStream(fileOutputStream);
            System.setOut(printStream);

            // In cau nhi phan su dung ArrayBinaryTree theo chieu ngang
            System.out.printf("%s Array Binary Tree %s%n", "=".repeat(20), "=".repeat(20));
            System.out.println(arrayTree);

            // In cau nhi phan su dung LinkedBinaryTree theo chieu ngang
            System.out.printf("%s Linked Binary Tree %s%n", "=".repeat(20), "=".repeat(20));
            System.out.println(linkedTree);

            printStream.close();
            System.out.println("Done!!!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
