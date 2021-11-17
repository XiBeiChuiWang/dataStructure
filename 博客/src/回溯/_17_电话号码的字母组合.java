package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        HashMap<Integer, String> integerHashMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        integerHashMap.put(2,"abc");
        integerHashMap.put(3,"def");
        integerHashMap.put(4,"ghi");
        integerHashMap.put(5,"jkl");
        integerHashMap.put(6,"mno");
        integerHashMap.put(7,"pqrs");
        integerHashMap.put(8,"tuv");
        integerHashMap.put(9,"wxyz");
        char[] chars = digits.toCharArray();
        combinations(chars,list,integerHashMap,new StringBuilder());
        return list;
    }

    private void combinations(char[] chars,ArrayList<String> list,HashMap<Integer, String> integerHashMap,StringBuilder s){
        if (s.length() == chars.length){
            list.add(s.toString());
            return;
        }

        char[] chars1 = integerHashMap.get(Integer.parseInt(String.valueOf(chars[s.length()]))).toCharArray();
        for (int i = 0;i < chars1.length;i++){
            s.append(chars1[i]);
            combinations(chars, list, integerHashMap, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _17_电话号码的字母组合().letterCombinations("45"));
    }
}
