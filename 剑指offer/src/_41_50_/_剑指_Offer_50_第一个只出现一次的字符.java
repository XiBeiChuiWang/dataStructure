package _41_50_;

import java.util.HashMap;

public class _剑指_Offer_50_第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if (s == null) return ' ';

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();

        for (int i = 0;i < s.length();i++){
            characterIntegerHashMap.put(s.charAt(i),characterIntegerHashMap.containsKey(s.charAt(i)) ? characterIntegerHashMap.get(s.charAt(i)) + 1 : 1);
        }

        for (int i = 0;i < s.length();i++){
            if (characterIntegerHashMap.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
