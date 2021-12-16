package main.leetcode;

import main.leetcode.help.TreeNode;

public class LC543 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        dfs(root);
        return max - 1;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        max = Math.max(max, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
