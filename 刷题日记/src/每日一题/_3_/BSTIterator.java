package 每日一题._3_;

import tool.TreeNode;

import java.util.LinkedList;
import java.util.List;

class BSTIterator {
    private int index = 0;
    private List list;
    public BSTIterator(TreeNode root) {
        list = new LinkedList<Integer>();
        dfs(root);
    }
    
    public int next() {
        Integer integer = (Integer) list.get(index);
        index++;
        return integer;
    }
    
    public boolean hasNext() {
        return index < list.size();
    }

    private void dfs(TreeNode treeNode){
        if (treeNode == null) return;
        dfs(treeNode.left);
        list.add(treeNode.val);
        dfs(treeNode.right);
    }
}