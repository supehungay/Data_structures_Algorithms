package week3.LTT3.example3;

import java.util.ArrayList;
import java.util.Stack;

public class invertStack {
    // Đảo ngược stack
    public static ArrayList<Integer> reverse(Stack<Integer> st) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    // Kiểm tra xâu ngoặc hợp lệ 
    public static boolean isValid(String expr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            char temp = expr.charAt(i);
            if (temp == '{' || temp == '[' || temp == '(' ) {
                stack.push(temp);
            } else if (temp == '}' || temp == '}' || temp == ')' ) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // Xóa phần tử giữa của stack
    public static void deleteMiddle(Stack<Integer> stack) {
        int idxMiddle = stack.size() / 2;
        Stack<Integer> tempStack = new Stack<>();

        // Lấy ra và đẩy vào stack phụ các phần tử trước phần tử giữa
        for (int i = 0; i < idxMiddle; i++) {
            tempStack.push(stack.pop());
        }

        // Bỏ qua phần tử giữa
        stack.pop();

        // Đẩy lại các phần tử từ stack phụ trở lại stack gốc
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack trước khi xóa phần tử giữa: " + stack);

        deleteMiddle(stack);

        System.out.println("Stack sau khi xóa phần tử giữa: " + stack);
    }
}
