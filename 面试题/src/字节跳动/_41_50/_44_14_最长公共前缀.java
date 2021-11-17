package 字节跳动._41_50;

public class _44_14_最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String max = strs[0];
        for (int i = 1;i < strs.length;i++){
            String str = strs[i];
            if (max.length() == 0){
                return "";
            }
            int min = Math.min(max.length(), strs[i].length());
            int index = 0;
            for (int j = 0;j < min;j++){
                if (max.charAt(j) == strs[i].charAt(j)){
                    index++;
                }else {
                    break;
                }
            }
            max = max.substring(0,index);
        }
        return max;
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower","flww","fl"});
    }
}
