package 字节跳动._31_40;

import 字节跳动.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _35_103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> integers = new LinkedList<>();

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        boolean is_left = true;

        while (treeNodes.size() > 0){
            int size = treeNodes.size();
            for (int i = 0;i < size;i++){
                TreeNode treeNode = treeNodes.pollFirst();
                if (is_left){
                    integers.add(treeNode.val);
                }else {
                    integers.offerFirst(treeNode.val);
                }

                if (treeNode.left != null){
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null){
                    treeNodes.add(treeNode.right);
                }
            }

            ans.add(integers);
            integers = new LinkedList<>();
            is_left = !is_left;
        }
        return ans;
    }
}
