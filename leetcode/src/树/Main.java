package 树;

import 树.printer.BinaryTreeInfo;
import 树.printer.BinaryTrees;
import 树.printer.Visitor;

public class Main {
    public static void main(String[] args) {
        二叉搜索树<Integer> integer二叉搜索树 = new 二叉搜索树<>();
        integer二叉搜索树.add(5);
        integer二叉搜索树.add(3);
        integer二叉搜索树.add(7);
        integer二叉搜索树.add(2);
        integer二叉搜索树.add(4);
        integer二叉搜索树.add(8);
        BinaryTrees.print(integer二叉搜索树);
        System.out.println();
        integer二叉搜索树.inorder(new Visitor() {
            @Override
            public boolean visit(Object element) {
                System.out.println(element);
                return false;
            }
        });

//        integer二叉搜索树.add(5);
//        integer二叉搜索树.add(3);
//        integer二叉搜索树.add(7);
//        BinaryTrees.print(integer二叉搜索树);
//        System.out.println();
//        integer二叉搜索树.fanzhuan(integer二叉搜索树.root);
//        BinaryTrees.print(integer二叉搜索树);
//        integer二叉搜索树.right();
//        System.out.println();
//        BinaryTrees.print(integer二叉搜索树);
    }
}
