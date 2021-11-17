package 数组;

public class 合并两个有序数组 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return;
        }

        int nums1l = m - 1;
        int nums1r = nums1.length - 1;
        int nums2r = n - 1;

        while (nums2r >= 0){
            if (nums1l >= 0 && nums1[nums1l] > nums2[nums2r]){
                nums1[nums1r--] = nums1[nums1l--];
            }else {
                nums1[nums1r--] = nums2[nums2r--];
            }
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1,3,5,0,0,0};
        int[] n2 = new int[]{2,4,6};
        merge(n1,3,n2,3);
        for (int i:n1
             ) {
            System.out.print(i+"  ");
        }

    }
}
