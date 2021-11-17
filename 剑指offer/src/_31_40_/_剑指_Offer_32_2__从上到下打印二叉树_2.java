package _31_40_;

import printer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_32_2__从上到下打印二叉树_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        queue.addLast(root);

        while (!queue.isEmpty()){
            int count = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = count;i > 0;i--){
                TreeNode treeNode = queue.pollFirst();
                integers.add(treeNode.val);
                if (treeNode.left != null){
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.addLast(treeNode.right);
                }
            }
            lists.add(integers);
        }
        return lists;
    }
}
