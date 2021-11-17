package 字节跳动._21_30;

public class _23_215_数组中的第K个最大元素_快速选择 {
    public int findKthLargest(int[] nums, int k) {
        return quickChoice(nums,0,nums.length,nums.length - k);
    }

    private int quickChoice(int[] nums,int l,int r,int k){
        int i = pointIndex(l, r, nums);

        if (i == k) return nums[i];

        if (i > k){
            return quickChoice(nums, l, i, k);
        }else {
            return quickChoice(nums, i+1, r, k);
        }

    }

    private int pointIndex(int begin,int end,int[] nums){

        int v = (int) (begin+(Math.random() * (end - begin)));
        swap(v,begin,nums);
        int e1 = nums[begin];
        end--;
        //两个指针
        while (begin < end){

            while (begin < end){
                if (e1 > nums[end]){
                    nums[begin++] = nums[end];
                    break;
                }else {
                    end--;
                }
            }

            while (begin < end){
                if (nums[begin] > e1){
                    nums[end--] = nums[begin];
                    break;
                }else {
                    begin++;
                }
            }
        }
        //结束后赋值
        nums[begin] = e1;
        return begin;
    }

    private void swap(int a,int b,int[] nums){
        int e1 = nums[a];
        nums[a] = nums[b];
        nums[b] = e1;
    }
}
