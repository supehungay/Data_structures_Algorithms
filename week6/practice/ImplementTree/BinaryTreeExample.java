package week6.practice.ImplementTree;

// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.LinkedList;
// import java.util.Queue;

// public class BinaryTreeExample {

//     // In cây nhị phân theo chiều ngang
//     public static <E, T> void printLevelOrder(T root, BinaryTreeInterface<T> tree, PrintWriter printWriter) {
//         Queue<T> queue = new LinkedList<>();
//         queue.add(root);
//         while (!queue.isEmpty()) {
//             T node = queue.poll();
//             if (node != null) {
//                 printWriter.print(tree.root() + " ");
//                 queue.add(tree.left(node));
//                 queue.add(tree.right(node));
//             } else {
//                 printWriter.print("- "); // In dấu gạch nối nếu node là null
//             }
//         }
//         printWriter.println();
//     }
//     public static void main(String[] args) {
//         // Tạo cây nhị phân sử dụng ArrayBinaryTree
//         ArrayBinaryTree<String, Integer> arrayTree = new ArrayBinaryTree<>();
//         arrayTree.setRoot("1");
//         arrayTree.setLeft(1, "2");
//         arrayTree.setRight(1, "3");
//         arrayTree.setLeft(2, "4");
//         arrayTree.setRight(2, "5");
//         arrayTree.setLeft(3, "6");
//         arrayTree.setRight(3, "7");

//         // Tạo cây nhị phân sử dụng LinkedBinaryTree
//         LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> linkedTree = new LinkedBinaryTree<>();
//         LinkedBinaryTree.Node<String> root = linkedTree.addRoot("A");
//         LinkedBinaryTree.Node<String> b = linkedTree.addLeft(root, "B");
//         LinkedBinaryTree.Node<String> c = linkedTree.addRight(root, "C");
//         LinkedBinaryTree.Node<String> d = linkedTree.addLeft(b, "D");
//         LinkedBinaryTree.Node<String> e = linkedTree.addRight(b, "E");
//         LinkedBinaryTree.Node<String> f = linkedTree.addLeft(c, "F");
//         LinkedBinaryTree.Node<String> g = linkedTree.addRight(c, "G");


//         // In cây nhị phân theo chiều ngang và ghi vào tập tin "output.txt"
//         try {
//             FileWriter fileWriter = new FileWriter("output.txt");
//             PrintWriter printWriter = new PrintWriter(fileWriter);
//             printLevelOrder(linkedTree.root(), linkedTree, printWriter);
//             printLevelOrder(arrayTree.root(), arrayTree, printWriter);
//             printWriter.close();
//             System.out.println("Cây nhị phân đã được in và ghi vào tập tin 'output.txt'.");
//         } catch (IOException exception) {
//             exception.printStackTrace();
//         }
//     }

// }


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeExample {
    // public static void main(String[] args) {
    //     // Tạo cây nhị phân sử dụng LinkedBinaryTree
    //     LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> binaryTree = new LinkedBinaryTree<>();
    //     LinkedBinaryTree.Node<Integer> root = binaryTree.addRoot(1);
    //     LinkedBinaryTree.Node<Integer> node2 = binaryTree.addLeft(root, 2);
    //     LinkedBinaryTree.Node<Integer> node3 = binaryTree.addRight(root, 3);
    //     LinkedBinaryTree.Node<Integer> node4 = binaryTree.addLeft(node2, 4);
    //     LinkedBinaryTree.Node<Integer> node5 = binaryTree.addRight(node2, 5);
    //     LinkedBinaryTree.Node<Integer> node6 = binaryTree.addLeft(node3, 6);
    //     LinkedBinaryTree.Node<Integer> node7 = binaryTree.addRight(node3, 7);

    //     // In cây ra màn hình và ghi vào tệp output.txt
    //     try {
    //         FileWriter fileWriter = new FileWriter("output.txt");
    //         printBinaryTree(root, fileWriter);
    //         fileWriter.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public static void printBinaryTree(LinkedBinaryTree.Node<Integer> root, FileWriter fileWriter) throws IOException {
    //     if (root == null) {
    //         return;
    //     }

    //     Queue<LinkedBinaryTree.Node<Integer>> queue = new LinkedList<>();
    //     queue.add(root);

    //     while (!queue.isEmpty()) {
    //         LinkedBinaryTree.Node<Integer> current = queue.poll();
    //         int data = current.element;

    //         System.out.print(data + " "); // In ra màn hình
    //         fileWriter.write(data + " "); // Ghi vào tệp output.txt

    //         if (current.left != null) {
    //             queue.add(current.left);
    //         }
    //         if (current.right != null) {
    //             queue.add(current.right);
    //         }
    //     }
    // }
    public static void main(String[] args) {
        // Test ArrayBinaryTree
        ArrayBinaryTree<Integer, Integer> arrayBinaryTree = new ArrayBinaryTree<>();
        arrayBinaryTree.setRoot(1);
        arrayBinaryTree.setLeft(1, 2);
        arrayBinaryTree.setRight(1, 3);
        arrayBinaryTree.setLeft(2, 4);
        arrayBinaryTree.setRight(2, 5);

        System.out.println("ArrayBinaryTree:");
        printBinaryTree(arrayBinaryTree, 1);

        // Test LinkedBinaryTree
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> linkedBinaryTree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> rootNode = linkedBinaryTree.addRoot(1);
        LinkedBinaryTree.Node<Integer> leftNode = linkedBinaryTree.addLeft(rootNode, 2);
        LinkedBinaryTree.Node<Integer> rightNode = linkedBinaryTree.addRight(rootNode, 3);
        linkedBinaryTree.addLeft(leftNode, 4);
        linkedBinaryTree.addRight(leftNode, 5);

        System.out.println("\nLinkedBinaryTree:");
        printBinaryTree(linkedBinaryTree, rootNode);
    }

    public static <E, T> void printBinaryTree(BinaryTreeInterface<T> tree, T position) {
        if (position != null) {
            System.out.println(tree.root());
            printSubtree(tree, position, 0);
        }
    }

    private static <E, T> void printSubtree(BinaryTreeInterface<T> tree, T position, int depth) {
        if (position != null) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println(tree.left(position));
            printSubtree(tree, tree.left(position), depth + 1);

            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println(tree.right(position));
            printSubtree(tree, tree.right(position), depth + 1);
        }
    }
}
