package leetcode;

import java.util.Stack;

/**
 * Created by jacob on 14-8-27.
 */
public class EvalRPN{
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * <p/>
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * <p/>
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for (String t : tokens) {
            if ((t.charAt(0) == '-' && t.length() > 1) || (t.charAt(0) >= '0' && t.charAt(0) <= '9')) {
                stack.push(Integer.parseInt(t));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (t.charAt(0)) {
                    case '+':
                        result = (b + a);
                        break;
                    case '-':
                        result = (b - a);
                        break;
                    case '*':
                        result = (b * a);
                        break;
                    case '/':
                        result = (b / a);
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
