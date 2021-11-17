package 数组;

public class sortcolor {
    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;

        while (i <= r){
            if (nums[i] == 0){
                swap(i++,l++,nums);
            }else if (nums[i] == 1){
                i++;
            }else {
                swap(i,r--,nums);
            }
        }

    }
    private static void swap(int a,int b,int[] nums){
        int s = nums[a];
        nums[a] = nums[b];
        nums[b] = s;
    }

    public static void main(String[] args) {
        int[] ints = {2,0,2,1,1,0};
        sortColors(ints);
        for (int i:ints
             ) {
            System.out.println(i);
        }

    }
}
