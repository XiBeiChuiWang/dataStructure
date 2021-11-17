package 字节跳动._51_60;

public class _54_41_缺失的第一个正数 {
    //原地哈希
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int length = nums.length;
        for (int i = 0;i < length;i++){
            if (nums[i] <= 0){
                nums[i] = length + 1;
            }
        }
        for (int i = 0;i < length;i++){
            int abs = Math.abs(nums[i]);
            if (abs <= length){
                if (nums[abs - 1] > 0){
                    nums[abs - 1] = -nums[abs - 1];
                }
            }
        }

        for (int i = 0;i < length;i++){
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return 1;
    }

    //置换
        public int firstMissingPositive1(int[] nums) {
            int n = nums.length;
            for (int i = 0;i < n;i++){
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }

            for (int i = 0;i < n;i++){
                if (i + 1 != nums[i]){
                    return i + 1;
                }
            }
            return n + 1;
    }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{1,2,0});
    }
}
