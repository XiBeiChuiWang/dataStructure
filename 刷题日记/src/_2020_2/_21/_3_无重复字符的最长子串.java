package _2020_2._21;

import java.util.HashMap;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        int li = 0;
        int ans = 1;
        characterIntegerHashMap.put(s.charAt(0),0);
        for (int i = 1;i < s.length();i++){
            Integer integer = characterIntegerHashMap.get(s.charAt(i));
            if (integer == null){
                characterIntegerHashMap.put(s.charAt(i),i);
            }else {
                if (integer >= li){
                    li = integer + 1;
                }
                characterIntegerHashMap.put(s.charAt(i),i);
            }
            ans = Math.max(ans,i - li + 1);
        }
        return ans;
    }
}
