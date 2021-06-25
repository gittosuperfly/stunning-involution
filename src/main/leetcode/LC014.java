package main.leetcode;

import java.util.Arrays;

public class LC014 {

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String res = "";
        int minLength = Math.min(strs[0].length(), strs[strs.length - 1].length());
        for (int i = 0; i < minLength; i++) {
            String head = strs[0].substring(0, i + 1);
            if (head.equals(strs[strs.length - 1].substring(0, i + 1))) {
                res = head;
            }
        }
        return res;
    }

    public static String longestCommonPrefix2(String[] strings) {
        StringBuilder builder = new StringBuilder();
        if (strings.length == 0) {
            return builder.toString();
        }
        // 按位查询
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //任选一个字符串
            String str = strings[0];
            //如果i已经大于等于该字符串，说明builder已经是最长得了
            if (i >= str.length()) {
                return builder.toString();
            }
            //按位比较
            char c = str.charAt(i);
            for (String item : strings) {
                if (i >= item.length() || item.charAt(i) != c) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
