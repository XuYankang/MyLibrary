package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        System.out.println(solution.minPathSum(new int[][]{}));
    }

    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     * <p/>
     * Note: You can only move either down or right at any point in time.
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int i = m - 1; i >= 0; i--) {
            dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
        }
        for (int j = n - 1; j >= 0; j--) {
            dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }



}
