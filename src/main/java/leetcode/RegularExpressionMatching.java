package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        System.out.println(solution.isMatch("aba", "b*a*c*a"));
    }

    /**
     * Implement regular expression matching with support for '.' and '*'.
     * <p/>
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * <p/>
     * The matching should cover the entire input string (not partial).
     * <p/>
     * The function prototype should be:
     * bool isMatch(const char *s, const char *p)
     * <p/>
     * Some examples:
     * isMatch("aa","a") → false
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false
     * isMatch("aa", "a*") → true
     * isMatch("aa", ".*") → true
     * isMatch("ab", ".*") → true
     * isMatch("aab", "c*a*b") → true
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int len = s.length();
            int i = -1;
            while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }

    }


}
