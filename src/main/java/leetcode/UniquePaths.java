package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(3, 3));
    }

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p/>
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p/>
     * How many possible unique paths are there?
     * <p/>
     * <p/>
     * Above is a 3 x 7 grid. How many possible unique paths are there?
     * <p/>
     * Note: m and n will be at most 100.
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        final int maxM = 100;
        final int maxN = 100;
        int[][] dp = new int[maxM + 2][maxN + 2];
        dp[m][n + 1] = 1;
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[1][1];
    }


}
