package main.leetcode;

import java.util.HashSet;

public class LC003 {
    public int lengthOfLongestSubstring(String s) {
        //空处理
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int pre = 0;
        int next = 0;
        //存放无重复子串的所有元素
        HashSet<Character> set = new HashSet<>();
        while (pre < s.length() && next < s.length()) {
            //无重复则下一个，有重复则去尾再判断
            if (!set.contains(s.charAt(pre))) {
                set.add(s.charAt(pre));
                pre++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(next));
                next++;
            }
        }
        return max;
    }
}
