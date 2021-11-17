package 字符串;

import 树.TreeNode;

public class _572_另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder stringBuilder1 = new StringBuilder("!");
        StringBuilder stringBuilder2 = new StringBuilder("!");
        mid1(s, stringBuilder1);
        mid1(t, stringBuilder2);
        stringBuilder1.append("@");
        stringBuilder2.append("@");
        String s1 = stringBuilder1.toString();
        String s2 = stringBuilder2.toString();
        return s1.contains(s2) || s2.contains(s1);
    }
    private void mid(TreeNode r,StringBuilder stringBuilder){
        if (r == null){
            stringBuilder.append("#!");
            return;
        }
        mid(r.left,stringBuilder);
        mid(r.right,stringBuilder);
        stringBuilder.append(r.val).append("!");
    }
    private void mid1(TreeNode r,StringBuilder stringBuilder){
        stringBuilder.append(r.val).append("!");
        if (r.left == null){
            stringBuilder.append("#!");
        }else {
            mid1(r.left,stringBuilder);
        }
        if (r.right == null){
            stringBuilder.append("#!");
        }else {
            mid1(r.right,stringBuilder);
        }
    }

    public static void main(String[] args) {
    }
}
