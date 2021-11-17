package 二叉树.test;

import 二叉树.RBTree;
import 二叉树.printer.BinaryTrees;
import 二叉树.二叉搜索树;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        RBTree<Integer> integerRBTree = new RBTree<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        for (int i = 2;i<10;i++){
            integerRBTree.add(i);
        }

        BinaryTrees.println(integerRBTree);

    }
}
