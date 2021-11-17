package 字节跳动._51_60;

public class _57_55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int rightMax = 0;
        for (int i = 0;i < length;i++){
            if (i <= rightMax){
                rightMax = Math.max(rightMax,i + nums[i]);
                if (rightMax >= length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
