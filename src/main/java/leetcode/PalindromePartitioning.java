package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacob on 2014/5/6.
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        System.out.println(solution.partition("aab"));
    }

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p/>
     * Return all possible palindrome partitioning of s.
     * <p/>
     * For example, given s = "aab",
     * Return
     * <p/>
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<List<String>>();

        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> current = new ArrayList<String>();

        findPartition(s, 0, current, result);
        return result;

    }

    private void findPartition(String s, int index, ArrayList<String> current, List<List<String>> result) {

        if (index == s.length() ) {
            ArrayList<String> temp = new ArrayList<String>(current);
            result.add(temp);
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (isParalindrome(str)) {
                current.add(str);
                findPartition(s, i, current, result);
                current.remove(current.size() - 1);
            }
        }


    }

    private boolean isParalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
