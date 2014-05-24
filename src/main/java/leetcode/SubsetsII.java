package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        System.out.println(solution.subsetsWithDup(new int[]{
                4, 1, 0
        }));
    }

    /**
     * Given a collection of integers that might contain duplicates, S, return all possible subsets.
     * <p/>
     * Note:
     * Elements in a subset must be in non-descending order.
     * The solution set must not contain duplicate subsets.
     * For example,
     * If S = [1,2,2], a solution is:
     * <p/>
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int index = 0;
        ArrayList current = new ArrayList();
        result.add(current);
        findSub(index, num, current, result);
        return result;
    }

    private void findSub(int index, int[] num, ArrayList current, ArrayList<ArrayList<Integer>> result) {

        for (int i = index; i < num.length; i++) {
            if (i == index || num[i - 1] != num[i]) {
                current.add(num[i]);
                result.add(new ArrayList<Integer>(current));
                findSub(i + 1, num, current, result);
                current.remove(current.size() - 1);
            }
        }

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
