package main.leetcode;

public class LC005 {

    //    private int maxLength, startIndex;
//
//    public String longestPalindrome(String s) {
//        if (s.length() < 2) {
//            return s;
//        }
//        for (int i = 0; i < s.length() - 1; i++) {
//            judgement(s, i, i); // 对应单数的情况 如 abcba
//            judgement(s, i, i + 1); // 对应偶数的情况 如 abccba
//        }
//        return s.substring(startIndex, startIndex + maxLength);
//    }
//
//    public void judgement(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//        if (maxLength < right - left - 1) {
//            startIndex = left + 1;
//            maxLength = right - left - 1;
//        }
//    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String center = getHWString(s, i, i);
            if (center.length() > result.length()) {
                result = center;
            }
            center = getHWString(s, i, i + 1);
            if (center.length() > result.length()) {
                result = center;
            }
        }
        return result;

    }

    public static String getHWString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
