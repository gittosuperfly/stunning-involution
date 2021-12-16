package main.leetcode;

import java.util.*;

public class LC039 {
    List<List<Integer>> res = new ArrayList<>(); //记录答案
    List<Integer> path = new ArrayList<>();  //记录路径

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                path.add(nums[i]);
                dfs(nums, i, target - nums[i]); // 因为可以重复使用，所以还是i
                path.remove(path.size() - 1); //回溯，恢复现场
            }
        }
    }

}
