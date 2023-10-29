package week6.practice.exercise3;

import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.Node;

import week6.practice.exercise1.LinkedBinaryTree;

public class BuildBinaryTreeOfExpression<E, T> extends LinkedBinaryTree<E, T> {

    private static boolean isOperand(String x) {
        return x.matches("[0-9]+");
    }

    private static boolean isOperator(String x) {
        return x.matches("[\\+\\-\\*\\/]");
    }

    private static int precedence(String x) {
        switch (x) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
        }
        return -1; // Giá trị mặc định cho các ký tự không phải là toán tử
    }

    public String[] infix2Postfix(String tokens[]) throws Exception {
        Stack<String> stack = new Stack<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                // System.out.print(token + " ");
                arrayList.add(token);
            } else if (token.equals("(")){
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    // System.out.print(stack.pop() + " ");
                    arrayList.add(stack.pop());
                }
                stack.pop();
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    // System.out.print(stack.pop() + " ");
                    arrayList.add(stack.pop());
                }
                stack.push(token);
            }
        }
        arrayList.add(stack.pop());
        if (!stack.isEmpty()) {
            throw new Exception("Biểu thức đầu vào không hợp lệ");
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public Node<E> buildExpressionTree(String postfix[]) {
        Stack<Node<String>> stack = new Stack<>();
        for (String token : postfix) {
            Node<String> node = new Node<String>(token, null, null, null);

            if (isOperand(token)) {
                stack.push(node);
            } else if (isOperator(token)) {
                node.setRight(stack.pop());
                node.setLeft(stack.pop());
                stack.push(node);
            }
        }
        return (Node<E>) stack.pop();
    }
    
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

    public static void main(String[] args) throws Exception {
        String[] tokens = {"(", "6", "/", "3","+","2",")", "*", "(", "7", "-", "4",")"};
        
        BuildBinaryTreeOfExpression<String, Node<String>> buildBinary = new BuildBinaryTreeOfExpression<>();


        String[] postfix = buildBinary.infix2Postfix(tokens);

        Node<String> root = buildBinary.buildExpressionTree(postfix);
        
        
        System.out.println("\nPrefix expression (Tiền tố):");
        buildBinary.preOrderPrint(root);

        System.out.println("\nInfix expression (Trung tố):");
        buildBinary.inOrderPrint(root);

        System.out.println("\nPostfix expression (Hậu tố):");
        buildBinary.postOrderPrint(root);
        
    }
}
