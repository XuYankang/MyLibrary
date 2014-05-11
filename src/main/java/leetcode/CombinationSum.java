package leetcode;

import java.util.ArrayList;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Administrator on 2014/5/6.
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        System.out.println(solution.combinationSum(new int[]{3,7}, 2));
    }

    /**
     * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     * <p/>
     * The same repeated number may be chosen from C unlimited number of times.
     * <p/>
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
     * (ie, a1 ≤ a2 ≤ … ≤ ak).
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set 2,3,6,7 and target 7,
     * A solution set is:
     * [7]
     * [2, 2, 3]
     *
     * @param candidates
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        int index = 0;
        Arrays.sort(candidates);
        combine(candidates, target, result, current, index);
        return result;
    }

    private void combine(int[] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int index) {

        if (candidates[index] == target) {
            current.add(candidates[index]);
            result.add(new ArrayList<Integer>(current));
            current.remove(current.size() - 1);
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            int cur = candidates[i];
            if (cur > target) {
                return;
            }
            current.add(cur);
            combine(candidates, target - cur, result, current, i);
            current.remove(current.size() - 1);
        }


    }


}
