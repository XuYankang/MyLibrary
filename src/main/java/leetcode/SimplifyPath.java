package leetcode;

import leetcode.base.Point;

import java.util.Stack;

/**
 * Created by jacob on 14-8-27.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
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
        System.out.println(simplifyPath.simplifyPath("/..."));
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
}
