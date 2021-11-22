package main.algs4;

import java.util.Stack;

public class solution_1_3_4 {

    //经典的括号匹配
    //栈实现
    public static boolean parenthesisMatching(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isLeft(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !isMatching(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean isMatching(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }


}
