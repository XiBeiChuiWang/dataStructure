package _51_60_;

import printer.TreeNode;

import java.util.LinkedList;

public class _剑指_Offer_55_二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        int count = 0;
        treeNodes.addLast(root);
        while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            count++;
            for (int i = 0;i < size;i++){
                TreeNode treeNode = treeNodes.pollFirst();
                if (treeNode.left != null){
                    treeNodes.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    treeNodes.addLast(treeNode.right);
                }
            }
        }
        return count;
    }
}
