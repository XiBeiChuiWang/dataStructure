package 数组;

public class 部分排序 {
    public int[] subSort(int[] array) {
        if (array == null || array.length == 0)
            return new int[]{-1,-1};
        int r = -1;
        int max = array[0];

        for (int i = 1;i < array.length;i++){
            if (max <= array[i]){
                max = array[i];
            }else {
                r = i;
            }
        }

        if (r == -1){
            return new int[]{-1,-1};
        }

        int l = -1;
        int min = array[array.length - 1];

        for (int i = array.length - 2;i >= 0;i--){
            if (min >= array[i]){
                min = array[i];
            }else {
                l = i;
            }
        }
        return new int[]{l,r};
    }
}
