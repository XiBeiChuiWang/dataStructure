package 字节跳动._11_20;

import java.util.Stack;

public class _17_20_有效的括号 {
    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length;i++){
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (pop == '(' && chars[i] != ')') return false;
                if (pop == '[' && chars[i] != ']') return false;
                if (pop == '{' && chars[i] != '}') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
