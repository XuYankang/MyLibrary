package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("abba"));
    }

    /**
     * http://oj.leetcode.com/problems/longest-palindromic-substring/
     * Given a string S, find the longest palindromic substring in S.
     * You may assume that the maximum length of S is 1000,
     * and there exists one unique longest palindromic substring.
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        boolean[][] table = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                table[i][j] = false;
            }
        }
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    table[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && j - i == 1) {
                    table[i][j] = true;
                } else {
                    if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
                        table[i][j] = true;
                    }
                }
            }
        }

//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length(); j++) {
//                System.out.print(table[i][j] + "\t");
//            }
//            System.out.println();
//        }


        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (table[i][j]) {
                    if (max < j - i) {
                        maxI = i;
                        maxJ = j;
                        max = j - i;
                    }
                }
            }
        }

        return s.substring(maxI, maxJ + 1);
    }

    private String find(boolean[][] table, int start, int end, String s) {
        if (table[start][end]) {
            return s.substring(start, end + 1);
        } else {
            String max1 = find(table, start + 1, end, s);
            String max2 = find(table, start, end - 1, s);
            return max1.length() > max2.length() ? max1 : max2;
        }
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
