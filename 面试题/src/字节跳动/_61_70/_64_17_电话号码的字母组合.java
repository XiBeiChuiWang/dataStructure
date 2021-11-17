package 字节跳动._61_70;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _64_17_电话号码的字母组合 {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        HashMap<Integer, String> integerHashMap = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        integerHashMap.put(2,"abc");
        integerHashMap.put(3,"def");
        integerHashMap.put(4,"ghi");
        integerHashMap.put(5,"jkl");
        integerHashMap.put(6,"mno");
        integerHashMap.put(7,"pqrs");
        integerHashMap.put(8,"tuv");
        integerHashMap.put(9,"wxyz");
        huiSu(strings,integerHashMap,digits,0,new StringBuilder());
        return strings;
    }
    private static void huiSu(List list,HashMap<Integer,String> hashMap,String s,int n,StringBuilder stringBuilder){
        if (n == s.length()){
            list.add(stringBuilder.toString());
            return;
        }
        String s1 = hashMap.get(Integer.parseInt(String.valueOf(s.charAt(n))));
        for (int i = 0;i < s1.length();i++){
            stringBuilder.append(s1.charAt(i));
            huiSu(list, hashMap, s, n + 1, stringBuilder);
            stringBuilder.deleteCharAt(n);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
