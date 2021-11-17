package _51_60_;

import printer.TreeNode;

public class _剑指_Offer_54_二叉搜索树的第k大节点 {
    private int count = 0;
    private int res = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return -1;
        count = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode treeNode){
        if (treeNode == null) return;
        dfs(treeNode.right);
        if (--count == 0){
            res = treeNode.val;
            return;
        }
        dfs(treeNode.left);
    }
}
