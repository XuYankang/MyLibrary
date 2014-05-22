package leetcode;

import java.util.ArrayList;

/**
 * Created by Jacob on 2014/5/6.
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    /**
     * Given a collection of numbers, return all possible permutations.
     * <p/>
     * For example,
     * [1,2,3] have the following permutations:
     * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

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
