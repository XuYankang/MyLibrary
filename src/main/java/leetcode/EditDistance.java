package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class EditDistance {

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        System.out.println(solution.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }

    /**
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
     * (each operation is counted as 1 step.)
     * <p/>
     * You have the following 3 operations permitted on a word:
     * <p/>
     * a) Insert a character
     * b) Delete a character
     * c) Replace a character
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp, i, j);
                }
            }
        }

        return dp[m][n];
    }

    private int min(int[][] dp, int i, int j) {
        int min = dp[i - 1][j - 1];
        min = Math.min(min, dp[i][j - 1]);
        min = Math.min(min, dp[i - 1][j]);
        return min;
    }


}
