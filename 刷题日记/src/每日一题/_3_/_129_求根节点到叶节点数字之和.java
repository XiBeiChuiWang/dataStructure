package 每日一题._3_;

import tool.TreeNode;

import java.util.ArrayList;

public class _129_求根节点到叶节点数字之和 {

    private int num = 0;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        int ans = 0;
        for (int i:arrayList){
            ans += i;
        }
        return ans;
    }
    private void dfs(TreeNode root){

        if (root.left == null && root.right == null) {
            arrayList.add(num);
            return;
        }

        if (root.left != null){
            dfs(root.left);
        }
        num = (num - root.val) / 10;
        if (root.right != null){
            dfs(root.right);
        }


        num = (num - root.val) / 10;
    }
}
