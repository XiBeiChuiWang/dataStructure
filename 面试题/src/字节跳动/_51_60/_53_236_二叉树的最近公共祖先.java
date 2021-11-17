package 字节跳动._51_60;

import 字节跳动.tool.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class _53_236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        HashMap<Integer, TreeNode> integerTreeNodeHashMap = new HashMap<>();
        integerTreeNodeHashMap.put(root.val,null);
        dfs(integerTreeNodeHashMap,root);
        HashSet<TreeNode> treeNodes = new HashSet<>();

        while (p != null){
            treeNodes.add(p);
            p = integerTreeNodeHashMap.get(p.val);
        }

        while (q != null){
            if (treeNodes.contains(q)) return q;
            q = integerTreeNodeHashMap.get(q.val);
        }
        return null;
    }

    private void dfs(HashMap map,TreeNode treeNode){
        if (treeNode.left != null){
            map.put(treeNode.left.val,treeNode);
            dfs(map,treeNode.left);
        }
        if (treeNode.right != null){
            map.put(treeNode.right.val,treeNode);
            dfs(map,treeNode.right);
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l == null){
            return r;
        }
        if (r == null){
            return l;
        }
        return root;
    }
}
