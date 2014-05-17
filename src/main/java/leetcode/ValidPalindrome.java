package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindrome("    "));
    }

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p/>
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * <p/>
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * <p/>
     * For the purpose of this problem, we define empty string as valid palindrome.
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            while (start < s.length() && !isCharNum(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !isCharNum(s.charAt(end))) {
                end--;
            }
            if (start <= end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;

    }

    private boolean isCharNum(char c) {

        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');

    }

    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
