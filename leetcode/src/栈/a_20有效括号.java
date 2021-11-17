package 栈;

import java.util.Stack;

public class a_20有效括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (pop == '(' && chars[i] != ')') return false;
                if (pop == '[' && chars[i] != ']') return false;
                if (pop == '{' && chars[i] != '}') return false;
            }
        }
        return stack.isEmpty();
    }
}
