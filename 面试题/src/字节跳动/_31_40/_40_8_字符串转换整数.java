package 字节跳动._31_40;


import java.util.HashMap;
import java.util.Map;

public class _40_8_字符串转换整数 {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        for (int i = 0;i < str.length();i++){
            automaton.get(str.charAt(i));
        }
        return automaton.sign * automaton.ans;
    }

}
class Automaton {
    int ans = 0;
    int sign = 1;
    private String state = "start";
    private HashMap<String,String[]> hashMap = new HashMap<String,String[]>();

    public Automaton() {
        hashMap.put("start",new String[]{"start","sign","num","end"});
        hashMap.put("sign",new String[]{"end","end","num","end"});
        hashMap.put("num",new String[]{"end","end","num","end"});
        hashMap.put("end",new String[]{"end","end","end","end"});
    }

    public void get(char c){
        state = hashMap.get(state)[get_col(c)];

        if ("num".equals(state)){
            ans = ans * 10 + c - '0';
        }

        if ("sign".equals(state)){
            sign = c == '+' ? 1 : -1;
        }

    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

