package week3;

import java.util.Stack;

public class Expression{
    
    public boolean isValidExpr(String expr)
    {
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

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        
        Expression expr = new Expression();
        String f = "a+b-c(3+a)";
        System.out.println(expr.isValidExpr(f));
        
    }
    
    
}
