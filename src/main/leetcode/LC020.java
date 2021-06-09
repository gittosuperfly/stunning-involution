package main.leetcode;

import java.util.LinkedList;

public class LC020 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isLeft(ch)) stack.push(ch);
            else if (stack.isEmpty() || !check(stack.pop(), ch)) return false;
        }
        return stack.isEmpty();
    }

    private boolean check(char ch1, char ch2) {
        return ch1 == '(' && ch2 == ')' || ch1 == '[' && ch2 == ']' || ch1 == '{' && ch2 == '}';
    }

    private boolean isLeft(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }
}
