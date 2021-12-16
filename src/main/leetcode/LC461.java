package main.leetcode;

public class LC461 {
    public static void main(String[] args) {
        System.out.println(new LC461().hammingDistance(1, 2));
    }

    public int hammingDistance(int x, int y) {
        //异或一下，一样就是0，不一样就是1
        int diff = x ^ y;
        //下面的代码其实就是计算二进制中1的个数的代码
        int result = 0;
        while (diff != 0) {
            diff &= diff - 1;
            result++;
        }
        return result;
    }
}
