package main.leetcode;

import java.util.Collections;
import java.util.Stack;

public class LC071 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.isEmpty() || (dir.equals("..") && stack.isEmpty()) || dir.equals(".")) continue;
            if (dir.equals("..")) {
                stack.pop();
            } else {
                stack.push(dir);
            }
        }
//        这样输出更方便
//        return "/" + String.join("/", stack);

//        这样输出LC上运行时间快1ms....
        Collections.reverse(stack);
        StringBuilder builder = new StringBuilder();
        while (stack.size() != 0) {
            builder.append("/").append(stack.pop());
        }
        if (builder.length() == 0) {
            builder.append("/");
        }
        return builder.toString();
    }
}
