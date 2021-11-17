package 字符串;

public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }

        int[] s1 = new int[26];
        int[] t1 = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0;i < ss.length;i++){
            s1[ss[i] - 'a']++;
            t1[tt[i] - 'a']++;
        }
        for (int i = 0;i < 26;i++){
            if (s1[i] != t1[i]){
                return false;
            }
        }
        return true;
    }
}
