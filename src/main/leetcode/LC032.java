package main.leetcode;

import java.util.LinkedList;

public class LC032 {

    public static void main(String[] args) {
        LC032 obj = new LC032();
        System.out.println(obj.longestValidParentheses(
                ")()())"
        ));
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
