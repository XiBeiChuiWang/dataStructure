package 字节跳动._51_60;

import 字节跳动.tool.TreeNode;

public class _58_112_路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        int i = sum - root.val;
        boolean l = hasPathSum(root.left, i);
        boolean r = hasPathSum(root.right, i);
        return l || r;
    }

}
