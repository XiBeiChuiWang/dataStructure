package _11_20_;

public class _剑指_Offer_11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;

        int low = 0;
        int high = numbers.length - 1;
        while (low < high){
            int mid = (low + high) / 2;
            if (numbers[mid] < numbers[high]){
                high = mid;
            }else if (numbers[mid] > numbers[high]){
                low = mid + 1;
            }else {
                high--;
            }
        }
        return numbers[low];
    }

}
