package main.leetcode;

public class LC279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.max(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
