package 字节跳动._31_40;

import 字节跳动.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _34_102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> lists = new ArrayList<>();

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0;i < size;i++){
                TreeNode treeNode = treeNodes.pollFirst();
                if (treeNode.left != null){
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null){
                    treeNodes.add(treeNode.right);
                }
                integers.add(treeNode.val);
            }
            lists.add(integers);
        }

        return lists;
    }
}
