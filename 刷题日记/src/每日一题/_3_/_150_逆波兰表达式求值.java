package 每日一题._3_;

import java.util.Stack;

public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        if (tokens == null && tokens.length == 0) return 0;
        Stack<Integer> integers = new Stack<>();

        integers.push(Integer.parseInt(tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            switch (tokens[i]){
                case "+" :{
                    Integer pop2 = integers.pop();
                    Integer pop1 = integers.pop();
                    integers.push(pop1 + pop2);
                    break;
                }
                case "-" :{
                    Integer pop2 = integers.pop();
                    Integer pop1 = integers.pop();
                    integers.push(pop1 - pop2);
                    break;
                }
                case "*" :{
                    Integer pop2 = integers.pop();
                    Integer pop1 = integers.pop();
                    integers.push(pop1 * pop2);
                    break;
                }
                case "/" :{
                    Integer pop2 = integers.pop();
                    Integer pop1 = integers.pop();
                    integers.push(pop1 / pop2);
                    break;
                }
                default: {
                    integers.push(Integer.parseInt(tokens[i]));
                }
            }
        }
        return integers.pop();
    }
}
