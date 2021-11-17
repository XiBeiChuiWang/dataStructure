package 字节跳动._31_40;


import 字节跳动.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _33_94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        mid(integers,root);
        return integers;
    }
    private void mid(List list,TreeNode root){
        if (root == null)
            return;
        mid(list,root.left);
        list.add(root.val);
        mid(list,root.right);
    }
}
