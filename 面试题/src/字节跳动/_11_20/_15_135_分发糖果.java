package 字节跳动._11_20;

public class _15_135_分发糖果 {
    //两个辅助数组
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        for (int i = 0;i < ratings.length;i++){
            left[i] = 1;
            right[i] = 1;
        }

        for (int i = 1;i < ratings.length;i++){
            if (ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2;i >= 0;i--){
            if (ratings[i] >ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0;i < ratings.length;i++){
            ans += Math.max(left[i],right[i]);
        }
        return ans;
    }

    //一个辅助数组
    public int candy1(int[] ratings) {
        int[] leftright = new int[ratings.length];
        int ans = 0;
        for (int i = 0;i < ratings.length;i++){
            leftright[i] = 1;
        }

        for (int i = 1;i < ratings.length;i++){
            if (ratings[i] > ratings[i - 1]){
                leftright[i] = leftright[i - 1] + 1;
            }
        }
        ans += leftright[ratings.length - 1];
        for (int i = ratings.length - 2;i >= 0;i--){
            if (ratings[i] > ratings[i + 1] && leftright[i] <= leftright[i + 1]){
                leftright[i] = leftright[i + 1] + 1;
            }
            ans += leftright[i];
        }
        return ans;
    }
}
