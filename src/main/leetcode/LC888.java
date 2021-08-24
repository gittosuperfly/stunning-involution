package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC888 {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int a = Arrays.stream(aliceSizes).sum();
        int b = Arrays.stream(bobSizes).sum();

        int target = (a - b) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int num : aliceSizes) {
            set.add(num);
        }

        for (int num : bobSizes) {
            int temp = num + target;
            if (set.contains(temp)) {
                return new int[]{temp, num};
            }
        }
        return new int[]{};
    }

}
