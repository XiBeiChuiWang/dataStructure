package 字节跳动._31_40;

import 字节跳动.tool.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _37_199_二叉树的右视图 {
    //广度优先
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        ArrayList<Integer> integers = new ArrayList<>();

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        while (treeNodes.size() > 0) {
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = treeNodes.pop();
                if (pop.left != null) {
                    treeNodes.offer(pop.left);
                }
                if (pop.right != null) {
                    treeNodes.offer(pop.right);
                }

                if (i == size - 1) {
                    integers.add(pop.val);
                }
            }
        }
        return integers;
    }
}
