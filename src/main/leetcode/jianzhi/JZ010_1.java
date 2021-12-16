package main.leetcode.jianzhi;

/**
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2),
 */
public class JZ010_1 {
    public int fib(int n) {
        int a = 0, b = 1, num;
        for (int i = 0; i < n; i++) {
            num = a + b;
            num %= 1000000007;
            a = b;
            b = num;
        }
        return a;
    }
}
