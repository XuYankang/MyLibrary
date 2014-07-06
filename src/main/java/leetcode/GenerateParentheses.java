package leetcode;

import java.util.ArrayList;

/**
 * Created by Jacob on 2014/5/6.
 */

public class GenerateParentheses {


    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        System.out.println(solution.generateParenthesis1(6));
        System.out.println(solution.generateParenthesis(6));
    }

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * <p/>
     * For example, given n = 3, a solution set is:
     * <p/>
     * "((()))", "(()())", "(())()", "()(())", "()()()"
     *
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis(int n) {

        ArrayList<String> result = new ArrayList<String>();
        int left = n;
        int right = n;
        String item = "";

        recursion(left, right, item, result);
        return result;
    }

    private void recursion(int left, int right, String item, ArrayList<String> result) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(item);
        }

        if (left > 0) {
            recursion(left - 1, right, item + "(", result);
        }
        if (right > 0) {
            recursion(left, right - 1, item + ")", result);
        }

    }

    public ArrayList<String> generateParenthesis1(int n) {

        ArrayList<String> result = new ArrayList<String>();
        int depth = n << 1;
        int index = 1;
        ArrayList<Character> current = new ArrayList<Character>();

        recursion1(depth, index, result, current);
        return result;
    }

    private void recursion1(int depth, int index, ArrayList<String> result, ArrayList<Character> current) {

        //judge
        int left = 0;
        int right = 0;
        String item = "";
        for (char c : current) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left > (depth >> 1) || right > (depth >> 1) || left < right) {
                return;
            }
            item += c;
        }
        if (left + right == depth) {
            result.add(item);
            return;
        }

        current.add('(');
        recursion1(depth, index + 1, result, current);
        current.remove(current.size() - 1);
        current.add(')');
        recursion1(depth, index + 1, result, current);
        current.remove(current.size() - 1);

    }


}
