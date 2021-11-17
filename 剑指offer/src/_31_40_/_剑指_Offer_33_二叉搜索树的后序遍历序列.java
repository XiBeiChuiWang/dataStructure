package _31_40_;

public class _剑指_Offer_33_二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return verifyPostorder(postorder,0,postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder,int i,int j){
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && verifyPostorder(postorder,i,m - 1) && verifyPostorder(postorder,m,j - 1);
    }
}
