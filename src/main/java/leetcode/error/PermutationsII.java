package leetcode.error;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 2014/5/6.
 */
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        System.out.println(solution.permuteUnique(new int[]{-1, -1, 3,-1}));
    }

    /**
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     * <p/>
     * For example,
     * [1,1,2] have the following unique permutations:
     * [1,1,2], [1,2,1], and [2,1,1].
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        permute(num, 0, num.length, result);
        return result;

    }

    private void permute(int[] num, int start, int end, ArrayList<ArrayList<Integer>> result) {
        if (start == end) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int ii : num) {
                list.add(ii);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < end; i++) {
            if (i != start && num[i] == num[start]) {
                continue;
            }
            swap(num, start, i);
            permute(num, start + 1, end, result);
            swap(num, i, start);
        }
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
