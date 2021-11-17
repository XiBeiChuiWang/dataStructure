package 字节跳动._51_60;

import 字节跳动.tool.TreeNode;

public class _60_124_二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        path(root);
        return ans;
    }
    private int path(TreeNode treeNode){
        if (treeNode == null) return 0;

        int left = Math.max(path(treeNode.left),0);
        int right = Math.max(path(treeNode.right),0);
        int sum = left + right + treeNode.val;

        ans = Math.max(sum,ans);
        return ans;
    }
}
