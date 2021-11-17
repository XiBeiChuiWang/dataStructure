package _1__10;


import printer.TreeNode;

import java.util.HashMap;

public class _剑指_Offer_07_重建二叉树 {
    private HashMap<Integer, Integer> integerIntegerHashMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;

        int n = preorder.length;
        //将中序遍历中的每一个节点都放进HashMap，方便我们进行查找
        integerIntegerHashMap = new HashMap<Integer, Integer>();
        for (int i = 0;i < preorder.length;i++){
            integerIntegerHashMap.put(inorder[i],i);
        }
        return buildTree(preorder, inorder,0,n - 1,0,n - 1);
    }

    //我们来看看参数 int p_left,int p_right 就是构建一棵子树所需要的先序遍历的数组 int i_left,int i_right为中序遍历
    private TreeNode buildTree(int[] preorder, int[] inorder,int p_left,int p_right,int i_left,int i_right){
        //递归返回条件
        if (p_left > p_right) return null;
        Integer i_root = integerIntegerHashMap.get(preorder[p_left]);
        //构建树的根节点
        TreeNode root = new TreeNode(preorder[p_left]);
        //根据中序遍历算出左子树的节点数
        int left_size = i_root - i_left;
        //递归构建左子树及右子树（核心）
        root.left = buildTree(preorder,inorder,p_left + 1,p_left + left_size,i_left,i_root - 1);
        root.right = buildTree(preorder, inorder,p_left + left_size + 1,p_right,i_root + 1,i_right);
        //返回根节点
        return root;
    }
}
