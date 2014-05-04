package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2014/5/4.
 */
public class Solution0505 {

    public static void main(String[] args) {
        Solution0505 solution = new Solution0505();
        solution.subsetsWithDup(null);
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
     * http://oj.leetcode.com/problems/subsets-ii/
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        //Arrays.sort(num);
        int index = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1)
                ;
        ArrayList<Integer> another = new ArrayList<Integer>(temp);
        temp.add(2);
        System.out.println(another);
        //subSets(num, index, temp, result);
        return null;
    }

    private void subSets(int[] num, int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> list = new ArrayList<Integer>(temp);

    }


}
