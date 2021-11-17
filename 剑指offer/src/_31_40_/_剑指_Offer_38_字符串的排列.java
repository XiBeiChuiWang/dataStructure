package _31_40_;



import java.util.ArrayList;
import java.util.HashSet;

public class _剑指_Offer_38_字符串的排列 {
    private ArrayList<String> list = new ArrayList<String>();
    private boolean[] b;
    char[] aChar;
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[]{};
        b = new boolean[s.length()];
        aChar = s.toCharArray();
        back(aChar,new StringBuilder());
        String[] strings = new String[]{};
        return list.toArray(strings);
    }

    private void back(char[] aChar,StringBuilder stringBuilder){
        if (stringBuilder.length() == aChar.length){
            list.add(stringBuilder.toString());
        }
        HashSet<Character> characters = new HashSet<>();

        for (int i = 0;i < aChar.length;i++){
            if (b[i] || characters.contains(aChar[i])){
                continue;
            }

            b[i] = true;
            characters.add(aChar[i]);
            stringBuilder.append(aChar[i]);
            back(aChar,stringBuilder);
            b[i] = false;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] abcs = new _剑指_Offer_38_字符串的排列().permutation("aac");
        for (String s:abcs
             ) {
            System.out.println(s);
        }
    }
}
