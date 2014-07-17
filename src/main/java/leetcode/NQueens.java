package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jacob on 2014/5/6.
 */
public class NQueens {

    public static void main(String[] args) {
        NQueens solution = new NQueens();
        List<String[]> result = solution.solveNQueens1(8);
        for (String[] r : result) {
            for (String s : r) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
     * <p/>
     * <p/>
     * <p/>
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * <p/>
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
     * <p/>
     * For example,
     * There exist two distinct solutions to the 4-queens puzzle:
     * <p/>
     * [
     * [".Q..",  // Solution 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p/>
     * ["..Q.",  // Solution 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     *
     * @param n
     * @return
     */
    public List<String[]> solveNQueens(int n) {

        ArrayList<String[]> result = new ArrayList<String[]>();

        HashMap<Integer, Boolean> diagonal1 = new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> diagonal2 = new HashMap<Integer, Boolean>();
        ArrayList<Integer> current = new ArrayList<Integer>();

        find(current, diagonal1, diagonal2, result, n);


        return result;

    }

    private void find(ArrayList<Integer> current, HashMap<Integer, Boolean> diagonal1,
                      HashMap<Integer, Boolean> diagonal2, ArrayList<String[]> result, int n) {
        if (current.size() == n) {
            result.add(getFormartStrings(current));
        } else {
            //find available column
            int row = current.size();
            for (Integer col : available(current, n)) {

                if ((diagonal1.get(row + col) == null || diagonal1.get(row + col) == false) && (diagonal2.get(row - col) == null || diagonal2.get(row - col) == false)) {
                    current.add(col);
                    diagonal1.put(row + col, true);
                    diagonal2.put(row - col, true);
                    find(current, diagonal1, diagonal2, result, n);
                    current.remove(current.size() - 1);
                    diagonal1.put(row + col, false);
                    diagonal2.put(row - col, false);
                }

            }
        }
    }

    private String[] getFormartStrings(ArrayList<Integer> current) {
        String[] temp = new String[current.size()];
        for (int i = 0; i < current.size(); i++) {
            String t = "";
            for (int j = 0; j < current.size(); j++) {
                if (current.get(i) == j) {
                    t += "Q";
                } else {
                    t += ".";
                }
            }
            temp[i] = t;
        }
        return temp;
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


    public List<String[]> solveNQueens1(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            int[][] visited = new int[n][n];
            valid(visited, 0, i, 0, n, result);
        }
        return result;
    }

    private void valid(int[][] visited, int i, int j, int count, int n, ArrayList<String[]> result) {
        visited[i][j] = 1;
        count++;
        if (count == n) {
            //add to result
            result.add(printMap(visited));
            return;
        }

        setInvalidPos(visited, i, j);
        ArrayList<int[]> nexts = findNext(visited, i + 1);
        for (int[] pos : nexts) {
            valid(visited, pos[0], pos[1], count, n, result);
        }
        visited[i][j] = 0;


    }

    private ArrayList<int[]> findNext(int[][] visited, int i) {

        ArrayList<int[]> nexts = new ArrayList<int[]>();


        for (int t = 0; t < visited.length; t++) {
            int[] next = new int[2];
            if (visited[i][t] == 0) {
                next[0] = i;
                next[1] = t;
                nexts.add(next);
            }
        }
        return nexts;
    }


    private void setInvalidPos(int[][] visited, int i, int j) {
        for (int t = 0; t < visited.length; t++) {
            if (visited[i][t] == 0) {
                visited[i][t] = -1;
            }
            if (visited[t][j] == 0) {
                visited[t][j] = -1;
            }
        }
        for (int t = 0; t < visited.length; t++) {
            for (int s = 0; s < visited.length; s++) {
                if (visited[t][s] == 0 && (t - s == i - j || t + s == i + j)) {
                    visited[t][s] = -1;
                }
            }
        }
    }

    private String[] printMap(int[][] visited) {
        String[] map = new String[visited.length];
        for (int i = 0; i < visited.length; i++) {
            String s = "";
            for (int j = 0; j < visited[0].length; j++) {
                s += (visited[i][j] == 1 ? 'Q' : '.');
            }
            map[i] = s;
        }
        return map;
    }


}
