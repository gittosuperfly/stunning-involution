package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC040 {
    List<List<Integer>> res = new ArrayList<>(); //记录答案
    List<Integer> path = new ArrayList<>();  //记录路径
    HashMap<Integer, Integer> numSizeMap = new HashMap<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int num : candidates) {
            if (numSizeMap.containsKey(num)) {
                numSizeMap.put(num, numSizeMap.get(num) + 1);
            } else {
                numSizeMap.put(num, 1);
            }
        }
        dfs(candidates, 0, target);
        return res;
    }

    public void dfs(int[] nums, int index, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] <= target) {
                if (numSizeMap.get(nums[i]) > 0) {
                    path.add(nums[i]);
                    numSizeMap.put(nums[i], numSizeMap.get(nums[i]) - 1);
                    dfs(nums, i, target - nums[i]); // 因为可以重复使用，所以还是i
                    path.remove(path.size() - 1); //回溯，恢复现场
                    numSizeMap.put(nums[i], numSizeMap.get(nums[i]) + 1);
                }
            }
        }
    }
}
