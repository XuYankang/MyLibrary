package leetcode;

import java.util.Arrays;

/**
 * Created by Jacob on 2014/5/6.
 */
public class TwoSum {
    /**
     * Two Sum Total
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * <p/>
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * <p/>
     * You may assume that each input would have exactly one solution.
     * <p/>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbers2);
        int start = 0;
        int end = numbers2.length - 1;

        while (start < end) {
            int sum = numbers2[start] + numbers2[end];
            if (sum == target) {

                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        int index1 = -1, index2 = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numbers2[start] && index1 == -1) {
                index1 = i + 1;
            } else if (numbers[i] == numbers2[end]) {
                index2 = i + 1;
            }
        }
        int[] indexes = new int[2];
        indexes[1] = Math.max(index1, index2);
        indexes[0] = Math.min(index1, index2);
        return indexes;
    }
}
