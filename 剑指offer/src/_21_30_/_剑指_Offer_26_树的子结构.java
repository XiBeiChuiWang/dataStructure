package _21_30_;

import printer.TreeNode;

public class _剑指_Offer_26_树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return ((A != null && B != null) && (diGui(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B)));
    }

    private boolean diGui(TreeNode a, TreeNode b){
        if (a == null && b == null) return true;
        if (a == null) return false;
        if (b == null) return true;
        if (a.val == b.val) return diGui(a.left,b.left) && diGui(a.right,b.right);
        return false;
    }
}
