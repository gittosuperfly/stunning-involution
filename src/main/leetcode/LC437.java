package main.leetcode;

import main.leetcode.help.TreeNode;

public class LC437 {

    int t;
    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfsPath(node, node.val);
        dfs(node.left);
        dfs(node.right);
    }

    private void dfsPath(TreeNode node, int add) {
        if (add == t) result++;
        if (node.left != null) dfsPath(node.left, add + node.left.val);
        if (node.right != null) dfsPath(node.right, add + node.right.val);
    }

}
