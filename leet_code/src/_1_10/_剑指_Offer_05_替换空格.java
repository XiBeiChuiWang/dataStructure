package _1_10;

public class _剑指_Offer_05_替换空格 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;

        char[] chars = s.toCharArray();
        int count = 0;
        for (char c:chars){
            if (c == ' ')
                count++;
        }

        char[] chars1 = new char[chars.length + 2 * count];
        int n = chars1.length - 1;
        for (int i = chars.length - 1;i >= 0;i--){
            if (chars[i] == ' '){
                chars1[n--] = '0';
                chars1[n--] = '2';
                chars1[n--] = '%';
            }else {
                chars1[n--] = chars[i];
            }
        }
        return String.valueOf(chars1);
    }
}
