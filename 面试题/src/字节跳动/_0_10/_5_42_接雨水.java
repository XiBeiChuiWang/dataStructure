package 字节跳动._0_10;

public class _5_42_接雨水 {
    public int 暴力法(int[] height) {
        int ans = 0;
        for (int i = 1;i < height.length-1;i++){
            int leftMax = 0;
            int rightMax = height.length-1;

            for (int l = 1;l < i;l++){
                if (height[l] > height[leftMax]){
                    leftMax = l;
                }
            }

            for (int r = height.length-2;r > i;r--){
                if (height[r] > height[rightMax]){
                    rightMax = r;
                }
            }
            int min = Math.min(height[leftMax], height[rightMax]);
            if (min > height[i]){
                ans += min - height[i];
            }
        }
        return ans;
    }

    public int 动态规划(int[] height) {
        if (height == null || height.length == 0) return 0;
        int[] dpLeftMax = new int[height.length];
        int[] dpRightMax = new int[height.length];
        dpLeftMax[0] = Integer.MIN_VALUE;
        dpRightMax[height.length-1] = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 1;i < height.length;i++){
            dpLeftMax[i] = Math.max(dpLeftMax[i-1],height[i-1]);
        }
        for (int i = height.length-2;i >= 0;i--){
            dpRightMax[i] = Math.max(dpRightMax[i+1],height[i+1]);
        }

        for (int i = 1;i < height.length - 1;i++){
            int min = Math.min(dpLeftMax[i],dpRightMax[i]);
            if (min > height[i]){
                ans += min - height[i];
            }
        }
        return ans;
    }

    public int 双指针(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0 ,r = height.length-1;
        int lMax = 0 , rMax = 0;
        int ans = 0;

        while (l < r){
            if (height[l] < height[r]){
                if (lMax <= height[l]){
                    lMax = height[l];
                }else {
                    ans += lMax - height[l];
                }
                l++;
            }else {
                if (rMax <= height[r]){
                    rMax = height[r];
                }else {
                    ans += rMax - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}
