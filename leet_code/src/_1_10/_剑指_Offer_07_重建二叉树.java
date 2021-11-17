package _1_10;




import printer.TreeNode;

import java.util.HashMap;

public class _剑指_Offer_07_重建二叉树 {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0;i < inorder.length;i++){
            hashMap.put(inorder[i],i);
        }
        TreeNode treeNode = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,int pl,int pr,int il,int ir) {
        if (pl > pr || il > ir){
            return null;
        }

        int rootVal = preorder[pl];

        TreeNode treeNode = new TreeNode(rootVal);
        Integer integer = hashMap.get(rootVal);
        treeNode.left = buildTree(preorder, inorder, pl + 1, integer - il + pl, il, integer - 1);
        treeNode.right = buildTree(preorder, inorder, integer - il + pl + 1, pr, integer + 1, ir);

        return treeNode;
    }

    public static void main(String[] args) {
        new _剑指_Offer_07_重建二叉树().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
