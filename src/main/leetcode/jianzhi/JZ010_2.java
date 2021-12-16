package main.leetcode.jianzhi;

public class JZ010_2 {
    public int numWays(int n) {
        int a = 1, b = 1, num;
        for (int i = 0; i < n; i++) {
            num = a + b;
            num %= 1000000007;
            a = b;
            b = num;
        }
        return a;
    }
}
