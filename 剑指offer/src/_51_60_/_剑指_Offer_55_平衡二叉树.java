package _51_60_;

import printer.TreeNode;

public class _剑指_Offer_55_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        return dfs(root) != -1;
    }

    private int dfs(TreeNode treeNode){
        if (treeNode == null) return 0;
        int left = dfs(treeNode.left);
        if (left == -1) return -1;
        int right = dfs(treeNode.right);
        if (right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left,right) : -1;
    }
}
