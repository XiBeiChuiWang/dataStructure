package 字节跳动;

import java.util.HashMap;

public class _3_3_无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        char[] chars = s.toCharArray();
        int li = 0;
        int maxCount = 0;
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            Integer o = characterIntegerHashMap.get(chars[i]);
            if (o == null){
                characterIntegerHashMap.put(chars[i],i);
            }else {
                if (o >= li){
                    li = o + 1;
                }
                characterIntegerHashMap.put(chars[i],i);
            }
            maxCount = Math.max(maxCount,i-li+1);
        }
        return maxCount;
    }
}
