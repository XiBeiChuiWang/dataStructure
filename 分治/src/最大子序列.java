public class 最大子序列 {
    private Integer[] integers;

    public 最大子序列(Integer[] integers) {
        this.integers = integers;
    }

    public int 暴力枚举(){
        int max = integers[0];
        int sum = 0;
        for (int begin = 0;begin < integers.length;begin++){
            sum = 0;
            for (int end = begin;end < integers.length;end++){
                sum += integers[end];
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    public int 分治法(){
        return 分治法(0,integers.length);
    }

    private int 分治法(int begin,int end){
        if (end - begin < 2) return integers[begin];
        int mid = (begin + end) >> 1;

        int leftsum = integers[mid-1];
        int leftmax = integers[mid-1];
        for (int i = mid-2;i >= begin;i--){
            leftsum += integers[i];
            leftmax = Math.max(leftmax,leftsum);
        }

        int rightsum = integers[mid];
        int rightmax = integers[mid];
        for (int i = mid+1;i < end;i++){
            rightsum += integers[i];
            rightmax = Math.max(rightmax,rightsum);
        }

        int max = leftmax + rightmax;

        return Math.max(max,Math.max(
                分治法(begin,mid),
                分治法(mid,end)
        ));
    }

    public static void main(String[] args) {
        最大子序列 最大子序列 = new 最大子序列(new Integer[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int 暴力枚举 = 最大子序列.分治法();
        System.out.println(暴力枚举);
    }
}
