package 字节跳动._0_10;

public class _8_11_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r){
            int min = Math.min(height[l], height[r]);
            ans = Math.max(ans,min * (r - l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}
