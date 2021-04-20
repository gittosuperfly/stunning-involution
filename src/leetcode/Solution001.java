package leetcode;

import java.util.HashMap;

public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (map.containsKey(expect)) {
                return new int[]{map.get(expect), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
