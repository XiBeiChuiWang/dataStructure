package _31_40_;

import printer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _面试题34_二叉树中和为某一值的路径 {
    ArrayList ans = new ArrayList<List<Integer>>();
    ArrayList ints = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return ans;
        recur(root,target);
        return ans;
    }

    private void recur(TreeNode root,int target){
        if (root == null) return;

        target -= root.val;
        ints.add(root.val);
        if (target == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<Integer>(ints));
        }

        recur(root.left,target);
        ints.remove(ints.size() - 1);
        recur(root.right,target);
    }
}
