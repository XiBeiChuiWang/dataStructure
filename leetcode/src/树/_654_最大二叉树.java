package 树;

import sun.reflect.generics.tree.Tree;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findNode(nums,0,nums.length);
    }
    private TreeNode findNode(int[] nums,int l,int r){
        if (r == l)
            return null;
        int maxIdx = l;
        for (int i = l+1;i < r;i++){
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        TreeNode treeNode = new TreeNode(nums[maxIdx]);
        treeNode.left = findNode(nums,l,maxIdx);
        treeNode.right = findNode(nums,maxIdx+1,r);
        return treeNode;
    }
}
