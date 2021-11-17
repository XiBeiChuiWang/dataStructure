package 字节跳动._41_50;

import 字节跳动.tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _45_104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int ans = 0;
        while (!treeNodes.isEmpty()){
            ans++;
            int size = treeNodes.size();
            for (int i = 0;i < size;i++){
                TreeNode poll = treeNodes.poll();
                if (poll.left != null){
                    treeNodes.add(poll.left);
                }
                if (poll.right != null){
                    treeNodes.add(poll.right);
                }
            }
        }
        return ans;
    }

    public int maxDepth1(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth1(root.left),maxDepth1(root.right)) + 1;
    }
}
