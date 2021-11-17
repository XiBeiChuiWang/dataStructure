package _1_10;


public class 剑指_Offer_13_机器人的运动范围 {
    private int ans = 0;
    private int[][] a = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private boolean[][] b;
    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0)
            return -1;
        b = new boolean[m][n];
        move(0,0,k);
        return ans;
    }

    private void move(int m, int n, int k){
        if (!isMove(m, n, k)){
            return;
        }

        b[m][n] = true;
        ans++;

        for (int i = 0;i < a.length;i++){
            int newM = a[i][0]+ m;
            int newN = a[i][1] + n;

            if (newM >= 0 && newM < b.length && newN >= 0 && newN < b[0].length && !b[newM][newN]){
                move(newM,newN,k);
            }
        }

    }

    private boolean isMove(int i,int j,int k){
        int c = 0;
        while (i != 0){
            c += i % 10;
            i /= 10;
        }

        while (j != 0){
            c += j % 10;
            j /= 10;
        }
        return c <= k;
    }

    public static void main(String[] args) {
//        System.out.println(new 剑指_Offer_13_机器人的运动范围().movingCount(3, 2, 17));

    }
}
