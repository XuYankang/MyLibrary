package leetcode;

import java.util.Stack;

/**
 * Created by Jacob on 2014/5/6.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        System.out.println(solution.longestValidParentheses("()(()"));
    }

    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     * <p/>
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     * <p/>
     * Another example is ")()())", where the longest valid parentheses substring is "()()",
     * which has length = 4.
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int longest = 0;
        int thisLongest = 0;
        char[] array = s.toCharArray();
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                left++;
            } else {
                if (left > 0) {
                    thisLongest += 2;
                    left--;
                    if (thisLongest > longest) {
                        longest = thisLongest;
                    }
                } else {
                    thisLongest = 0;
                }
            }
        }
        return longest;
    }

    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
