package 栈;

import java.util.Stack;

public class 最大二叉树变种 {
    public static int[] constructMaximumBinaryTree(int[] nums){
        int[] parent = new int[nums.length];
        Stack<Integer> integers = new Stack<>();
        int[] lis = new int[nums.length];
        int[] ris = new int[nums.length];
        integers.push(0);
        for (int i = 1;i < nums.length;i++){
            while (!integers.isEmpty() && nums[integers.peek()] < nums[i]){
                ris[integers.pop()] = i;
            }
            if (integers.isEmpty()){
                lis[i] = -1;
            }else {
                lis[i] = integers.peek();
            }
            integers.push(i);
        }
        for (int i:nums){
            System.out.print(i+"  ");
        }
        System.out.println();
        for (int i:lis){
            System.out.print(i+"  ");
        }
        System.out.println();
        for (int i:ris){
            System.out.print(i+"  ");
        }
        System.out.println();

        if (ris[0] == 0){
            parent[0] = -1;
        } else {
            parent[0] = ris[0];
        }

        parent[nums.length-1] = lis[nums.length-1];

        for (int i = 1;i < nums.length-1;i++){
            if (lis[i] == -1){
                parent[i] = -1;
                continue;
            }
            parent[i] = (nums[lis[i]] > nums[ris[i]]) ? ris[i] : lis[i];
        }
        for (int i:parent){
            System.out.print(i+"  ");
        }
        System.out.println();
        return parent;
    }

    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{10,3,2,1,6,0,5,4});
    }
}
