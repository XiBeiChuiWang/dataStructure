package 字节跳动._31_40;

import 字节跳动.tool.TreeNode;

import java.util.LinkedList;

public class _36_101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    //递归
    private boolean check(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
    //迭代
    private boolean check1(TreeNode p,TreeNode q){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(p);
        treeNodes.offer(q);
        while (treeNodes.size() > 0){
            p = treeNodes.pop();
            q = treeNodes.pop();

            if (p == null && q == null)
                continue;
            if ((p == null || q == null) || (p.val != q.val))
                return false;

            treeNodes.offer(p.left);
            treeNodes.offer(q.right);

            treeNodes.offer(p.right);
            treeNodes.offer(q.left);
        }
        return true;
    }

}
