package _31_40_;

import printer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _剑指_Offer_32_3_从上到下打印二叉树_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        boolean b = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            LinkedList<Integer> integers = new LinkedList<>();
            for (int i = count;i > 0;i--){
                TreeNode treeNode = queue.pollFirst();
                if (b){
                    integers.addFirst(treeNode.val);
                }else {
                    integers.addLast(treeNode.val);
                }
                if (treeNode.left != null){
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.addLast(treeNode.right);
                }
            }
            b = !b;
            lists.add(integers);
        }
        return lists;
    }
}
