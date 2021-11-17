public class Main {
    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(5);
//
//        treeNode.left = new TreeNode(3);
//        treeNode.right = new TreeNode(10);
//        treeNode.left.left = new TreeNode(1);
//        treeNode.right.right = new TreeNode(15);
//
//        System.out.println(new Main().a(treeNode, 13).val);
        System.out.println(new Main().a(new int[]{1, 2,3,1}));
    }

//    public TreeNode a(TreeNode treeNode,int x){
//        if (treeNode == null) return null;
//
//        TreeNode treeNode1 = treeNode;
//        int min = Integer.MAX_VALUE;
//        TreeNode ans = treeNode1;
//        while (treeNode1 != null){
//            if (treeNode1.val == x){
//                return treeNode1;
//            }else {
//                if (Math.abs(treeNode1.val - x) < min){
//                    ans = treeNode1;
//                    min = Math.min(Math.abs(treeNode1.val - x),min);
//                }
//                if (treeNode1.val > x){
//                    treeNode1 = treeNode1.left;
//                }else {
//                    treeNode1 = treeNode1.right;
//                }
//            }
//        }
//        return ans;
//    }


    public int a(int[] a){
        if (a == null || a.length == 0) return -1;

        for (int i = 0;i < a.length;i++){
            if (a[i] - 1 == i){
                continue;
            }

            while (a[i] - 1 != i){
                int i1 = a[a[i] - 1];
                if (i1 == a[i]){
                    return a[i];
                }else {
                    a[a[i] - 1] = a[i];
                    a[i] = i1;
                }
            }
        }
        return -1;
    }
}