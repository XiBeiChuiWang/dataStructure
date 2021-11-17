package _21_30_;

import printer.ListNode;
import printer.TreeNode;

public class _剑指_Offer_27_二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
}
