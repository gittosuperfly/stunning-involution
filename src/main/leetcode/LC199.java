package main.leetcode;

import main.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC199 {
    /**
     * 挺好玩的做法
     * <p>
     * 按照 根-右-左 的顺序遍历，则当前深度第一次出现的节点一定是最右侧的节点！
     */
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode node, ArrayList<Integer> res, int depth) {
        if (node == null) {
            return;
        }
        if (depth++ == res.size()) {
            res.add(node.val);
        }
        dfs(node.right, res, depth);
        dfs(node.left, res, depth);
    }
}
