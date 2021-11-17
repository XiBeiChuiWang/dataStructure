package _21_30_;

import printer.TreeNode;

public class _剑指_Offer_28_对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursion(root.left,root.right);
    }
    private boolean recursion(TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && recursion(left.left,right.right) && recursion(left.right,right.left);
    }
}
