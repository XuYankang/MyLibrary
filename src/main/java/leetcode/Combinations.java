package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jacob on 2014/5/6.
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations solution = new Combinations();
        ArrayList<Integer> source = new ArrayList<Integer>();
        for (int i = 1; i < 7; i++) {
            source.add(i);
        }
        System.out.println(solution.allOrder(source));
    }

    public ArrayList<ArrayList<Integer>> allOrder(ArrayList<Integer> source) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (source.size() == 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(source.get(0));
            result.add(list);
        } else {
            for (int i : source) {
                ArrayList<Integer> subSource = new ArrayList<Integer>();
                for (int ii : source) {
                    if (ii != i) {
                        subSource.add(ii);
                    }
                }
                for (ArrayList<Integer> l : allOrder(subSource)) {
                    l.add(i);
                    result.add(l);
                }
            }
        }
        return result;
    }

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * <p/>
     * For example,
     * If n = 4 and k = 2, a solution is:
     * <p/>
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @param n
     * @param k
     * @return
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                result.add(list);
            }
        } else {
            for (int i = n; i >= 1; i--) {
                for (ArrayList<Integer> list : combine(i - 1, k - 1)) {
                    list.add(i);
                    result.add(list);
                }
            }
        }
        return result;
    }


}
