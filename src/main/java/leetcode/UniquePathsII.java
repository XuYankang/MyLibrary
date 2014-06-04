package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class UniquePathsII {

    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        System.out.println(solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    /**
     * Follow up for "Unique Paths":
     * <p/>
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * <p/>
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p/>
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * <p/>
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * The total number of unique paths is 2.
     * <p/>
     * Note: m and n will be at most 100.
     *
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 2][n + 2];
        dp[m][n + 1] = 1;
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (obstacleGrid[i-1][j-1] == 0) {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[1][1];
    }


}
