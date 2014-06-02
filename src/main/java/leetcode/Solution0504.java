package leetcode;

import java.util.Stack;

/**
 * Created by Jacob on 2014/5/4.
 */
public class Solution0504 {

    public static void main(String[] args) {
        Solution0504 solution = new Solution0504();
        //String result = solution.reverseWords("   a   b ");
        //String[] evalRPN = {"-4", "13", "5", "/", "+"};
        //System.out.println(solution.evalRPN(evalRPN));
        //System.out.println(solution.getInclination(new Point(2, 1), new Point(1, 5)));

        Point[] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        //points[2] = new Point(2, 2);
        points[2] = new Point(0, 0);
        //points[3] = new Point(2, 2);
        //points[4] = new Point(3, 3);

        //System.out.println(solution.maxPoints(points));
        System.out.println(solution.simplifyPath("/..."));
    }



    /**
     * http://oj.leetcode.com/problems/simplify-path/
     * Given an absolute path for a file (Unix-style), simplify it.
     * <p/>
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] paths = path.split("/+");
        Stack<String> stack = new Stack<String>();
        for (String s : paths) {

            if (s.length() > 0) {
                if (s.equals("..")) {
                    if (stack.empty()) {
                        continue;
                    }
                    stack.pop();
                } else if (s.equals(".")) {
                    continue;
                } else {
                    stack.push(s);
                }
            }

        }
        String result = "";
        while (!stack.empty()) {
            result = "/" + stack.pop() + result;
        }
        if (result.length() == 0) {
            result += "/";
        }
        return result;
    }





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

    /**
     * http://oj.leetcode.com/problems/reverse-words-in-a-string/
     * Given an input string, reverse the string word by word.
     * <p/>
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] array = s.trim().split(" +");
        reverse(array);
        String result = "";
        for (String ss : array) {
            result += ss + " ";
        }

        return result.substring(0, result.length() - 1);
    }

    private <T> void reverse(T[] array) {
        if (array.length > 0) {
            for (int i = 0, j = array.length - 1; i < j; i++, j--) {
                swap(array, i, j);
            }
        }
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
