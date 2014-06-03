package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.maxSubArray(new int[]{Integer.MIN_VALUE}));
    }

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * <p/>
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
     * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
     * <p/>
     * click to show more practice.
     *
     * @param A
     * @return
     */

    public int maxSubArray(int[] A) {
        int max = 0;
        int cur = 0;
        boolean allZero = true;
        int maxNegtive = Integer.MIN_VALUE;
        for (int a : A) {
            cur += a;

            if (cur > max) {
                max = cur;
            }
            if (cur < 0) {
                cur = 0;
            }

            if (a < 0) {
                if (maxNegtive < a) {
                    maxNegtive = a;
                }
            } else {
                allZero = false;
            }
        }
        return allZero ? maxNegtive : max;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
