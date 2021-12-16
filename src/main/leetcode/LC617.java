package main.leetcode;

import main.leetcode.help.TreeNode;

public class LC617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);
    }

    private TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }

}
