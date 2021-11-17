public class 最大连续子序列和 {
    int [] nums;

    public 最大连续子序列和(int[] nums) {
        this.nums = nums;
    }
    public int 动态规划(){
        int[] dp = new int[nums.length];
        int[] faces = new int[nums.length];
        dp[0] = nums[0];
        faces[0] = 0;
        for (int i = 1;i < nums.length;i++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
                faces[i] = faces[i-1];
            }else {
                dp[i] = nums[i];
                faces[i] = i;
            }
        }
        int max = dp[0];
        int maxnum = 0;
        for (int i = 1;i < nums.length;i++){
            if (max < dp[i]){
                max = dp[i];
                maxnum = i;
            }
        }
        faces(maxnum,faces);
        return max;
    }

    private void faces(int maxnum,int[] faces){
        System.out.println(faces[maxnum]+"——"+maxnum);
        System.out.println(nums[faces[maxnum]]+"——"+nums[maxnum]);
    }
}
