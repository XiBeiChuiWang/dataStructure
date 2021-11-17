package 字符串;

import java.util.HashMap;

public class 字符串翻转151 {

    public void 翻转(String s){

        char[] chars = s.toCharArray();
        //去空格
        int cur = 0;
        //判断上一个元素是否为空格
        boolean b = true;
        for (int i = 0;i < chars.length;i++){
            if (chars[i] != ' '){
                chars[cur++] = chars[i];
                b = false;
            }else if (!b){
                b = true;
                chars[cur++] = ' ';
            }else {
                continue;
            }
        }
        int len = b ? cur-1 : cur;
//        System.out.println(len);
//        for (int i = 0;i <= cur;i++) {
//            System.out.print(chars[i]);
//        }
        nixu(chars,0,len);
//        for (int i = 0;i <= cur-1;i++) {
//            System.out.print(chars[i]);
//        }
//        for (int i = 0;i <= cur-1;i++) {
//            System.out.print(chars[i]);
//        }
        int lastkong = 0;
        for (int i = 1;i < len;i++){
            if (chars[i] == ' '){
                nixu(chars,lastkong,i);
                lastkong = i+1;
            }
        }
        nixu(chars,lastkong,len);

        for (int i = 0;i <= cur-1;i++) {
            System.out.print(chars[i]);
        }
    }

    private void nixu(char[] chars,int begin,int end) {
        end--;
        while (begin < end) {
            char c = chars[begin];
            chars[begin] = chars[end];
            chars[end] = c;
            begin++;
            end--;
        }
    }
    public static void main(String[] args) {
//
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1,1);
        System.out.println(objectObjectHashMap.get(1));
        System.out.println(objectObjectHashMap.get(2));
    }
}
