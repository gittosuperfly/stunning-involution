package main.leetcode;

public class LC647 {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += checkLR(s, i);
        }
        return result;
    }

    private int checkLR(String s, int index) {
        int res = 0;
        //单中心
        for (int i = 0; index + i < s.length() && index - i >= 0; i++) {
            if (s.charAt(index + i) == s.charAt(index - i)) {
                res++;
            } else {
                break;
            }
        }
        //双中心
        if (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
            for (int i = 0; index + i + 1 < s.length() && index - i >= 0; i++) {
                if (s.charAt(index + i + 1) == s.charAt(index - i)) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
