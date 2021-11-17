package 字节跳动._41_50;

public class _42_88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 || n == 0) return;
        int num1l = m - 1;
        int num1r = nums1.length - 1;
        int num2l = n - 1;

        while (num2l >= 0){
            if (m >= 0 && nums1[num1l] > nums2[num2l]){
                nums1[num1r--] = nums1[num1l];
            }else {
                nums1[num1r--] = nums2[num2l];
            }
        }
    }
}
