package _31_40_;

import printer.TreeNode;

import java.util.LinkedList;

public class _剑指_Offer_37_序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        StringBuilder stringBuilder = new StringBuilder("["+root.val);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.pollFirst();
            if (treeNode.left != null){
                stringBuilder.append(","+treeNode.left.val);
                queue.addLast(treeNode.left);
            }else {
                stringBuilder.append(",null");
            }

            if (treeNode.right != null){
                stringBuilder.append(","+treeNode.right.val);
                queue.addLast(treeNode.right);
            }else {
                stringBuilder.append(",null");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] strings = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.pollFirst();

            if (!strings[i].equals("null")){
                treeNode.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.addLast(treeNode.left);
            }
            i++;

            if (!strings[i].equals("null")){
                treeNode.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.addLast(treeNode.right);
            }
            i++;
        }
        return root;
    }
}
