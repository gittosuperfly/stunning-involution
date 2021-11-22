package main.leetcode;

import main.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private static void dfs(ArrayList<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        dfs(res, node.left);
        dfs(res, node.right);
    }

}
