package week4.assigment.exercise.PalindromeString;

import java.util.Stack;

import week3.Formula.LinkedListStack;
import week4.draft.ImplementQueue.LinkedListQueue;

import java.util.LinkedList;
import java.util.Queue;

public class palindome {

    // public static boolean checkPalindome(String s) {
    // Stack<Character> stack = new Stack<>();
    // Queue<Character> queue = new LinkedList<>();

    // for (int i = 0; i < s.length(); i++) {
    // stack.push(s.charAt(i));
    // queue.add(s.charAt(i));
    // }

    // for (int i = 0; i < s.length(); i++) {
    // if (stack.pop() != queue.remove()){
    // return false;
    // }
    // }
    // return true;
    // }

    public static boolean checkPalindome(LinkedListStack<String> stack, LinkedListQueue<String> queue, int n) {
        for (int i = 0; i < n; i++) {
            if (stack.pop().compareTo(queue.dequeue()) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // System.out.println(checkPalindome("nullun"));
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        System.out.println(checkPalindome(null, null, 0));

    }
}
