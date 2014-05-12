package leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2014/5/6.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("{}[]()"));
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p/>
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        char[] parentheses = s.toCharArray();
        char[] stack = new char[s.length()];
        int cur = 0;
        boolean isValid = true;
        for (char c : parentheses) {
            if (c == '(' || c == '[' || c == '{') {
                stack[cur++] = c;
            } else {
                if (cur == 0) {
                    isValid = false;
                    break;
                }
                cur--;
                if ((c == ')' && '(' != stack[cur]) || (c == ']' && '[' != stack[cur]) || (c == '}' && '{' != stack[cur])) {
                    isValid = false;
                    break;
                }
            }
        }

        return cur == 0 ? isValid : false;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
