package main.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            //找到起点再开始遍历，防止无用遍历 例如 [1,3,4,5]  从 4 或者 5 开始的遍历即无用遍历
            if (!set.contains(num - 1)) {
                int cur = num;
                int temp = 1;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    temp += 1;
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
