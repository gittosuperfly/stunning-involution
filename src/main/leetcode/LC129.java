package main.leetcode;

import main.leetcode.help.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class LC129 {
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            dfs(root, list, 0);
            int result = 0;
            for (int num : list) {
                result += num;
            }
            return result;
        } else {
            return 0;
        }
    }

    private void dfs(TreeNode node, ArrayList<Integer> nums, int cur) {
        cur *= 10;
        cur += node.val;
        if (node.left == null && node.right == null) {
            nums.add(cur);
        }
        if (node.left != null) {
            dfs(node.left, nums, cur);
        }
        if (node.right != null) {
            dfs(node.right, nums, cur);
        }
    }
}
