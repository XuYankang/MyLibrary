package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(5));
    }

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * <p/>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n - 1];
    }


}
