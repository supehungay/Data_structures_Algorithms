package week3.LTT3.codelearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class example {

    /*Cho một string, nhiệm vụ của bạn là in chuỗi 
    đảo ngược của string đó ra màn hình bằng cách dùng stack*/
    public static String reverseString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(String.valueOf(s.charAt(i)));
        }

        String invert = "";
        while(!stack.empty()) {
            invert += stack.pop();
        }
        return invert;
    }

    /*chuyển một số nguyên n thành mã nhị phân và in chuỗi đó ra màn hình. */
    public static String decimal2Binary(int n) {
        Stack<Integer> stack = new Stack<>();
        while(n > 0) {
            stack.push(n%2);
            n /= 2;
        }

        String str = ""; 
        while(!stack.empty()) {
            str += stack.pop();
        }

        return str;
    }


    /* Cho một sâu s chỉ gồm các ký tự viết thường, 
    hãy viết hàm trả về chuỗi mã hóa của sâu này. */
    public static String encodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            stack.push(s.charAt(i));
        } 

        String encode = "";

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // System.out.println(stack.peek());
            if (stack.peek() == s.charAt(i)) {
                count++;
                if (i == s.length() - 1) {
                    encode = encode + stack.peek() + count;
                }
            } else {
                encode = encode + stack.peek() + count;
                while (count > 0) {
                    stack.pop();
                    count--;
                }
                i--;
            }
        }
        return encode;
    }

    /*Nhập vào một số nguyên dương n, tiếp theo nhập n số nguyên
    lần lượt là các phần tử của queue. Cuối cùng nhập vào một số
    tự nhiên k. 
    Một phép biến đổi sẽ dịch chuyển phần tử đầu tiên ra sau phần 
    tử cuối cùng của dãy, hãy trả về dãy sau khi đã biến đổi k lần. 
    In tất cả các phần tử ra màn hình, sau mỗi phần tử có đúng một 
    khoảng trắng.*/
    public static void transposeElement() {

        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(input.nextInt());
        }

        int k = input.nextInt();

        for (int i = 0; i < k; i++) {
            int temp = queue.peek();
            queue.poll();
            queue.add(temp);
        }

        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        } 

    }

    public static void main(String[] args) {
        System.out.println(reverseString("null"));
        System.out.println(decimal2Binary(5));
        System.out.println(encodeString("aaaacccsd"));
        transposeElement();
    }
}
