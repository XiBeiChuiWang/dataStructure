package 我以为很简单但是这些题却一直在打我的脸_高频题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static ArrayList test(int[] a){
        ArrayList<List> lists = new ArrayList<>();
        int lastIndex = a.length - 3;
        int lastR = a.length - 1;
        Arrays.sort(a);
        for (int i = 0;i <= lastIndex;i++){
            if (i > 0 && a[i] == a[i - 1]) continue;
            int l = i + 1;
            int r = lastR;
            int remain = -a[i];
            while (l < r){
                int sumLR = a[l] +a[r];
                if (sumLR == remain){
                    while (l < r && a[l] == a[l + 1]) l++;
                    while (l < r && a[r] == a[r - 1]) r--;
                    lists.add(Arrays.asList(a[i],a[l],a[r]));
                    l++;
                    r--;
                }else if (sumLR < remain){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
//        ArrayList test = 三数之和.test(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
//        System.out.println(test);
//        short a = 0b100000000000000;
//        System.out.println(a);
//        System.out.println(a >>> 1);

    }
}
