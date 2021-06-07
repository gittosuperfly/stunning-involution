package main.leetcode;

public class LC097 {

    public static void main(String[] args) {
        LC097 obj = new LC097();
        System.out.println(obj.isInterleave(
                "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa",
                "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb",
                "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb"
        ));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[l1][l2];
    }


//    boolean result = false;
//
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s3.length() != s1.length() + s2.length()) {
//            return false;
//        }
//        method(s1, s2, s3, 0, 0, 0);
//        return result;
//    }
//
//    void method(String s1, String s2, String s3, int index1, int index2, int index3) {
//        if (result || (index1 < s1.length() && s1.charAt(index1) != s3.charAt(index3)) &&
//                (index2 < s2.length() && s2.charAt(index2) != s3.charAt(index3))
//        ) {
//            return;
//        }
//        if (s1.length() == index1 && s2.length() == index2 && s3.length() == index3) {
//            result = true;
//            return;
//        }
//        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
//            method(s1, s2, s3, index1 + 1, index2, index3 + 1);
//        }
//        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
//            method(s1, s2, s3, index1, index2 + 1, index3 + 1);
//        }
//    }


}
