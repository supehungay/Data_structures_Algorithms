
package week6.practice.exercise2;

import week6.practice.exercise1.LinkedBinaryTree;

/**
 * ExpressionTree
 */
public class ExpressionTree<E> extends LinkedBinaryTree {

    public void preOrderPrint(Node<E> p) {
        // pre - order traversal of tree with root p
        if (p == null) {
            return;
        }
        System.out.print(p.getElement() + " ");
        preOrderPrint(p.getLeft());
        preOrderPrint(p.getRight());
    }

    public void postOrderPrint(Node<E> p) {
        // post - order traversal of tree with root p
        if (p == null) {
            return;
        }
        postOrderPrint(p.getLeft());
        postOrderPrint(p.getRight());
        System.out.print(p.getElement() + " ");
    }

    public void inOrderPrint(Node<E> p) {
        //in - order traversal of tree with root p
        if (p == null) {
            return;
        }
        inOrderPrint(p.getLeft());
        System.out.print(p.getElement() + " ");
        inOrderPrint(p.getRight());
    }

    public int evaluateExpression(Node<E> p) {
        if (p == null) {
            return 0;
        }

        if (p.getLeft() == null && p.getRight() == null) {
            return Integer.parseInt(String.valueOf(p.getElement()));
        }

        int leftValue = evaluateExpression(p.getLeft());
        int rightValue = evaluateExpression(p.getRight());

        String elementValue = String.valueOf(p.getElement());

        if (isOperand(elementValue)) {
            return Integer.parseInt(elementValue);
        } else if (elementValue.equals("+")) {
            return leftValue + rightValue;
        } else if (elementValue.equals("-")) {
            return leftValue - rightValue;
        } else if (elementValue.equals("*")) {
            return leftValue * rightValue;
        } else if (elementValue.equals("/")) {
            return leftValue / rightValue;
        }
        return 0;
    }

    private boolean isOperand(String x) {
        return x.matches("[0-9]+");
    }

    public static void main(String[] args) {
        // Tạo cây nhị phân sử dụng LinkedBinaryTree
        ExpressionTree<String> expressionTree = new ExpressionTree<>();
        Node<String> root = expressionTree.addRoot("*");
        Node<String> node2 = expressionTree.addLeft(root, "+");
        Node<String> node3 = expressionTree.addRight(root, "-");
        Node<String> node4 = expressionTree.addLeft(node2, "/");
        Node<String> node5 = expressionTree.addRight(node2, "2");
        Node<String> node6 = expressionTree.addLeft(node3, "7");
        Node<String> node7 = expressionTree.addRight(node3, "4");
        Node<String> node8 = expressionTree.addLeft(node4, "6");
        Node<String> node9 = expressionTree.addRight(node4, "3");

        System.out.println("b. các dạng biểu diễn của biểu thức (tiền tố, trung tố, hậu tố) được biểu diễn bằng một cây nhị phân biểu thức cho trước:");

        System.out.println("\nPrefix expression (Tiền tố):");
        expressionTree.preOrderPrint(root);

        System.out.println("\nInfix expression (Trung tố):");
        expressionTree.inOrderPrint(root);

        System.out.println("\nPostfix expression (Hậu tố):");
        expressionTree.postOrderPrint(root);

        System.out.printf("\n\nc. giá trị của biểu thức biểu diễn bởi một cây nhị phân: %d", expressionTree.evaluateExpression(root));

    }
}