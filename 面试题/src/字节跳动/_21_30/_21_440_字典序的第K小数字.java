package 字节跳动._21_30;

public class _21_440_字典序的第K小数字 {
    public static int findKthNumber(int n, int k) {
        k--;
        int cur = 1;
        while (k > 0){
            int num = getNode(n, cur, cur + 1);

            if (num <= k){
                k -= num;
                cur++;
            }else {
                cur *= 10;
                k--;
            }
        }

        return cur;
    }

    private static int getNode(int n,int first,int last){
        int num = 0;
        while (first <= n){
            num += Math.min(last,n+1) - first;
            first *= 10;
            last *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        findKthNumber(300,255);
    }
}
