package 数组;

public class 数组平方 {
    public int[] sortedSquares(int[] A) {
        int mid = -1;
        for (int i = 0;i < A.length - 1;i++){
            if (A[i] < 0){
                mid = i;
            }else {
                break;
            }
        }
        int l = mid;
        int r = mid + 1;

        int a = 0;
        int[] ans = new int[A.length];
        while (l >= 0 && r <= A.length - 1){
            if (-A[l] >= A[r]){
                ans[a++] = A[r]*A[r];
                r++;
            }else {
                ans[a++] = A[l]*A[l];
                l--;
            }
        }

        if(l >= 0){
            for (int i = l;i >= 0;i--){
                ans[a++] = A[i]*A[i];
            }
        }else {
            for (int i = r;i <= A.length-1;i++){
                ans[a++] = A[i]*A[i];
            }
        }
        return ans;
    }
}
