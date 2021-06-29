package main.leetcode;

public class LC931 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int result = Integer.MAX_VALUE;
        for (int start = 0; start < n; start++) {
            int min = Integer.MAX_VALUE;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                if (i == start) {
                    dp[0][i] = matrix[0][i];
                } else {
                    dp[0][i] = min;
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = min;
                    if (dp[i - 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + matrix[i][j]);
                    }
                    if (j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + matrix[i][j]);
                    }
                    if (j < n - 1 && dp[i - 1][j + 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + matrix[i][j]);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                min = Math.min(min, dp[n - 1][i]);
            }
            result = Math.min(result, min);
        }
        return result;
    }

}
