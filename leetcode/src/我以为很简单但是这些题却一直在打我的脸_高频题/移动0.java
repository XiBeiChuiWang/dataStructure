package 我以为很简单但是这些题却一直在打我的脸_高频题;

public class 移动0 {
    public static void remove(int[] a){
        int cur = 0;
        for (int i = 0;i < a.length;i++){
            if (a[i] == 0) continue;
        if (cur != i){
                a[cur] = a[i];
                a[i] = 0;
            }
            cur++;
        }
    }

    public static void main(String[] args) {
        remove1(new int[]{0,0,5,4,0});
    }

    public static void remove1(int[] nums){
        int j = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                nums[j]=nums[i];
                j++;
            }
        }

        for (int i = 0;i < nums.length-j;i++){
            nums[nums.length - i - 1] = 0;
        }


        for (int ii:nums){
            System.out.println(ii);
        }
    }
}
