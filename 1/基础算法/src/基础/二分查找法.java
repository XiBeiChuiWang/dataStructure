package 基础;

public class 二分查找法 {
    public static int a(int key,int []aa){
        int low = 0;
        int high = aa.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(key < aa[mid])  high = mid - 1;
            else{
                if (key > aa[mid])
                    low = mid + 1;
                else
                    return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        int x = a(100,a);
        if(x == -1) System.out.println("未找到");
        else
        System.out.println("第"+(a(9,a)+1)+"个元素为key");
    }
}
