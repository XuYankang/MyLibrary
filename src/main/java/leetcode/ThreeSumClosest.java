package leetcode;

import java.util.Arrays;

/**
 * Created by Jacob on 2014/5/6.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int[] num = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(solution.threeSumClosest(num, -2));
    }

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * <p/>
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * <p/>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
     * @param num
     * @param target
     * @return
     */
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = 0;
        boolean firstMin = true;
        for (int i = 0; i < num.length - 2; i++) {
            int subTarget = target - num[i];
            int start = i + 1;
            int end = num.length - 1;
            int finalStart = start;
            int finalEnd = end;
            int preClosest = Math.abs(num[start] + num[end] - subTarget) + 1;

            while (start < end) {
                if (num[start] + num[end] < subTarget) {
                    finalStart = start;
                    int dis = Math.abs(num[start] + num[end] - subTarget);
                    if (dis <= preClosest) {
                        preClosest = dis;
                        start++;
                    } else {
                        break;
                    }
                } else if (num[start] + num[end] > subTarget) {
                    finalEnd = end;
                    int dis = Math.abs(num[start] + num[end] - subTarget);
                    if (dis <= preClosest) {
                        preClosest = dis;
                        end--;
                    } else {
                        break;
                    }
                } else {
                    finalEnd = end;
                    finalStart = start;
                    break;
                }
            }

            if (firstMin) {
                min = num[i] + num[finalStart] + num[finalEnd];
                firstMin = false;
            } else if (Math.abs(min - target) > Math.abs(target - (num[i] + num[finalStart] + num[finalEnd]))) {
                min = num[i] + num[finalStart] + num[finalEnd];
            }
        }
        return min;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
