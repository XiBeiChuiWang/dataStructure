package _31_40_;

import printer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class _剑指_Offer_32_1_从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addLast(root);
        ArrayList<Integer> treeNodes1 = new ArrayList<>();
        while (!treeNodes.isEmpty()){
            TreeNode treeNode = treeNodes.pollFirst();
            treeNodes1.add(treeNode.val);
            if (treeNode.left != null){
                treeNodes.addLast(treeNode.left);
            }
            if (treeNode.right != null){
                treeNodes.addLast(treeNode.right);
            }
        }
        int[] res = new int[treeNodes1.size()];
        for(int i = 0; i < treeNodes1.size(); i++)
            res[i] = treeNodes1.get(i);
        return res;
    }
}
