package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jacob on 2014/5/6.
 */
public class NQueensII {

    public static void main(String[] args) {
        NQueensII solution = new NQueensII();
        System.out.println(solution.totalNQueens(13));
    }


    /**
     * Follow up for N-Queens problem.
     * <p/>
     * Now, instead outputting board configurations, return the total number of distinct solutions.
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {

        HashMap<Integer, Boolean> diagonal1 = new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> diagonal2 = new HashMap<Integer, Boolean>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        int total = 0;
        return find(current, diagonal1, diagonal2, n);
    }


    private int find(ArrayList<Integer> current, HashMap<Integer, Boolean> diagonal1,
                     HashMap<Integer, Boolean> diagonal2, int n) {
        int result = 0;
        if (current.size() == n) {
            return 1;
        } else {
            //find available column
            int row = current.size();
            for (Integer col : available(current, n)) {

                if ((diagonal1.get(row + col) == null || diagonal1.get(row + col) == false) && (diagonal2.get(row - col) == null || diagonal2.get(row - col) == false)) {
                    current.add(col);
                    diagonal1.put(row + col, true);
                    diagonal2.put(row - col, true);
                    result += find(current, diagonal1, diagonal2, n);
                    current.remove(current.size() - 1);
                    diagonal1.put(row + col, false);
                    diagonal2.put(row - col, false);
                }

            }
        }
        return result;
    }

    private ArrayList<Integer> available(ArrayList<Integer> current, int n) {

        ArrayList<Integer> availableCol = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!current.contains(i)) {
                availableCol.add(i);
            }
        }

        return availableCol;
    }


}
