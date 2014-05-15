package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 2014/5/6.
 */
public class TheeSum {

    public static void main(String[] args) {
        TheeSum solution = new TheeSum();
        int[] array = {1, 2, -2, -1};
        System.out.println(solution.threeSum(array));
    }

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * <p/>
     * Note:
     * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     * The solution set must not contain duplicate triplets.
     * For example, given array S = {-1 0 1 2 -1 -4},
     * <p/>
     * A solution set is:
     * (-1, 0, 1)
     * (-1, -1, 2)
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 1; i++) {

            if (num[i] <= 0 && (i == 0 || (i != 0 && num[i] != num[i - 1]))) {
                result.addAll(find(num, i + 1));
            }
        }

        return result;

    }

    private ArrayList<ArrayList<Integer>> find(int[] num, int i) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int first = num[i - 1];
        int sum = -first;
        int left = i, right = num.length - 1;
        while (left < right) {
            if (num[left] + num[right] > sum) {
                right--;
            } else if (num[left] + num[right] < sum) {
                left++;

            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(first);
                list.add(num[left]);
                list.add(num[right]);
                left++;
                right--;
                result.add(list);
            }
            while (left != i && num[left] == num[left - 1] && left < right) {
                left++;
            }
            while (right != num.length - 1 && num[right] == num[right + 1] && left < right) {
                right--;
            }
        }
        return result;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
