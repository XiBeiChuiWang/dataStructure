package 我以为很简单但是这些题却一直在打我的脸_高频题;

import java.util.HashMap;

public class 两数之和 {
    public static void test(int[] a,int b){
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(a[0],0);
        for (int i = 1;i < a.length;i++){
            int c = b - a[i];
            if (integerIntegerHashMap.containsKey(c)){
                System.out.println(integerIntegerHashMap.get(c)+","+i);
                return;
            }else {
                integerIntegerHashMap.put(a[i],i);
            }
        }
    }

    public static void main(String[] args) {
        test(new int[]{1,5,-3,-5},0);
    }
}
