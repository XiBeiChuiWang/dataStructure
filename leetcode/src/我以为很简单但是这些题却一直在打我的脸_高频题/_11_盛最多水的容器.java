package 我以为很简单但是这些题却一直在打我的脸_高频题;

public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1, water = 0;
        while (l < r) {
            int minH = Math.min(height[l], height[r]);
            water = Math.max(water, minH * (r - l));
            while (l < r && height[l] <= minH) l++;
            while (l < r && height[r] <= minH) r--;
        }
        return water;
    }
}
